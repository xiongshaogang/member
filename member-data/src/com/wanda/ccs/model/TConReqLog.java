package com.wanda.ccs.model;

// Generated Feb 22, 2013 3:25:01 PM by Hibernate Tools 3.4.0.CR1

import com.xcesys.extras.core.dao.model.VersionableEntity;
import java.util.Date;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import static javax.persistence.GenerationType.SEQUENCE;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

/**
 * TConReqLog generated by hbm2java
 */
@Entity
@Table(name = "T_CON_REQ_LOG")
public class TConReqLog extends VersionableEntity implements
		java.io.Serializable {

	private Long id;
	private Long requestId;
	private String actionName;
	private String actionBy;
	private Date actionTime;
	private String comments;
	private String fromStatus;
	private String toStatus;
	private String actionById;
	private String requestTable;
	private Long cinemaId;// 用户所属影城ID，非影城用户为空
	private TCinema tCinema;

	public TConReqLog() {
	}

	@SequenceGenerator(name = "generator", sequenceName = "S_T_CON_REQ_LOG",allocationSize=1)
	@Id
	@GeneratedValue(strategy = SEQUENCE, generator = "generator")
	@Column(name = "REQ_LOG_ID", unique = true, nullable = false, precision = 22, scale = 0)
	public Long getId() {
		return this.id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	@Column(name = "REQUEST_ID", nullable = false, precision = 22, scale = 0)
	public Long getRequestId() {
		return this.requestId;
	}

	public void setRequestId(Long requestId) {
		this.requestId = requestId;
	}

	@Column(name = "ACTION_NAME", nullable = false, length = 400)
	public String getActionName() {
		return this.actionName;
	}

	public void setActionName(String actionName) {
		this.actionName = actionName;
	}

	@Column(name = "ACTION_BY", nullable = false, length = 40)
	public String getActionBy() {
		return this.actionBy;
	}

	public void setActionBy(String actionBy) {
		this.actionBy = actionBy;
	}

	@Column(name = "ACTION_TIME", nullable = false)
	public Date getActionTime() {
		return this.actionTime;
	}

	public void setActionTime(Date actionTime) {
		this.actionTime = actionTime;
	}

	@Column(name = "COMMENTS", length = 4000)
	public String getComments() {
		return this.comments;
	}

	public void setComments(String comments) {
		this.comments = comments;
	}

	@Column(name = "FROM_STATUS", length = 510)
	public String getFromStatus() {
		return this.fromStatus;
	}

	public void setFromStatus(String fromStatus) {
		this.fromStatus = fromStatus;
	}

	@Column(name = "TO_STATUS", length = 510)
	public String getToStatus() {
		return this.toStatus;
	}

	public void setToStatus(String toStatus) {
		this.toStatus = toStatus;
	}

	@Column(name = "ACTION_BY_ID", nullable = false, length = 20)
	public String getActionById() {
		return this.actionById;
	}

	public void setActionById(String actionById) {
		this.actionById = actionById;
	}

	@Column(name = "REQUEST_TABLE", nullable = false, length = 60)
	public String getRequestTable() {
		return this.requestTable;
	}

	public void setRequestTable(String requestTable) {
		this.requestTable = requestTable;
	}

	@Column(name = "CINEMA_ID")
	public Long getCinemaId() {
		return cinemaId;
	}

	public void setCinemaId(Long cinemaId) {
		this.cinemaId = cinemaId;
	}

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name="CINEMA_ID" , insertable = false , updatable = false)
	public TCinema gettCinema() {
		return tCinema;
	}

	public void settCinema(TCinema tCinema) {
		this.tCinema = tCinema;
	}

}
