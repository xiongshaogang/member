package com.wanda.ccs.model;

// Generated 2011-10-20 16:15:19 by Hibernate Tools 3.4.0.CR1

import static javax.persistence.GenerationType.SEQUENCE;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OrderBy;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.hibernate.annotations.Cache;
import org.hibernate.annotations.CacheConcurrencyStrategy;
import org.hibernate.validator.constraints.Length;
import org.hibernate.validator.constraints.NotEmpty;

/**
 * TScheduleGuideH generated by hbm2java
 */
@Entity
@Table(name = "T_SCHEDULE_GUIDE_H")
@org.hibernate.annotations.Entity(dynamicUpdate = true, dynamicInsert = true)
@Cache(usage = CacheConcurrencyStrategy.READ_WRITE)
public class TScheduleGuideH extends AbstractStateUVEntity implements
		java.io.Serializable {

	private static final long serialVersionUID = -7206831891068424979L;
	private Long id;
	private String issue; // 期数
	private String ver; // 版本
	private Date suitStartDate;
	private Date suitEndDate;
	private String instruction;// 简要说明
	private String deliverance;// 审核意见
	private List<TScheduleGuideB> tScheduleGuideBs = new ArrayList<TScheduleGuideB>();
	
	
	private String suitRegion;// 适用区域(为空表示所有区域)
	private Long suitCinemaId; // 适用影院(为空表示所有影院)
	private TCinema tCinema;

	public TScheduleGuideH() {
	}

	public TScheduleGuideH(TCinema tCinema, String issue, String ver,
			String suitRegion, Date suitStartDate, Date suitEndDate,
			String instruction, String deliverance,List<TScheduleGuideB> tScheduleGuideBs) {
		this.tCinema = tCinema;
		this.issue = issue;
		this.ver = ver;
		this.suitRegion = suitRegion;
		this.suitStartDate = suitStartDate;
		this.suitEndDate = suitEndDate;
		this.deliverance = deliverance;
		this.instruction = instruction;
		this.tScheduleGuideBs = tScheduleGuideBs;
	}

	@SequenceGenerator(name = "generator", sequenceName = "S_T_SCHEDULE_GUIDE_H")
	@Id
	@GeneratedValue(strategy = SEQUENCE, generator = "generator")
	@Column(name = "SEQID", unique = true, nullable = false, precision = 38, scale = 0)
	public Long getId() {
		return this.id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	@Column(name = "DELIVERANCE", length = 200)
	public String getDeliverance() {
		return deliverance;
	}

	public void setDeliverance(String deliverance) {
		this.deliverance = deliverance;
	}

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "SUIT_CINEMA_ID", insertable = false, updatable = false)
	@Cache(usage = CacheConcurrencyStrategy.READ_WRITE)
	public TCinema gettCinema() {
		return this.tCinema;
	}

	public void settCinema(TCinema tCinema) {
		this.tCinema = tCinema;
	}

	// @NotEmpty
	// @Length(min=0,max=10,message="抱歉，期数最大长度为6")
	@Column(name = "ISSUE", length = 20)
	public String getIssue() {
		return this.issue;
	}

	public void setIssue(String issue) {
		this.issue = issue;
	}

	@NotEmpty
	@Length(min = 0, max = 2, message = "抱歉，版本号最大长度为2")
	@Column(name = "VER", length = 2)
	public String getVer() {
		return this.ver;
	}

	public void setVer(String ver) {
		this.ver = ver;
	}

	@Column(name = "SUIT_REGION", length = 2)
	public String getSuitRegion() {
		return this.suitRegion;
	}

	public void setSuitRegion(String suitRegion) {
		this.suitRegion = suitRegion;
	}

	@Column(name = "SUIT_START_DATE")
	@Temporal(TemporalType.DATE)
	public Date getSuitStartDate() {
		return this.suitStartDate;
	}

	public void setSuitStartDate(Date suitStartDate) {
		this.suitStartDate = suitStartDate;
	}

	@Column(name = "SUIT_END_DATE", length = 7)
	@Temporal(TemporalType.DATE)
	public Date getSuitEndDate() {
		return this.suitEndDate;
	}

	public void setSuitEndDate(Date suitEndDate) {
		this.suitEndDate = suitEndDate;
	}

	@Column(name = "INSTRUCTION", length = 300)
	public String getInstruction() {
		return this.instruction;
	}

	public void setInstruction(String instruction) {
		this.instruction = instruction;
	}

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "tScheduleGuideH", cascade = CascadeType.ALL, orphanRemoval = true)
	@Cache(usage = CacheConcurrencyStrategy.READ_WRITE)
	@OrderBy("id")
	public List<TScheduleGuideB> gettScheduleGuideBs() {
		return this.tScheduleGuideBs;
	}

	public void settScheduleGuideBs(List<TScheduleGuideB> tScheduleGuideBs) {
		this.tScheduleGuideBs = tScheduleGuideBs;
	}

	@Column(name = "SUIT_CINEMA_ID", precision = 38, scale = 0)
	public Long getSuitCinemaId() {
		return suitCinemaId;
	}

	public void setSuitCinemaId(Long suitCinemaId) {
		this.suitCinemaId = suitCinemaId;
	}

}
