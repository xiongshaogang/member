package com.wanda.ccs.model;

// Generated 2011-10-26 19:16:53 by Hibernate Tools 3.4.0.CR1

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

import com.xcesys.extras.core.dao.model.VersionableEntity;

/**
 * TReqCardTypeDef generated by hbm2java
 */
@Entity
@Table(name = "T_REQ_CARD_TYPE_DEF")
public class TReqCardTypeDef extends VersionableEntity implements
		java.io.Serializable {
	private static final long serialVersionUID = 1103675888579931068L;

	private Long id;
	private TReqCardType tReqCardType;
	private Long issueFee;
	private Long initialValue;
	private Long minRecharge;
	private Long dayLimit = 0l; // 每日购票限额
	private Long weekLimit = 0l; // 每周购票限额
	private Long roundLimit = 0l; // 每场购票限额
	private Long totalLimit = 0l; // 总限购票数
	private Long filmLimit = 0l; // 每片总限购票数
	private Long filmDayLimit = 0l; // 每片每日限票数
	private Long dayAmtLimit = 0l; // 每日限购票额
	private Long dayAmtPosLimit = 0l; // 日限货额
	private String reissuable = "Y"; // 是否可以补卡
	private Boolean useDefault;
	private Long activationFee=0l;//办理过程中收取的激活费
	private String expireRule = "Y";//有效期规则  指定为特定日期  或 从发卡开始起多少个月内
	private String extendRule = "Y";//充值延期规则 1、从充值日期起往后延期X个月 2、从失效日期往后延期X个月 3、延期到指定日期
	private String activateRule = "Y"; //激活延期规则 1、从激活日期起往后延期X个月 2、从失效日期往后延期X个月 3、延期到指定日期
	private String useOnGoods = "Y";//是否可用于卖品
	
	public TReqCardTypeDef() {
	}

	public TReqCardTypeDef(TCardTypeDef def, TReqCardType reqCardType) {
		tReqCardType = reqCardType;
		setIssueFee(def.getIssueFee());
		setInitialValue(def.getInitialValue());
		setMinRecharge(def.getMinRecharge());
		setDayLimit(def.getDayLimit());
		setWeekLimit(def.getWeekLimit());
		setRoundLimit(def.getRoundLimit());
		setTotalLimit(def.getTotalLimit());
		setFilmLimit(def.getFilmLimit());
		setFilmDayLimit(def.getFilmDayLimit());
		setDayAmtLimit(def.getDayAmtLimit());
		setDayAmtPosLimit(def.getDayAmtPosLimit());
		setReissuable(def.getReissuable());
		setUseDefault(def.getUseDefault());
		setActivationFee(def.getActivationFee());
		setExpireRule(def.getExpireRule());
		setExtendRule(def.getExtendRule());
		setActivateRule(def.getActivateRule());
		setUseOnGoods(def.getUseOnGoods());
	}

	public TReqCardTypeDef(TReqCardType tReqCardType, Long issueFee,
			Long initialValue, Long minRecharge, String reissuable) {
		this.tReqCardType = tReqCardType;
		this.issueFee = issueFee;
		this.initialValue = initialValue;
		this.minRecharge = minRecharge;
		this.reissuable = reissuable;
	}

	@SequenceGenerator(name = "generator", sequenceName = "S_T_REQ_CARD_TYPE_DEF", allocationSize = 1)
	@Id
	@GeneratedValue(strategy = SEQUENCE, generator = "generator")
	@Column(name = "REQ_CARD_TYPE_DEF_ID", unique = true, nullable = false, precision = 38, scale = 0)
	public Long getId() {
		return this.id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "REQ_CARD_TYPE_ID", nullable = false)
	public TReqCardType gettReqCardType() {
		return this.tReqCardType;
	}

	public void settReqCardType(TReqCardType tReqCardType) {
		this.tReqCardType = tReqCardType;
	}


	@Column(name = "ISSUE_FEE", nullable = false, precision = 10)
	public Long getIssueFee() {
		return this.issueFee;
	}

	public void setIssueFee(Long issueFee) {
		this.issueFee = issueFee;
	}


	@Column(name = "INITIAL_VALUE", nullable = false, precision = 10)
	public Long getInitialValue() {
		return this.initialValue;
	}

	public void setInitialValue(Long initialValue) {
		this.initialValue = initialValue;
	}

	@Column(name = "MIN_RECHARGE", nullable = false, precision = 10)
	public Long getMinRecharge() {
		return this.minRecharge;
	}

	public void setMinRecharge(Long minRecharge) {
		this.minRecharge = minRecharge;
	}

	@Column(name = "REISSUABLE", nullable = false, length = 1)
	public String getReissuable() {
		return this.reissuable;
	}

	public void setReissuable(String reissuable) {
		this.reissuable = reissuable;
	}

	@Column(name = "DAY_LIMIT", nullable = true, precision = 10)
	public Long getDayLimit() {
		return dayLimit;
	}

	public void setDayLimit(Long dayLimit) {
		this.dayLimit = dayLimit;
	}

	@Column(name = "WEEK_LIMIT", nullable = true, precision = 10)
	public Long getWeekLimit() {
		return weekLimit;
	}

	public void setWeekLimit(Long weekLimit) {
		this.weekLimit = weekLimit;
	}

	@Column(name = "ROUND_LIMIT", nullable = true, precision = 10)
	public Long getRoundLimit() {
		return roundLimit;
	}

	public void setRoundLimit(Long roundLimit) {
		this.roundLimit = roundLimit;
	}

	@Column(name = "USE_DEFAULT", nullable = false, length = 1)
	public String getUseDefault() {
		return this.useDefault ? "Y" : "N";
	}

	public void setUseDefault(String str) {
		this.useDefault = str.equals("Y");
	}

	@Column(name = "TOTAL_LIMIT", nullable = true, precision = 10)
	public Long getTotalLimit() {
		return totalLimit;
	}

	public void setTotalLimit(Long totalLimit) {
		this.totalLimit = totalLimit;
	}

	@Column(name = "FILM_LIMIT", nullable = true, precision = 10)
	public Long getFilmLimit() {
		return filmLimit;
	}

	public void setFilmLimit(Long filmLimit) {
		this.filmLimit = filmLimit;
	}

	@Column(name = "FILM_DAY_LIMIT", nullable = true, precision = 10)
	public Long getFilmDayLimit() {
		return filmDayLimit;
	}

	public void setFilmDayLimit(Long filmDayLimit) {
		this.filmDayLimit = filmDayLimit;
	}

	@Column(name = "DAY_AMT_LIMIT", nullable = true, precision = 10)
	public Long getDayAmtLimit() {
		return dayAmtLimit;
	}

	public void setDayAmtLimit(Long dayAmtLimit) {
		this.dayAmtLimit = dayAmtLimit;
	}

	@Column(name = "DAY_AMT_POS_LIMIT", nullable = true, precision = 10)
	public Long getDayAmtPosLimit() {
		return dayAmtPosLimit;
	}

	public void setDayAmtPosLimit(Long dayAmtPosLimit) {
		this.dayAmtPosLimit = dayAmtPosLimit;
	}
	
	@Column(name = "ACTIVATION_FEE")
	public Long getActivationFee() {
		return activationFee;
	}

	public void setActivationFee(Long activationFee) {
		this.activationFee = activationFee;
	}
	
	@Column(name = "EXPIRE_RULE", nullable = true, length = 100)
	public String getExpireRule() {
		return expireRule;
	}

	public void setExpireRule(String expireRule) {
		this.expireRule = expireRule;
	}
	
	@Column(name = "EXTEND_RULE", nullable = true, length = 100)
	public String getExtendRule() {
		return extendRule;
	}

	public void setExtendRule(String extendRule) {
		this.extendRule = extendRule;
	}
	
	@Column(name = "ACTIVATE_RULE", nullable = true, length = 100)
	public String getActivateRule() {
		return activateRule;
	}

	public void setActivateRule(String activateRule) {
		this.activateRule = activateRule;
	}
	
	@Column(name = "USE_ON_GOODS", nullable = false, length = 1)
	public String getUseOnGoods() {
		return useOnGoods;
	}

	public void setUseOnGoods(String useOnGoods) {
		this.useOnGoods = useOnGoods;
	}
	
	@Transient
	public CardTypeDefRule getRule() {
		return new CardTypeDefRule(this.expireRule, this.extendRule, this.activateRule);
	}
}
