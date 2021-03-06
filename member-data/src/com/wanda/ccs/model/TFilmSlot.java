package com.wanda.ccs.model;

// Generated 2011-10-20 18:34:37 by Hibernate Tools 3.4.0.CR1

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
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import com.xcesys.extras.core.dao.model.AbstractEntity;

/**
 * TFilmSlot generated by hbm2java
 */
@Entity
@Table(name = "T_FILM_SLOT")
public class TFilmSlot extends AbstractEntity implements java.io.Serializable {

	private static final long serialVersionUID = 7776014158130577608L;
	private Long id;
	private TPriceBase tPriceBase;
	private Long priceBaseId;
	private TFilm tFilm;
	private TCity tCity;
	private Long cityId;
	private Date startDate;
	private Date endDate;
	private Long filmRound;
	private String area;
	private String cityType;

	public TFilmSlot() {
	}

	public TFilmSlot(TPriceBase tPriceBase, Long priceBaseId, TFilm tFilm,
			TCity tCity, Long cityId, Date startDate, Date endDate,
			Long filmRound, String area) {
		this.tPriceBase = tPriceBase;
		this.priceBaseId = priceBaseId;
		this.tFilm = tFilm;
		this.tCity = tCity;
		this.cityId = cityId;
		this.startDate = startDate;
		this.endDate = endDate;
		this.filmRound = filmRound;
		this.area = area;
	}

	@Column(name = "AREA", length = 20)
	public String getArea() {
		return this.area;
	}

	@Column(name = "CITY_ID", precision = 38, scale = 0)
	public Long getCityId() {
		return cityId;
	}

	@Column(name = "CITY_TYPE")
	public String getCityType() {
		return cityType;
	}

	@Temporal(TemporalType.DATE)
	@Column(name = "END_DATE", length = 7)
	public Date getEndDate() {
		return this.endDate;
	}

	@Column(name = "FILM_ROUND", precision = 38, scale = 0)
	public Long getFilmRound() {
		return this.filmRound;
	}

	@SequenceGenerator(name = "generator", sequenceName = "S_T_FILM_SLOT")
	@Id
	@GeneratedValue(strategy = SEQUENCE, generator = "generator")
	@Column(name = "SEQID", unique = true, nullable = false, precision = 38, scale = 0)
	public Long getId() {
		return this.id;
	}

	@Column(name = "PRICE_BASE_ID", precision = 38, scale = 0)
	public Long getPriceBaseId() {
		return priceBaseId;
	}

	@Temporal(TemporalType.DATE)
	@Column(name = "START_DATE", length = 7)
	public Date getStartDate() {
		return this.startDate;
	}

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "CITY_ID", insertable = false, updatable = false)
	public TCity gettCity() {
		return this.tCity;
	}

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "FILM_ID")
	public TFilm gettFilm() {
		return this.tFilm;
	}

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "PRICE_BASE_ID", insertable = false, updatable = false)
	public TPriceBase gettPriceBase() {
		return this.tPriceBase;
	}

	public void setArea(String area) {
		this.area = area;
	}

	public void setCityId(Long cityId) {
		this.cityId = cityId;
	}

	public void setCityType(String cityType) {
		this.cityType = cityType;
	}

	public void setEndDate(Date endDate) {
		this.endDate = endDate;
	}

	public void setFilmRound(Long filmRound) {
		this.filmRound = filmRound;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public void setPriceBaseId(Long priceBaseId) {
		this.priceBaseId = priceBaseId;
	}

	public void setStartDate(Date startDate) {
		this.startDate = startDate;
	}

	public void settCity(TCity tCity) {
		this.tCity = tCity;
	}

	public void settFilm(TFilm tFilm) {
		this.tFilm = tFilm;
	}

	public void settPriceBase(TPriceBase tPriceBase) {
		this.tPriceBase = tPriceBase;
	}

}
