package com.wanda.mrb.intf.member;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.Date;

import org.w3c.dom.Element;

import com.wanda.mrb.intf.ConstDef;
import com.wanda.mrb.intf.SQLConstDef;
import com.wanda.mrb.intf.ServiceBase;
import com.wanda.mrb.intf.exception.BusinessException;
import com.wanda.mrb.intf.utils.MemberUtils;
import com.wanda.mrb.intf.utils.ResultQuery;
import com.wanda.mrb.intf.utils.SqlHelp;
import com.wanda.mrb.intf.utils.VoucherCodeUtil;
import com.wanda.mrb.intf.utils.VoucherNumberEncoder;

public class BindVoucher extends ServiceBase {

	private int memberId;
	private String toMemberNo;
	private String voucherNumber;
	private String bindFlag;// 绑定类型
	private boolean inPoolFlag = false;// 是否在库中
	private String bindMemberId;// 用来判断是否被绑定
	private boolean bindMemberFlag = false;// 用来判断是否被绑定
	private boolean bindThisMemberFlag = false;// 用来判断是否被绑定到该会员

	public BindVoucher() {
		super();
		super.intfCode = ConstDef.CONST_INTFCODE_M_BINDVOUCHER;
		this.timeOutFlag = true;
	}

	@Override
	protected void bizPerform() throws Exception {
		Connection conn = getDBConnection();
		memberId = this.checkMember(conn,memberNo);

		// 判断券是否存在
		ResultQuery rsq = SqlHelp.query(conn,
				SQLConstDef.QUERY_VOUCHER_BY_BARCODE,
				VoucherNumberEncoder.md5Encrypt(voucherNumber));
		ResultSet rs = rsq.getResultSet();
		if (rs == null || !rs.next()) {
			throwsBizException("M090001", "券不存在或券不可用！");
		}
		if (!MemberUtils.compareDateTime(rs.getDate("EXPIRY_DATE"), new Date())) {
			throw new BusinessException(ConstDef.CONST_RESPCODE_VOUCHER_EXPIRED,"券已到期");
		}
		if(!"A".equals(rs.getString("VOUCHER_STATUS"))){
			throw new BusinessException(ConstDef.CONST_RESPCODE_UN_CHANGE,"券状态未非启用状态");
		}
		rsq.free();

		// 判断券是否在券库中，是否已绑定
		rsq = SqlHelp.query(conn, SQLConstDef.QUERY_VOUCHER_POOL_BY_BARCODE,
				VoucherNumberEncoder.md5Encrypt(voucherNumber));
		rs = rsq.getResultSet();
		if (rs != null && rs.next()) {
			bindMemberId = rs.getString("MEMBER_ID");
			inPoolFlag = true;// 在券库中
			if (bindMemberId != null && !"".equals(bindMemberId)) {// 已绑定
				bindMemberFlag = true;// 已绑定
				// 判断该券是否绑定到了该会员
				PreparedStatement psBindThisMember = conn
						.prepareStatement(SQLConstDef.CHECK_VOUCHER_REL);
				psBindThisMember.setString(1, this.memberNo);
				psBindThisMember.setString(2,
						VoucherNumberEncoder.md5Encrypt(this.voucherNumber));
				ResultSet rsBindThisMember = psBindThisMember.executeQuery();
				if (rsBindThisMember != null && rsBindThisMember.next()) {
					bindThisMemberFlag = true;// 券绑定到了该会员
				} else {
					bindThisMemberFlag = false;// 券没有绑定到该会员
				}
			} else {// 未绑定
				bindMemberFlag = false;// 未绑定
			}
		} else {
			inPoolFlag = false;// 不在券库中
		}
		rsq.free();

		// 开始进行绑定
		if ("1".equals(bindFlag)) {// 1.绑定
			if (inPoolFlag) {// 在券库中
				if (bindMemberFlag && !bindThisMemberFlag) {// 该券如果绑定了会员但没有绑定该会员
					throwsBizException("M090002", "该券已经绑定到其他会员！");
				} else if(bindThisMemberFlag){
					throwsBizException("M090007", "该券已经绑定到该会员！");
				} else {// 只要该券没有绑定到其他会员，就可以进行绑定
					SqlHelp.operate(conn,
							SQLConstDef.UPDATE_MEMBER_VOUCHER_REL,
							String.valueOf(memberId),
							"2", //补充缺少的参数，Fixed by Zhang Chen Long(2014-04-29)
							VoucherNumberEncoder.md5Encrypt(voucherNumber));
					SqlHelp.operate(conn, SQLConstDef.INSERT_MEMBER_VOUCHER_LOG,
							VoucherNumberEncoder.md5Encrypt(voucherNumber),
							String.valueOf(memberId),
							"",
							"2");
				}
			} else {// 不在券库中，绑定
				SqlHelp.operate(conn, SQLConstDef.INSERT_MEMBER_VOUCHER_REL,
						VoucherCodeUtil.desEncrypt(voucherNumber),
						VoucherNumberEncoder.md5Encrypt(voucherNumber),
						String.valueOf(memberId),
						"2");
				SqlHelp.operate(conn, SQLConstDef.INSERT_MEMBER_VOUCHER_LOG,
						VoucherNumberEncoder.md5Encrypt(voucherNumber),
						String.valueOf(memberId),
						"",
						"2");
			}
		} else if ("2".equals(bindFlag)) {// 2.解绑
			if (!bindMemberFlag) {
				throwsBizException("M090003", "该券未绑定会员，不能解绑！");
			} else if (!bindThisMemberFlag) {// 该券和该会员没有绑定关系
				throwsBizException("M090004", "该券和该会员没有绑定关系，不能解绑！");
			} else {// 解绑
				SqlHelp.operate(conn, SQLConstDef.DELETE_MEMBER_VOUCHER_REL,
						VoucherNumberEncoder.md5Encrypt(voucherNumber));
				SqlHelp.operate(conn, SQLConstDef.INSERT_MEMBER_VOUCHER_LOG,
						VoucherNumberEncoder.md5Encrypt(voucherNumber),
						String.valueOf(memberId),
						"",
						"4");
			}
		} else if ("3".equals(bindFlag)) {// 3.赠送
			this.checkMember(conn, toMemberNo);
			int toMemberId = 0;
			if (null != toMemberNo || "".equals(toMemberNo)) {
				toMemberId = this.checkMember(conn, toMemberNo);// 验证转送会员是否存在
			}
			if (!bindThisMemberFlag) {
				throwsBizException("M090005", "该会员没有绑定该券，该会员不能赠送该券！");
			} else {
				//解绑
				SqlHelp.operate(conn, SQLConstDef.DELETE_MEMBER_VOUCHER_REL,
						VoucherNumberEncoder.md5Encrypt(voucherNumber));
				//送人
				SqlHelp.operate(conn,
						SQLConstDef.UPDATE_MEMBER_VOUCHER_REL,
						String.valueOf(toMemberId),
						"3",
						VoucherNumberEncoder.md5Encrypt(voucherNumber));
				SqlHelp.operate(conn, SQLConstDef.INSERT_MEMBER_VOUCHER_LOG,
						VoucherNumberEncoder.md5Encrypt(voucherNumber),
						String.valueOf(memberId),
						String.valueOf(toMemberId),
						"3");
			}
		}
		rsq.free();
	}

	@Override
	protected void parseXMLParam(Element root) throws Exception {
		memberNo = getChildValueByName(root, "MEMBER_NO", 64);
		toMemberNo = getChildValueByName(root, "TO_MEMBER_NO", 64);
		voucherNumber = getChildValueByName(root, "VOUCHER_NUMBER", 64);
		bindFlag = getChildValueByName(root, "BIND_TYPE", 64);
		if("".equals(bindFlag)){
			throwsBizException("M090006", "绑定类型不能为空！");
		}
	}

	@Override
	protected String composeXMLBody() {
		return null;
	}

}
