package com.wanda.ccs.model;

// Generated 2011-11-2 12:36:06 by Hibernate Tools 3.2.4.GA

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
import javax.persistence.Transient;

import com.wanda.ccs.data.price.Rule;
import com.xcesys.extras.core.dao.model.VersionableEntity;

/**
 * TTicketTypeLimitRule generated by hbm2java
 */
@Entity
@Table(name = "T_TICKET_TYPE_LIMIT_RULE")
public class TTicketTypeLimitRule extends VersionableEntity implements
		java.io.Serializable, IRegionCode {

	private static final long serialVersionUID = 4922987223491577517L;
	private Long id;
	private TTicketType tTicketType;
	private Long ticketTypeId;
	private String rule;
	private String description;
	private String regionCode;
	private Long ruleOrder;
	private Boolean isDeleted;

	public TTicketTypeLimitRule() {
	}

	public TTicketTypeLimitRule(TTicketType tTicketType, String rule,
			String description, String regionCode, Long ruleOrder,
			Boolean isDeleted) {
		this.tTicketType = tTicketType;
		this.ticketTypeId = tTicketType.getId();
		this.rule = rule;
		this.description = description;
		this.regionCode = regionCode;
		this.ruleOrder = ruleOrder;
		this.isDeleted = isDeleted;
	}

	@SequenceGenerator(name = "generator", sequenceName = "S_T_TICKET_TYPE_LIMIT_RULE", allocationSize = 1)
	@Id
	@GeneratedValue(strategy = SEQUENCE, generator = "generator")
	@Column(name = "TICKET_TYPE_LIMIT_RULE_ID", unique = true, nullable = false, precision = 38, scale = 0)
	public Long getId() {
		return this.id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "TICKET_TYPE_ID", nullable = false, insertable = false, updatable = false)
	public TTicketType gettTicketType() {
		return this.tTicketType;
	}

	public void settTicketType(TTicketType tTicketType) {
		this.tTicketType = tTicketType;
	}

	@Column(name = "RULE", nullable = false)
	public String getRule() {
		return this.rule;
	}

	public void setRule(String rule) {
		this.rule = rule;
	}

	@Transient
	public boolean getReverse() {
		return rule != null && rule.startsWith(Rule.REVERSE_PREFIX);
	}
	
	public void setReverse(boolean r) {
	}

	@Column(name = "DESCRIPTION", nullable = false, length = 2000)
	public String getDescription() {
		return this.description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	@Column(name = "REGION_CODE", length = 20)
	public String getRegionCode() {
		return this.regionCode;
	}

	public void setRegionCode(String regionCode) {
		this.regionCode = regionCode;
	}

	@Column(name = "RULE_ORDER", nullable = false, precision = 38, scale = 0)
	public Long getRuleOrder() {
		return this.ruleOrder;
	}

	public void setRuleOrder(Long ruleOrder) {
		this.ruleOrder = ruleOrder;
	}

	@Column(name = "IS_DELETED", nullable = false, length = 1)
	public String getIsDeleted() {
		return this.isDeleted ? "Y" : "N";
	}

	public void setIsDeleted(String isDeleted) {
		this.isDeleted = isDeleted != null && isDeleted.equalsIgnoreCase("Y");
	}

	@Column(name = "TICKET_TYPE_ID", nullable = false)
	public Long getTicketTypeId() {
		return ticketTypeId;
	}

	public void setTicketTypeId(Long ticketTypeId) {
		this.ticketTypeId = ticketTypeId;
	}
}
