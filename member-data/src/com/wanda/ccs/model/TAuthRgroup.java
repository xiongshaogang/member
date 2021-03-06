package com.wanda.ccs.model;

// Generated 2011-11-29 14:55:15 by Hibernate Tools 3.2.4.GA

import com.xcesys.extras.core.dao.model.VersionableEntity;
import java.util.HashSet;
import java.util.Set;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;

import static javax.persistence.GenerationType.SEQUENCE;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.FetchMode;

/**
 * TAuthRgroup generated by hbm2java
 * 权限组
 */
@Entity
@Table(name = "T_AUTH_RGROUP")
public class TAuthRgroup extends VersionableEntity implements
		java.io.Serializable {
	private static final long serialVersionUID = 9144644817649558022L;
	
	private Long id;
	private String groupName;//权限组的名称
	private String forGroup;//Y表示可以赋予给院线级用户
	private String forRegion;//Y表示可以赋予给区域级用户
	private String forCinema;//Y表示可以赋予给影城级用户
	private String forCenter = "N";// 'Y表示可以赋予区域中心店用户。FOR_CENTER为Y时，忽略FOR_GROUP，FOR_REGION和FOR_CINEMA的值。';
	private Set<TAuthUserRgroup> tAuthUserRgroups = new HashSet<TAuthUserRgroup>(
			0);
	private Set<TAuthDeptRgroup> tAuthDeptRgroups = new HashSet<TAuthDeptRgroup>(
			0);
	private Set<TAuthRgroupRight> tAuthRgroupRights = new HashSet<TAuthRgroupRight>(
			0);

	public TAuthRgroup() {
	}

	public TAuthRgroup(String forGroup, String forRegion, String forCinema) {
		this.forGroup = forGroup;
		this.forRegion = forRegion;
		this.forCinema = forCinema;
	}

	public TAuthRgroup(String groupName, String forGroup, String forRegion,
			String forCinema, Set<TAuthUserRgroup> tAuthUserRgroups,
			Set<TAuthDeptRgroup> tAuthDeptRgroups,
			Set<TAuthRgroupRight> tAuthRgroupRights) {
		this.groupName = groupName;
		this.forGroup = forGroup;
		this.forRegion = forRegion;
		this.forCinema = forCinema;
		this.tAuthUserRgroups = tAuthUserRgroups;
		this.tAuthDeptRgroups = tAuthDeptRgroups;
		this.tAuthRgroupRights = tAuthRgroupRights;
	}

	@SequenceGenerator(name = "generator", sequenceName = "S_T_AUTH_RGROUP")
	@Id
	@GeneratedValue(strategy = SEQUENCE, generator = "generator")
	@Column(name = "AUTH_RGROUP_ID", unique = true, nullable = false, precision = 38, scale = 0)
	public Long getId() {
		return this.id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	@Column(name = "GROUP_NAME",length=500)
	public String getGroupName() {
		return this.groupName;
	}

	public void setGroupName(String groupName) {
		this.groupName = groupName;
	}

	@Column(name = "FOR_GROUP", nullable = false, length = 1)
	public String getForGroup() {
		return this.forGroup;
	}

	public void setForGroup(String forGroup) {
		this.forGroup = forGroup;
	}

	@Column(name = "FOR_REGION", nullable = false, length = 1)
	public String getForRegion() {
		return this.forRegion;
	}

	public void setForRegion(String forRegion) {
		this.forRegion = forRegion;
	}

	@Column(name = "FOR_CINEMA", nullable = false, length = 1)
	public String getForCinema() {
		return this.forCinema;
	}

	public void setForCinema(String forCinema) {
		this.forCinema = forCinema;
	}
	
	@Column(name = "FOR_CENTER", nullable = false, length = 1)
	public String getForCenter() {
		return forCenter;
	}

	public void setForCenter(String forCenter) {
		this.forCenter = forCenter;
	}

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "tAuthRgroup")
	public Set<TAuthUserRgroup> gettAuthUserRgroups() {
		return this.tAuthUserRgroups;
	}

	public void settAuthUserRgroups(Set<TAuthUserRgroup> tAuthUserRgroups) {
		this.tAuthUserRgroups = tAuthUserRgroups;
	}

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "tAuthRgroup")
	public Set<TAuthDeptRgroup> gettAuthDeptRgroups() {
		return this.tAuthDeptRgroups;
	}

	public void settAuthDeptRgroups(Set<TAuthDeptRgroup> tAuthDeptRgroups) {
		this.tAuthDeptRgroups = tAuthDeptRgroups;
	}
	
	
	@OneToMany(fetch = FetchType.EAGER, mappedBy = "tAuthRgroup")
	@Fetch(FetchMode.SUBSELECT)
	public Set<TAuthRgroupRight> gettAuthRgroupRights() {
		return this.tAuthRgroupRights;
	}

	public void settAuthRgroupRights(Set<TAuthRgroupRight> tAuthRgroupRights) {
		this.tAuthRgroupRights = tAuthRgroupRights;
	}
	
}
