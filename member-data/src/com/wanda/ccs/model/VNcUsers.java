package com.wanda.ccs.model;

// Generated 2012-1-12 17:18:39 by Hibernate Tools 3.2.4.GA


import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Transient;

import com.xcesys.extras.core.dao.model.AbstractEntity;

/**
 * VNcUsers generated by hbm2java
 */
@Entity
@Table(name = "V_NC_USERS")
public class VNcUsers extends AbstractEntity implements java.io.Serializable {
	private static final long serialVersionUID = 1167233884935360184L;
	
	private String pkPsndoc;  
	private String pkPsnbasdoc;
	private String pkDeptdoc;
	private Integer psnclscope;
	private String pkCorp;
	private String psnname;
	private String sex;
	private String uintcode;
	private String uintname;
	private String deptcode;
	private String deptname;
	private Integer showorder;
	
	private String stringDept;

	public VNcUsers() {
	}
	
	@Id
	@Column(name = "PK_PSNDOC", nullable = false, length = 20)
	public String getPkPsndoc() {
		return this.pkPsndoc;
	}

	public void setPkPsndoc(String pkPsndoc) {
		this.pkPsndoc = pkPsndoc;
	}

	@Column(name = "PK_PSNBASDOC", length = 20)
	public String getPkPsnbasdoc() {
		return this.pkPsnbasdoc;
	}

	public void setPkPsnbasdoc(String pkPsnbasdoc) {
		this.pkPsnbasdoc = pkPsnbasdoc;
	}

	@Column(name = "PK_DEPTDOC", length = 20)
	public String getPkDeptdoc() {
		return this.pkDeptdoc;
	}

	public void setPkDeptdoc(String pkDeptdoc) {
		this.pkDeptdoc = pkDeptdoc;
	}

	@Column(name = "PSNNAME", length = 200)
	public String getPsnname() {
		return this.psnname;
	}

	public void setPsnname(String psnname) {
		this.psnname = psnname;
	}

	@Column(name = "PSNCLSCOPE", precision = 22, scale = 0)
	public Integer getPsnclscope() {
		return this.psnclscope;
	}

	public void setPsnclscope(Integer psnclscope) {
		this.psnclscope = psnclscope;
	}

	@Column(name = "SHOWORDER", precision = 22, scale = 0)
	public Integer getShoworder() {
		return this.showorder;
	}

	public void setShoworder(Integer showorder) {
		this.showorder = showorder;
	}
	
	@Column(name = "PK_CORP", length = 4)
	public String getPkCorp() {
		return pkCorp;
	}

	public void setPkCorp(String pkCorp) {
		this.pkCorp = pkCorp;
	}
	
	@Column(name = "SEX", length = 20)
	public String getSex() {
		return sex;
	}

	public void setSex(String sex) {
		this.sex = sex;
	}
	

	@Column(name = "UNITCODE", length = 40)
	public String getUintcode() {
		return uintcode;
	}

	public void setUintcode(String uintcode) {
		this.uintcode = uintcode;
	}
	
	@Column(name = "UNITNAME", length = 200)
	public String getUintname() {
		return uintname;
	}

	public void setUintname(String uintname) {
		this.uintname = uintname;
	}
	
	@Column(name = "DEPTCODE", length = 40)
	public String getDeptcode() {
		return deptcode;
	}
	
	@Column(name = "DEPTNAME", length = 200)
	public void setDeptcode(String deptcode) {
		this.deptcode = deptcode;
	}

	public String getDeptname() {
		return deptname;
	}

	public void setDeptname(String deptname) {
		this.deptname = deptname;
	}


	
	@Override
	@Transient
	public Long getId() {
		
		return null;
	}

	@Override
	public void setId(Long arg0) {
		
	}
	
	@Transient
	public String getStringDept() {
		return stringDept;
	}

	public void setStringDept(String stringDept) {
		this.stringDept = stringDept;
	}

}
