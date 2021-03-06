package com.wanda.ccs.model;

// Generated Dec 5, 2012 1:48:48 PM by Hibernate Tools 3.4.0.CR1

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

import com.xcesys.extras.core.dao.model.VersionableEntity;

/**
 * TConPaCinema generated by hbm2java
 */
@Entity
@Table(name = "T_CON_PA_CINEMA")
@org.hibernate.annotations.Entity(dynamicUpdate = true, dynamicInsert = true)
public class TConPaCinema extends VersionableEntity implements
		java.io.Serializable {

	private static final long serialVersionUID = -5363168610805065856L;

	private Long id;
	private Long conPaId;
	private TConPa tConPa;
	private Long cinemaId;
	private TCinema tCinema;
	private Boolean deleted;

	public TConPaCinema() {
		deleted = Boolean.FALSE;
	}

	@SequenceGenerator(name = "generator", sequenceName = "S_T_CON_PA_CINEMA", allocationSize = 20)
	@Id
	@GeneratedValue(strategy = SEQUENCE, generator = "generator")
	@Column(name = "CON_PA_CINEMA_ID", unique = true, nullable = false, precision = 22, scale = 0)
	public Long getId() {
		return this.id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "CON_PA_ID", nullable = false)
	public TConPa gettConPa() {
		return this.tConPa;
	}

	public void settConPa(TConPa tConPa) {
		this.tConPa = tConPa;
	}

	@Column(name = "CINEMA_ID", precision = 22, scale = 0)
	public Long getCinemaId() {
		return this.cinemaId;
	}

	public void setCinemaId(Long cinemaId) {
		this.cinemaId = cinemaId;
	}

	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "CINEMA_ID", insertable = false, updatable = false)
	public TCinema gettCinema() {
		return tCinema;
	}

	public void settCinema(TCinema tCinema) {
		this.tCinema = tCinema;
	}

	@Column(name="DELETED")
	public Boolean getDeleted() {
		return deleted;
	}

	public void setDeleted(Boolean deleted) {
		this.deleted = deleted;
	}

	@Column(name = "CON_PA_ID", insertable = false , updatable = false)
	public Long getConPaId() {
		return conPaId;
	}

	public void setConPaId(Long conPaId) {
		this.conPaId = conPaId;
	}
}
