package com.wanda.ccs.model;

// Generated 2013-5-31 11:41:36 by Hibernate Tools 3.4.0.CR1

import static javax.persistence.GenerationType.SEQUENCE;

import java.util.Date;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import com.xcesys.extras.core.dao.model.BlameableEntity;

/**
 * TMackDaddyCardOrder generated by hbm2java
 */
@Entity
@Table(name = "T_MACK_DADDY_CARD_ORDER")
public class TMackDaddyCardOrder extends BlameableEntity implements
		java.io.Serializable {
	private static final long serialVersionUID = 7285900892752567279L;
	
	private Long id;
	private Long cinemaId;
	private TCinema tCinema;
	private String regionCode;
	private Long numberOfCards;
	private String startNo;
	private String endNo;
	private String status;//A待审核 P审核通过  F审核拒绝  X审核取消
	private String submitBy;
	private Date submitTime;
	private String submitById;
	private String approveBy;
	private Date approveTime;
	private String approveById;
	private String description;// 说明
	private String oaId;
	private Set<TMackDaddyCard> tMackDaddyCards = new HashSet<TMackDaddyCard>(0);
	
	private Set<TMackDaddyCardOrderLog> tMackDaddyCardOrderLogs = new HashSet<TMackDaddyCardOrderLog>(
			0);
	
	private String dealStatus;//处理状态 入库成功S;数据有误E;等待入库W;P 处理中

	public TMackDaddyCardOrder() {
	}

	@SequenceGenerator(name = "generator", sequenceName = "S_T_MACK_DADDY_CARD_ORDER", allocationSize = 1)
	@Id
	@GeneratedValue(strategy = SEQUENCE, generator = "generator")
	@Column(name = "MACK_DADDY_CARD_ORDER_ID", unique = true, nullable = false, precision = 22, scale = 0)
	public Long getId() { 
		return this.id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	@Column(name = "CINEMA_ID", nullable = false, precision = 22, scale = 0)
	public Long getCinemaId() {
		return this.cinemaId;
	}

	public void setCinemaId(Long cinemaId) {
		this.cinemaId = cinemaId;
	}

	@Column(name = "REGION_CODE", length = 128)
	public String getRegionCode() {
		return this.regionCode;
	}

	public void setRegionCode(String regionCode) {
		this.regionCode = regionCode;
	}

	@Column(name = "NUMBER_OF_CARDS", precision = 22, scale = 0)
	public Long getNumberOfCards() {
		return this.numberOfCards;
	}

	public void setNumberOfCards(Long numberOfCards) {
		this.numberOfCards = numberOfCards;
	}

	@Column(name = "START_NO", length = 128)
	public String getStartNo() {
		return this.startNo;
	}

	public void setStartNo(String startNo) {
		this.startNo = startNo;
	}

	@Column(name = "END_NO", length = 128)
	public String getEndNo() {
		return this.endNo;
	}

	public void setEndNo(String endNo) {
		this.endNo = endNo;
	}

	@Column(name = "STATUS", length = 10)
	public String getStatus() {
		return this.status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	@Column(name = "SUBMIT_BY", length = 128)
	public String getSubmitBy() {
		return this.submitBy;
	}

	public void setSubmitBy(String submitBy) {
		this.submitBy = submitBy;
	}

	@Column(name = "SUBMIT_TIME")
	public Date getSubmitTime() {
		return this.submitTime;
	}

	public void setSubmitTime(Date submitTime) {
		this.submitTime = submitTime;
	}

	@Column(name = "SUBMIT_BY_ID", length = 40)
	public String getSubmitById() {
		return this.submitById;
	}

	public void setSubmitById(String submitById) {
		this.submitById = submitById;
	}

	@Column(name = "APPROVE_BY", length = 128)
	public String getApproveBy() {
		return this.approveBy;
	}

	public void setApproveBy(String approveBy) {
		this.approveBy = approveBy;
	}

	@Column(name = "APPROVE_TIME")
	public Date getApproveTime() {
		return this.approveTime;
	}

	public void setApproveTime(Date approveTime) {
		this.approveTime = approveTime;
	}

	@Column(name = "APPROVE_BY_ID", length = 40)
	public String getApproveById() {
		return this.approveById;
	}

	public void setApproveById(String approveById) {
		this.approveById = approveById;
	}

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "tMackDaddyCardOrder")
	public Set<TMackDaddyCard> gettMackDaddyCards() {
		return this.tMackDaddyCards;
	}

	public void settMackDaddyCards(Set<TMackDaddyCard> tMackDaddyCards) {
		this.tMackDaddyCards = tMackDaddyCards;
	}
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "CINEMA_ID", insertable = false, updatable = false)
	public TCinema gettCinema() {
		return tCinema;
	}

	public void settCinema(TCinema tCinema) {
		this.tCinema = tCinema;
	}
	
	@Column(name = "DESCRIPTION", length = 2000)
	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}
	
	@Column(name = "OA_ID", length = 100)
	public String getOaId() {
		return oaId;
	}

	public void setOaId(String oaId) {
		this.oaId = oaId;
	}
	
	@OneToMany(fetch = FetchType.LAZY, mappedBy = "tMackDaddyCardOrder", cascade = CascadeType.ALL, orphanRemoval = true)
	public Set<TMackDaddyCardOrderLog> gettMackDaddyCardOrderLogs() {
		return this.tMackDaddyCardOrderLogs;
	}

	public void settMackDaddyCardOrderLogs(
			Set<TMackDaddyCardOrderLog> tMackDaddyCardOrderLogs) {
		this.tMackDaddyCardOrderLogs = tMackDaddyCardOrderLogs;
	}
	
	@Column(name="DEAL_STATUS")
	public String getDealStatus() {
		return dealStatus;
	}

	public void setDealStatus(String dealStatus) {
		this.dealStatus = dealStatus;
	}
}
