package com.wanda.ccs.model;

import static javax.persistence.GenerationType.SEQUENCE;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import com.xcesys.extras.core.dao.model.VersionableEntity;

/**
 * TVoucherUseLog generated by hbm2java
 */
@Entity
@Table(name = "T_VOUCHER_GOODS_LOG")
public class TVoucherGoodsLog extends VersionableEntity implements
		java.io.Serializable {
	private Long id;  //回兑ID
	private String goodsId;  //卖品编号
	private String goodsName; //卖品名称
	private Long goodsCount;  //卖品数量
	private Long charge;    //用于支付卖品的总金额
	private String isPkg;  //是否
	private TVoucherUseLog tVoucherUseLog; //券回兑记录编号
	private Long voucherUseLogId;

	@SequenceGenerator(name = "generator", sequenceName = "S_T_VOUCHER_GOODS_LOG")
	@Id
	@GeneratedValue(strategy = SEQUENCE, generator = "generator")
	@Column(name = "VOUCHER_GOODS_LOG_ID", unique = true, nullable = false, precision = 38, scale = 0)
	public Long getId() {
		return this.id;
	}

	public void setId(Long id) {
		this.id = id;
	}
	
	@Column(name = "GOODS_ID", length = 100)
	public String getGoodsId() {
		return goodsId;
	}

	public void setGoodsId(String goodsId) {
		this.goodsId = goodsId;
	}

	@Column(name = "GOODS_NAME", length = 500)
	public String getGoodsName() {
		return goodsName;
	}

	public void setGoodsName(String goodsName) {
		this.goodsName = goodsName;
	}

	@Column(name = "GOODS_COUNT", precision = 38, scale = 0)
	public Long getGoodsCount() {
		return goodsCount;
	}

	public void setGoodsCount(Long goodsCount) {
		this.goodsCount = goodsCount;
	}

	@Column(name = "CHARGE", precision = 10 )
	public Long getCharge() {
		return charge;
	}

	public void setCharge(Long charge) {
		this.charge = charge;
	}

	@Column(name = "IS_PKG", length = 1 )
	public String getIsPkg() {
		return isPkg;
	}

	public void setIsPkg(String isPkg) {
		this.isPkg = isPkg;
	}

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "VOUCHER_USE_LOG_ID", nullable = false, insertable = false, updatable = false)
	public TVoucherUseLog gettVoucherUseLog() {
		return tVoucherUseLog;
	}

	public void settVoucherUseLog(TVoucherUseLog tVoucherUseLog) {
		this.tVoucherUseLog = tVoucherUseLog;
	}

	@Column(name = "VOUCHER_USE_LOG_ID", nullable = false)
	public Long getVoucherUseLogId() {
		return voucherUseLogId;
	}

	public void setVoucherUseLogId(Long voucherUseLogId) {
		this.voucherUseLogId = voucherUseLogId;
	}

}
