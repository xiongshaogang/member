package com.wanda.ccs.model;

// Generated 2013-4-26 16:06:19 by Hibernate Tools 3.3.0.GA

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
 * 会员与第三方渠道账户之间的关系， 1个会员可以有多个第三方账户
 */
@Entity
@Table(name = "T_MEMBER_3RD_REL")
@org.hibernate.annotations.Entity(dynamicUpdate = true, dynamicInsert = true)
public class TMember3rdRel extends BlameableEntity implements
		java.io.Serializable {

	private static final long serialVersionUID = 5440355562582694599L;
	private Long id;
	private TMember tMember;
	private Long memberId;
	private String bindLogId;
	private Integer bindType;
	private Date bindTime;
	private Integer isUnBind;
	private String channelName;

	public TMember3rdRel() {
	}

	@SequenceGenerator(name = "generator", sequenceName = "S_T_MEMBER_3RD_REL", allocationSize = 1)
	@Id
	@GeneratedValue(strategy = SEQUENCE, generator = "generator")
	@Column(name = "RDREL_ID", unique = true, nullable = false, precision = 22, scale = 0)
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "MEMBER_ID", nullable = false, insertable = false, updatable = false)
	public TMember gettMember() {
		return this.tMember;
	}

	public void settMember(TMember tMember) {
		this.tMember = tMember;
	}

	@Column(name = "MEMBER_ID")
	public Long getMemberId() {
		return memberId;
	}

	public void setMemberId(Long memberId) {
		this.memberId = memberId;
	}

	@Column(name = "BIND_CHNID")
	public String getChannelName() {
		return channelName;
	}

	public void setChannelName(String channelName) {
		this.channelName = channelName;
	}

	@Column(name = "BIND_LOGONID")
	public String getBindLogId() {
		return bindLogId;
	}

	public void setBindLogId(String bindLogId) {
		this.bindLogId = bindLogId;
	}

	@Column(name = "BIND_TYPE")
	public Integer getBindType() {
		return bindType;
	}

	public void setBindType(Integer bindType) {
		this.bindType = bindType;
	}

	@Column(name = "BIND_TIME")
	public Date getBindTime() {
		return bindTime;
	}

	public void setBindTime(Date bindTime) {
		this.bindTime = bindTime;
	}

	@Column(name = "ISUNBIND")
	public Integer getIsUnBind() {
		return isUnBind;
	}

	public void setIsUnBind(Integer isUnBind) {
		this.isUnBind = isUnBind;
	}
}
