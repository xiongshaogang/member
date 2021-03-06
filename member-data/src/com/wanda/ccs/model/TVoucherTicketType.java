package com.wanda.ccs.model;

// Generated 2011-12-12 16:55:46 by Hibernate Tools 3.2.4.GA

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

/**
 * TVoucherTicketType generated by hbm2java
 */
@Entity
@Table(name = "T_VOUCHER_TICKET_TYPE")
public class TVoucherTicketType extends VersionableEntity implements
		java.io.Serializable {
	private static final long serialVersionUID = 323190854739074341L;

	private Long id;
	private Long voucherTypeId;
	private Long ticketTypeId;
	private TVoucherType tVoucherType;
	private TTicketType tTicketType;

	public TVoucherTicketType() {
	}

	public TVoucherTicketType(TTicketType tTicketType,Long voucherTypeId) {
		this.tTicketType = tTicketType;
		this.voucherTypeId = voucherTypeId;
		this.ticketTypeId = tTicketType.getId();
	}
	
	public TVoucherTicketType(TReqVoucherTicketType req, TTicketType tTicketType) {
		setVoucherTypeId(req.getVoucherTypeId());
		setTicketTypeId(tTicketType.getId());
		this.tTicketType = tTicketType;
	}

	@SequenceGenerator(name = "generator", sequenceName = "S_T_VOUCHER_TICKET_TYPE")
	@Id
	@GeneratedValue(strategy = SEQUENCE, generator = "generator")
	@Column(name = "VOUCHER_TICKET_TYPE_ID", unique = true, nullable = false, precision = 22, scale = 0)
	public Long getId() {
		return this.id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	@Column(name = "VOUCHER_TYPE_ID", nullable = false)
	public Long getVoucherTypeId() {
		return voucherTypeId;
	}

	public void setVoucherTypeId(Long voucherTypeId) {
		this.voucherTypeId = voucherTypeId;
	}
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "VOUCHER_TYPE_ID", nullable = false, insertable = false, updatable = false)
	public TVoucherType gettVoucherType() {
		return this.tVoucherType;
	}

	public void settVoucherType(TVoucherType tVoucherType) {
		this.tVoucherType = tVoucherType;
	}

	@Column(name = "TICKET_TYPE_ID", nullable = false)
	public Long getTicketTypeId() {
		return ticketTypeId;
	}

	public void setTicketTypeId(Long ticketTypeId) {
		this.ticketTypeId = ticketTypeId;
	}
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "TICKET_TYPE_ID", nullable = false, insertable = false, updatable = false)
	public TTicketType gettTicketType() {
		return this.tTicketType;
	}

	public void settTicketType(TTicketType tTicketType) {
		this.tTicketType = tTicketType;
	}

}
