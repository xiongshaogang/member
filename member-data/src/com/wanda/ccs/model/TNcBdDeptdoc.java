package com.wanda.ccs.model;

// Generated 2012-1-12 17:18:19 by Hibernate Tools 3.2.4.GA

import static javax.persistence.GenerationType.SEQUENCE;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.persistence.Transient;

import com.xcesys.extras.core.dao.model.AbstractEntity;

/**
 * TNcBdDeptdoc generated by hbm2java
 */
@Entity
@Table(name = "T_NC_BD_DEPTDOC")
public class TNcBdDeptdoc extends AbstractEntity implements
		java.io.Serializable {
	private static final long serialVersionUID = -5930935806201289953L;
	
	private String pkDeptdoc;
	private Integer dr;
	private String ts;
	private String pkCorp;
	private String pkFathedept;
	private String deptattr;
	private String pkPsndoc;
	private String phone;
	private String addr;
	private String pkCalbody;
	private Integer orgtype;
	private String deptduty;
	private String createdate;
	private String resposition;
	private String remcode;
	private String deptlevel;
	private Integer xtersysflag;
	private String deptcode;
	private String deptname;
	private String canceled;
	private String canceldate;
	private String hrcanceled;
	private Integer depttype;
	private String innercode;
	private String maxinnercode;
	
	private boolean hasChild;
	public TNcBdDeptdoc() {
	}

	public TNcBdDeptdoc(String deptattr, String deptcode, String deptname,
			String canceled, String hrcanceled) {
		this.deptattr = deptattr;
		this.deptcode = deptcode;
		this.deptname = deptname;
		this.canceled = canceled;
		this.hrcanceled = hrcanceled;
	}

	public TNcBdDeptdoc(Integer dr, String ts, String pkCorp,
			String pkFathedept, String deptattr, String pkPsndoc, String phone,
			String addr, String pkCalbody, Integer orgtype, String deptduty,
			String createdate, String resposition, String remcode,
			String deptlevel, Integer xtersysflag, String deptcode,
			String deptname, String canceled, String canceldate,
			String hrcanceled, Integer depttype, String innercode,
			String maxinnercode) {
		this.dr = dr;
		this.ts = ts;
		this.pkCorp = pkCorp;
		this.pkFathedept = pkFathedept;
		this.deptattr = deptattr;
		this.pkPsndoc = pkPsndoc;
		this.phone = phone;
		this.addr = addr;
		this.pkCalbody = pkCalbody;
		this.orgtype = orgtype;
		this.deptduty = deptduty;
		this.createdate = createdate;
		this.resposition = resposition;
		this.remcode = remcode;
		this.deptlevel = deptlevel;
		this.xtersysflag = xtersysflag;
		this.deptcode = deptcode;
		this.deptname = deptname;
		this.canceled = canceled;
		this.canceldate = canceldate;
		this.hrcanceled = hrcanceled;
		this.depttype = depttype;
		this.innercode = innercode;
		this.maxinnercode = maxinnercode;
	}

	@SequenceGenerator(name = "generator", sequenceName = "S_T_NC_BD_DEPTDOC")
	@Id
	@GeneratedValue(strategy = SEQUENCE, generator = "generator")
	@Column(name = "PK_DEPTDOC", unique = true, nullable = false, length = 20)
	public String getPkDeptdoc() {
		return this.pkDeptdoc;
	}

	public void setPkDeptdoc(String pkDeptdoc) {
		this.pkDeptdoc = pkDeptdoc;
	}

	@Column(name = "DR", precision = 22, scale = 0)
	public Integer getDr() {
		return this.dr;
	}

	public void setDr(Integer dr) {
		this.dr = dr;
	}

	@Column(name = "TS", length = 19)
	public String getTs() {
		return this.ts;
	}

	public void setTs(String ts) {
		this.ts = ts;
	}

	@Column(name = "PK_CORP", length = 4)
	public String getPkCorp() {
		return this.pkCorp;
	}

	public void setPkCorp(String pkCorp) {
		this.pkCorp = pkCorp;
	}

	@Column(name = "PK_FATHEDEPT", length = 20)
	public String getPkFathedept() {
		return this.pkFathedept;
	}

	public void setPkFathedept(String pkFathedept) {
		this.pkFathedept = pkFathedept;
	}

	@Column(name = "DEPTATTR", nullable = false, length = 8)
	public String getDeptattr() {
		return this.deptattr;
	}

	public void setDeptattr(String deptattr) {
		this.deptattr = deptattr;
	}

	@Column(name = "PK_PSNDOC", length = 20)
	public String getPkPsndoc() {
		return this.pkPsndoc;
	}

	public void setPkPsndoc(String pkPsndoc) {
		this.pkPsndoc = pkPsndoc;
	}

	@Column(name = "PHONE", length = 30)
	public String getPhone() {
		return this.phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	@Column(name = "ADDR", length = 80)
	public String getAddr() {
		return this.addr;
	}

	public void setAddr(String addr) {
		this.addr = addr;
	}

	@Column(name = "PK_CALBODY", length = 20)
	public String getPkCalbody() {
		return this.pkCalbody;
	}

	public void setPkCalbody(String pkCalbody) {
		this.pkCalbody = pkCalbody;
	}

	@Column(name = "ORGTYPE", precision = 22, scale = 0)
	public Integer getOrgtype() {
		return this.orgtype;
	}

	public void setOrgtype(Integer orgtype) {
		this.orgtype = orgtype;
	}

	@Column(name = "DEPTDUTY", length = 1000)
	public String getDeptduty() {
		return this.deptduty;
	}

	public void setDeptduty(String deptduty) {
		this.deptduty = deptduty;
	}

	@Column(name = "CREATEDATE", length = 10)
	public String getCreatedate() {
		return this.createdate;
	}

	public void setCreatedate(String createdate) {
		this.createdate = createdate;
	}

	@Column(name = "RESPOSITION", length = 20)
	public String getResposition() {
		return this.resposition;
	}

	public void setResposition(String resposition) {
		this.resposition = resposition;
	}

	@Column(name = "REMCODE", length = 50)
	public String getRemcode() {
		return this.remcode;
	}

	public void setRemcode(String remcode) {
		this.remcode = remcode;
	}

	@Column(name = "DEPTLEVEL", length = 20)
	public String getDeptlevel() {
		return this.deptlevel;
	}

	public void setDeptlevel(String deptlevel) {
		this.deptlevel = deptlevel;
	}

	@Column(name = "XTERSYSFLAG", precision = 22, scale = 0)
	public Integer getXtersysflag() {
		return this.xtersysflag;
	}

	public void setXtersysflag(Integer xtersysflag) {
		this.xtersysflag = xtersysflag;
	}

	@Column(name = "DEPTCODE", nullable = false, length = 40)
	public String getDeptcode() {
		return this.deptcode;
	}

	public void setDeptcode(String deptcode) {
		this.deptcode = deptcode;
	}

	@Column(name = "DEPTNAME", nullable = false, length = 200)
	public String getDeptname() {
		return this.deptname;
	}

	public void setDeptname(String deptname) {
		this.deptname = deptname;
	}

	@Column(name = "CANCELED", nullable = false, length = 1)
	public String getCanceled() {
		return this.canceled;
	}

	public void setCanceled(String canceled) {
		this.canceled = canceled;
	}

	@Column(name = "CANCELDATE", length = 10)
	public String getCanceldate() {
		return this.canceldate;
	}

	public void setCanceldate(String canceldate) {
		this.canceldate = canceldate;
	}

	@Column(name = "HRCANCELED", nullable = false, length = 1)
	public String getHrcanceled() {
		return this.hrcanceled;
	}

	public void setHrcanceled(String hrcanceled) {
		this.hrcanceled = hrcanceled;
	}

	@Column(name = "DEPTTYPE", precision = 22, scale = 0)
	public Integer getDepttype() {
		return this.depttype;
	}

	public void setDepttype(Integer depttype) {
		this.depttype = depttype;
	}

	@Column(name = "INNERCODE", length = 60)
	public String getInnercode() {
		return this.innercode;
	}

	public void setInnercode(String innercode) {
		this.innercode = innercode;
	}

	@Column(name = "MAXINNERCODE", length = 60)
	public String getMaxinnercode() {
		return this.maxinnercode;
	}

	public void setMaxinnercode(String maxinnercode) {
		this.maxinnercode = maxinnercode;
	}
	
	@Transient
	public boolean getHasChild() {
		return hasChild;
	}

	public void setHasChild(boolean hasChild) {
		this.hasChild = hasChild;
	}

	@Override
	@Transient
	public Long getId() {
		return null;
	}

	@Override
	public void setId(Long arg0) {
		
	}

}
