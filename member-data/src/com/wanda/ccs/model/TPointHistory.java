package com.wanda.ccs.model;

// Generated 2013-5-21 10:54:02 by Hibernate Tools 3.3.0.GA

import static javax.persistence.GenerationType.SEQUENCE;

import java.util.Date;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import com.xcesys.extras.core.dao.model.BlameableEntity;

/**
 * TPointHistory generated by hbm2java
 */
@Entity
@Table(name = "T_POINT_HISTORY")
@org.hibernate.annotations.Entity(dynamicUpdate = true, dynamicInsert = true)
public class TPointHistory extends BlameableEntity implements
		java.io.Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 7851085289632193446L;
	private Long id;
	private TMember tMember;
	private Long memberId;
	private Date setTime;
	private Long levelPoint;
	private Long ticketCount;
	private Long activityPoint;
	private Long exchangePoint;
	private Date exchangePointExpireTime;
	private String pointType;
	private String pointSys;
	private String pointTransType;
	private String pointTransCode;
	private String pointTransCodeWeb;
	private String adjResion;
	private String adjReasonType;
	private Long orgPointBalance;
	private Long pointBalance;
	private String isSyncBalance;
	private TMemberPoint tMemberPoints = new TMemberPoint();
	private Long memberPointId;
	private String cinemaInnerCode;
	private TCinema tCinema;
	private Long isDeleted;//是否删除

	public TPointHistory() {
	}

	@SequenceGenerator(name = "generator", sequenceName = "S_T_POINT_HISTORY", allocationSize = 1)
	@Id
	@GeneratedValue(strategy = SEQUENCE, generator = "generator")
	@Column(name = "POINT_HISTORY_ID", unique = true, nullable = false, precision = 22, scale = 0)
	public Long getId() {
		return this.id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "MEMBER_ID", nullable = false, insertable = false, updatable = false)
	public TMember gettMember() {
		return tMember;
	}

	public void settMember(TMember tMember) {
		this.tMember = tMember;
	}

	@Column(name = "SET_TIME", nullable = false)
	public Date getSetTime() {
		return this.setTime;
	}

	public void setSetTime(Date setTime) {
		this.setTime = setTime;
	}

	@Column(name = "LEVEL_POINT", nullable = false, precision = 22, scale = 0)
	public Long getLevelPoint() {
		return this.levelPoint;
	}

	public void setLevelPoint(Long levelPoint) {
		this.levelPoint = levelPoint;
	}

	@Column(name = "TICKET_COUNT", nullable = false, precision = 22, scale = 0)
	public Long getTicketCount() {
		return this.ticketCount;
	}

	public void setTicketCount(Long ticketCount) {
		this.ticketCount = ticketCount;
	}

	@Column(name = "ACTIVITY_POINT", nullable = false, precision = 22, scale = 0)
	public Long getActivityPoint() {
		return this.activityPoint;
	}

	public void setActivityPoint(Long activityPoint) {
		this.activityPoint = activityPoint;
	}

	@Column(name = "EXCHANGE_POINT", nullable = false, precision = 22, scale = 0)
	public Long getExchangePoint() {
		return this.exchangePoint;
	}

	public void setExchangePoint(Long exchangePoint) {
		this.exchangePoint = exchangePoint;
	}

	@Column(name = "EXCHANGE_POINT_EXPIRE_TIME", nullable = false)
	public Date getExchangePointExpireTime() {
		return this.exchangePointExpireTime;
	}

	public void setExchangePointExpireTime(Date exchangePointExpireTime) {
		this.exchangePointExpireTime = exchangePointExpireTime;
	}

	@Column(name = "POINT_TYPE", nullable = false, length = 20)
	public String getPointType() {
		return this.pointType;
	}

	public void setPointType(String pointType) {
		this.pointType = pointType;
	}

	@Column(name = "POINT_SYS", nullable = false, length = 20)
	public String getPointSys() {
		return this.pointSys;
	}

	public void setPointSys(String pointSys) {
		this.pointSys = pointSys;
	}

	@Column(name = "POINT_TRANS_TYPE", nullable = false, length = 20)
	public String getPointTransType() {
		return this.pointTransType;
	}

	public void setPointTransType(String pointTransType) {
		this.pointTransType = pointTransType;
	}

	@Column(name = "POINT_TRANS_CODE", length = 30)
	public String getPointTransCode() {
		return this.pointTransCode;
	}

	public void setPointTransCode(String pointTransCode) {
		this.pointTransCode = pointTransCode;
	}

	@Column(name = "POINT_TRANS_CODE_WEB", nullable = false, length = 30)
	public String getPointTransCodeWeb() {
		return this.pointTransCodeWeb;
	}

	public void setPointTransCodeWeb(String pointTransCodePos) {
		this.pointTransCodeWeb = pointTransCodePos;
	}

	@Column(name = "ADJ_REASON", length = 4000)
	public String getAdjResion() {
		return this.adjResion;
	}

	public void setAdjResion(String adjResion) {
		this.adjResion = adjResion;
	}

	@Column(name = "ORG_POINT_BALANCE", nullable = false, precision = 22, scale = 0)
	public Long getOrgPointBalance() {
		return this.orgPointBalance;
	}

	public void setOrgPointBalance(Long orgPointBalance) {
		this.orgPointBalance = orgPointBalance;
	}

	@Column(name = "POINT_BALANCE", nullable = false, precision = 22, scale = 0)
	public Long getPointBalance() {
		return this.pointBalance;
	}

	public void setPointBalance(Long pointBalance) {
		this.pointBalance = pointBalance;
	}

	@Column(name = "IS_SYNC_BALANCE", nullable = false, length = 2)
	public String getIsSyncBalance() {
		return this.isSyncBalance;
	}

	public void setIsSyncBalance(String isSyncBalance) {
		this.isSyncBalance = isSyncBalance;
	}

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "MEMBER_POINT_ID", insertable = false, updatable = false)
	public TMemberPoint gettMemberPoints() {
		return tMemberPoints;
	}

	public void settMemberPoints(TMemberPoint tMemberPoints) {
		this.tMemberPoints = tMemberPoints;
	}

	@Column(name = "MEMBER_POINT_ID")
	public Long getMemberPointId() {
		return memberPointId;
	}

	public void setMemberPointId(Long memberPointId) {
		this.memberPointId = memberPointId;
	}

	@Column(name = "MEMBER_ID")
	public Long getMemberId() {
		return memberId;
	}

	public void setMemberId(Long memberId) {
		this.memberId = memberId;
	}

	@Column(name = "ADJ_REASON_TYPE")
	public String getAdjReasonType() {
		return adjReasonType;
	}

	public void setAdjReasonType(String adjReasonType) {
		this.adjReasonType = adjReasonType;
	}

	@Column(name = "CINEMA_INNER_CODE")
	public String getCinemaInnerCode() {
		return cinemaInnerCode;
	}

	public void setCinemaInnerCode(String cinemaInnerCode) {
		this.cinemaInnerCode = cinemaInnerCode;
	}

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "CINEMA_INNER_CODE", insertable = false, updatable = false)
	public TCinema gettCinema() {
		return tCinema;
	}

	public void settCinema(TCinema tCinema) {
		this.tCinema = tCinema;
	}

	@Column(name = "ISDELETE")
	public Long getIsDeleted() {
		return isDeleted;
	}

	public void setIsDeleted(Long isDeleted) {
		this.isDeleted = isDeleted;
	}
}
