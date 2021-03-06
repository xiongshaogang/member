package com.wanda.ccs.model;

// Generated 2011-11-2 12:36:06 by Hibernate Tools 3.2.4.GA

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
 * TCardTypeRecharge generated by hbm2java
 */
@Entity
@Table(name = "T_CARD_TYPE_RECHARGE")
public class TCardTypeRecharge extends VersionableEntity implements
		java.io.Serializable {
	private static final long serialVersionUID = 3574489394993031969L;
	
	private Long id;
	private TCardType tCardType;//卡序列号
	private Long amount;//充值金额
	private Long addValue;//增加余额
	private String regionCode;//区域代码

	public TCardTypeRecharge() {
	}

	public TCardTypeRecharge(TCardType tCardType, Long amount, String regionCode) {
		this.tCardType = tCardType;
		this.amount = amount;
		this.regionCode = regionCode;
	}

	public TCardTypeRecharge(TCardType tCardType, Long amount, Long addValue,
			String regionCode) {
		this.tCardType = tCardType;
		this.amount = amount;
		this.addValue = addValue;
		this.regionCode = regionCode;
	}

	@SequenceGenerator(name = "generator", sequenceName = "S_T_CARD_TYPE_RECHARGE", allocationSize = 1)
	@Id
	@GeneratedValue(strategy = SEQUENCE, generator = "generator")
	@Column(name = "CARD_TYPE_RECHARGE_ID", unique = true, nullable = false, precision = 38, scale = 0)
	public Long getId() {
		return this.id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "CARD_TYPE_ID", nullable = false)
	public TCardType gettCardType() {
		return this.tCardType;
	}

	public void settCardType(TCardType tCardType) {
		this.tCardType = tCardType;
	}

	@Column(name = "AMOUNT", nullable = false, precision = 10)
	public Long getAmount() {
		return this.amount;
	}

	public void setAmount(Long amount) {
		this.amount = amount;
	}

	@Column(name = "ADD_VALUE", precision = 10)
	public Long getAddValue() {
		return this.addValue;
	}

	public void setAddValue(Long addValue) {
		this.addValue = addValue;
	}

	@Column(name = "REGION_CODE", nullable = false, length = 20)
	public String getRegionCode() {
		return this.regionCode;
	}

	public void setRegionCode(String regionCode) {
		this.regionCode = regionCode;
	}

}
