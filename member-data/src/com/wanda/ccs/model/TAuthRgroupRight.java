package com.wanda.ccs.model;

// Generated 2011-11-29 14:55:15 by Hibernate Tools 3.2.4.GA

import com.xcesys.extras.core.dao.model.VersionableEntity;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import static javax.persistence.GenerationType.SEQUENCE;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.persistence.Transient;

/**
 * TAuthRgroupRight generated by hbm2java
 * 权限组中包含的权限
 */
@Entity
@Table(name = "T_AUTH_RGROUP_RIGHT")
public class TAuthRgroupRight extends VersionableEntity implements
		java.io.Serializable {
	private static final long serialVersionUID = 4659303401171927406L;
	
	private Long id;
	private TAuthRight tAuthRight; //权限Id
	private TAuthRgroup tAuthRgroup;//权限组Id
	private String centerLevel;//仅用于区域中心店权限组。非区域中心店权限组取值NULL。R表示该权限赋予区域身份，C表示该权限赋予影城身份。
	private boolean delete;
	public TAuthRgroupRight() {
	}

	public TAuthRgroupRight(TAuthRight tAuthRight, TAuthRgroup tAuthRgroup) {
		this.tAuthRight = tAuthRight;
		this.tAuthRgroup = tAuthRgroup;
	}

	@SequenceGenerator(name = "generator", sequenceName = "S_T_AUTH_RGROUP_RIGHT")
	@Id
	@GeneratedValue(strategy = SEQUENCE, generator = "generator")
	@Column(name = "AUTH_RGROUP_RIGHT_ID", unique = true, nullable = false, precision = 38, scale = 0)
	public Long getId() {
		return this.id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "AUTH_RIGHT_ID", nullable = false)
	public TAuthRight gettAuthRight() {
		return this.tAuthRight;
	}

	public void settAuthRight(TAuthRight tAuthRight) {
		this.tAuthRight = tAuthRight;
	}

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "AUTH_RGROUP_ID", nullable = false)
	public TAuthRgroup gettAuthRgroup() {
		return this.tAuthRgroup;
	}

	public void settAuthRgroup(TAuthRgroup tAuthRgroup) {
		this.tAuthRgroup = tAuthRgroup;
	}
	
	@Column(name = "CENTER_LEVEL", nullable = true)
	public String getCenterLevel() {
		return centerLevel;
	}

	public void setCenterLevel(String centerLevel) {
		this.centerLevel = centerLevel;
	}
	
	@Transient
	public boolean getDelete() {
		return delete;
	}

	public void setDelete(boolean delete) {
		this.delete = delete;
	}
}
