package com.wanda.ccs.model;

// Generated 2011-11-2 12:36:06 by Hibernate Tools 3.2.4.GA

import static javax.persistence.GenerationType.SEQUENCE;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.Vector;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OrderBy;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.persistence.Transient;

import org.hibernate.annotations.Cache;
import org.hibernate.annotations.CacheConcurrencyStrategy;
import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.FetchMode;

import com.wanda.ccs.data.price.Rule;
import com.xcesys.extras.core.dao.model.BlameableEntity;

/**
 * TTicketType generated by hbm2java
 */
@Entity
@Table(name = "T_TICKET_TYPE")
@Cache(usage = CacheConcurrencyStrategy.READ_WRITE)
public class TTicketType extends BlameableEntity implements
		java.io.Serializable {
	private static final long serialVersionUID = 323190854739074341L;

	private Long id;
	private TMarketingCampaign tMarketingCampaign;
	private TCinema tCinema;
	private Long ownerCinema;
	private String typeCategory; // 票类类型
	private String typeName; // 票类名称
	private String typeCode; // 票类编码
	private String typeLevel; // 影票类型的级别 院线级G、R区域级、C影城级
	private String ownerRegion; //
	private String status = "E"; // 票类状态 E为可用、D为不可用、X为删除 V为代金券
	private Integer basePrice = 0;
	private String description;
	private String typeType = "01"; // 票类性质
	private String typeGroup = "12"; // 票类分类
	private String oaId;
	private String regionModify = "N";//是否允许区域修改
	private List<TTicketTypeLimitRule> tTicketTypeLimitRules = new ArrayList<TTicketTypeLimitRule>();
	private List<TTicketTypeCinema> tTicketTypeCinemas = new ArrayList<TTicketTypeCinema>(
			0);
	private List<TTicketTypeRegion> tTicketTypeRegions = new ArrayList<TTicketTypeRegion>(
			0);
	private Set<TReqTicketType> tReqTicketTypes = new HashSet<TReqTicketType>(0);
	private List<TTicketTypeUseRule> tTicketTypeUseRules = new ArrayList<TTicketTypeUseRule>();
	private List<TCardTicketType> tCardTicketTypes = new ArrayList<TCardTicketType>();
	private List<TVoucherTicketType> tVoucherTicketTypes = new ArrayList<TVoucherTicketType>();
	private List<TTicketTypePaymentCard> tTicketPayCards = new ArrayList<TTicketTypePaymentCard>();
	private List<TTicketTypePaymentVoucher> tTicketPayVouchers = new ArrayList<TTicketTypePaymentVoucher>();
	private Vector<Rule> limitRules = new Vector<Rule>();
	private Vector<Rule> useRules = new Vector<Rule>();

	private Long marketingCampaignId; // 营销活动的编号
	private String needAuthorize = "N"; // 票类的二次修改授权标识

	public TTicketType() {
	}

	public TTicketType(TReqTicketType type) {
		if (type != null) {
			this.setTypeCategory(type.getTypeCategory());
			this.setTypeName(type.getTypeName());
			this.setTypeCode(type.getTypeCode());
			this.setOwnerRegion(type.getOwnerRegion());
			this.setOwnerCinema(type.getOwnerCinema());
			this.setDescription(type.getDescription());
			this.setTypeLevel(type.getTypeLevel());
			this.setTypeType(type.getTypeType());
			this.setTypeGroup(type.getTypeGroup());
			this.setBasePrice(type.getBasePrice());
			this.setNeedAuthorize(type.getNeedAuthorize());
			// this.setOaId(type.getOaId());
		}
	}

	public TTicketType(String typeCategory, String typeName, String typeCode,
			String typeLevel, String status) {
		this.typeCategory = typeCategory;
		this.typeName = typeName;
		this.typeCode = typeCode;
		this.typeLevel = typeLevel;
		this.status = status;
	}

	public TTicketType(TMarketingCampaign tMarketingCampaign, TCinema tCinema,
			String typeCategory, String typeName, String typeCode,
			String typeLevel, String ownerRegion, String status,
			String description, String needAuthorize,
			ArrayList<TTicketTypeLimitRule> tTicketTypeLimitRules,
			ArrayList<TTicketTypeCinema> tTicketTypeCinemas,
			ArrayList<TTicketTypeRegion> tTicketTypeRegions,
			Set<TReqTicketType> tReqTicketTypes,
			ArrayList<TTicketTypeUseRule> tTicketTypeUseRules) {
		this.tMarketingCampaign = tMarketingCampaign;
		this.tCinema = tCinema;
		this.typeCategory = typeCategory;
		this.typeName = typeName;
		this.typeCode = typeCode;
		this.typeLevel = typeLevel;
		this.ownerRegion = ownerRegion;
		this.status = status;
		this.description = description;
		this.needAuthorize = needAuthorize;
		this.tTicketTypeLimitRules = tTicketTypeLimitRules;
		this.tTicketTypeCinemas = tTicketTypeCinemas;
		this.tTicketTypeRegions = tTicketTypeRegions;
		this.tReqTicketTypes = tReqTicketTypes;
		this.tTicketTypeUseRules = tTicketTypeUseRules;
	}

	public void copy(TReqTicketType type) {
		this.setTypeName(type.getTypeName());
		this.setTypeCode(type.getTypeCode());
		this.setDescription(type.getDescription());
		this.setTypeType(type.getTypeType());
		this.setTypeGroup(type.getTypeGroup());
		this.setBasePrice(type.getBasePrice());
		this.setNeedAuthorize(type.getNeedAuthorize());
		this.setMarketingCampaignId(type.getMarketingCampaignId());
	}
	
	public void copyTicketTypeEdit(TReqTicketType type) {
		this.setTypeName(type.getTypeName());
		this.setTypeCode(type.getTypeCode());
		this.setDescription(type.getDescription());
		this.setTypeType(type.getTypeType());
		this.setTypeGroup(type.getTypeGroup());
//		this.setBasePrice(type.getBasePrice());
		this.setNeedAuthorize(type.getNeedAuthorize());
		this.setMarketingCampaignId(type.getMarketingCampaignId());
	}

	@SequenceGenerator(name = "generator", sequenceName = "S_T_TICKET_TYPE", allocationSize = 1)
	@Id
	@GeneratedValue(strategy = SEQUENCE, generator = "generator")
	@Column(name = "TICKET_TYPE_ID", unique = true, nullable = false, precision = 38, scale = 0)
	public Long getId() {
		return this.id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "MARKETING_CAMPAIGN_ID", insertable = false, updatable = false)
	public TMarketingCampaign gettMarketingCampaign() {
		return this.tMarketingCampaign;
	}

	public void settMarketingCampaign(TMarketingCampaign tMarketingCampaign) {
		this.tMarketingCampaign = tMarketingCampaign;
	}

	@Column(name = "MARKETING_CAMPAIGN_ID")
	public Long getMarketingCampaignId() {
		return marketingCampaignId;
	}

	public void setMarketingCampaignId(Long marketingCampaignId) {
		this.marketingCampaignId = marketingCampaignId;
	}

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "OWNER_CINEMA", insertable = false, updatable = false)
	public TCinema gettCinema() {
		return this.tCinema;
	}

	public void settCinema(TCinema tCinema) {
		this.tCinema = tCinema;
	}

	@Column(name = "OWNER_CINEMA", nullable = true)
	public Long getOwnerCinema() {
		return ownerCinema;
	}

	public void setOwnerCinema(Long ownerCinema) {
		this.ownerCinema = ownerCinema;
	}

	@Column(name = "TYPE_CATEGORY", nullable = false, length = 1)
	public String getTypeCategory() {
		return this.typeCategory;
	}

	public void setTypeCategory(String typeCategory) {
		this.typeCategory = typeCategory;
	}

	@Column(name = "TYPE_NAME", nullable = false, length = 20)
	public String getTypeName() {
		return this.typeName;
	}

	public void setTypeName(String typeName) {
		if(typeName != null)
			this.typeName = typeName.trim();
	}

	@Column(name = "TYPE_CODE", nullable = false, length = 200)
	public String getTypeCode() {
		return this.typeCode;
	}

	public void setTypeCode(String typeCode) {
		this.typeCode = typeCode;
	}

	@Column(name = "TYPE_LEVEL", nullable = false, length = 1)
	public String getTypeLevel() {
		return this.typeLevel;
	}

	public void setTypeLevel(String typeLevel) {
		this.typeLevel = typeLevel;
	}

	@Column(name = "OWNER_REGION", length = 20)
	public String getOwnerRegion() {
		return this.ownerRegion;
	}

	public void setOwnerRegion(String ownerRegion) {
		this.ownerRegion = ownerRegion;
	}

	@Column(name = "STATUS", nullable = false, length = 1)
	public String getStatus() {
		return this.status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	@Column(name = "DESCRIPTION", length = 2000)
	public String getDescription() {
		return this.description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	@OneToMany(fetch = FetchType.EAGER, mappedBy = "tTicketType")
	@OrderBy("regionCode, ruleOrder")
	@Fetch(FetchMode.SUBSELECT)
	public List<TTicketTypeLimitRule> gettTicketTypeLimitRules() {
		return this.tTicketTypeLimitRules;
	}

	public void settTicketTypeLimitRules(
			List<TTicketTypeLimitRule> tTicketTypeLimitRules) {
		this.tTicketTypeLimitRules = tTicketTypeLimitRules;
	}

	@OneToMany(fetch = FetchType.EAGER, mappedBy = "tTicketType")
	@OrderBy("cinemaId")
	@Fetch(FetchMode.SUBSELECT)
	public List<TTicketTypeCinema> gettTicketTypeCinemas() {
		return this.tTicketTypeCinemas;
	}

	public void settTicketTypeCinemas(List<TTicketTypeCinema> tTicketTypeCinemas) {
		this.tTicketTypeCinemas = tTicketTypeCinemas;
	}

	@OneToMany(fetch = FetchType.EAGER, mappedBy = "tTicketType")
	@OrderBy("regionCode")
	@Fetch(FetchMode.SUBSELECT)
	public List<TTicketTypeRegion> gettTicketTypeRegions() {
		return this.tTicketTypeRegions;
	}

	public void settTicketTypeRegions(List<TTicketTypeRegion> tTicketTypeRegions) {
		this.tTicketTypeRegions = tTicketTypeRegions;
	}

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "tTicketType")
	public Set<TReqTicketType> gettReqTicketTypes() {
		return this.tReqTicketTypes;
	}

	public void settReqTicketTypes(Set<TReqTicketType> tReqTicketTypes) {
		this.tReqTicketTypes = tReqTicketTypes;
	}

	@OneToMany(fetch = FetchType.EAGER, mappedBy = "tTicketType")
	@OrderBy("regionCode, ruleOrder")
	@Fetch(FetchMode.SUBSELECT)
	public List<TTicketTypeUseRule> gettTicketTypeUseRules() {
		return this.tTicketTypeUseRules;
	}

	public void settTicketTypeUseRules(
			List<TTicketTypeUseRule> tTicketTypeUseRules) {
		this.tTicketTypeUseRules = tTicketTypeUseRules;
	}

	@Column(name = "TYPE_TYPE", length = 10)
	public String getTypeType() {
		return typeType;
	}

	public void setTypeType(String typeType) {
		this.typeType = typeType;
	}

	@Column(name = "TYPE_GROUP", length = 10)
	public String getTypeGroup() {
		return typeGroup;
	}

	public void setTypeGroup(String typeGroup) {
		this.typeGroup = typeGroup;
	}

	@Column(name = "BASE_PRICE")
	public Integer getBasePrice() {
		return basePrice;
	}

	public void setBasePrice(Integer basePrice) {
		this.basePrice = basePrice;
	}

	@Transient
	public String getExchangeFlag() {
		return getIsExchange() ? "Y" : "N";
	}

	public void setExchangeFlag(String isExchange) {
	}

	@Transient
	public Boolean getIsExchange() {
		return typeCategory != null
				&& (typeCategory
						.equals(ITicketUtilType.TICKET_TYPE_CATEGORY_CARD_T)
						|| typeCategory
								.equals(ITicketUtilType.TICKET_TYPE_CATEGORY_VOUCHER_T)
						|| typeCategory
								.equals(ITicketUtilType.TICKET_TYPE_CATEGORY_CT) || typeCategory
						.equals(ITicketUtilType.TICKET_TYPE_CATEGORY_VT));
	}

	public void setIsExchange(Boolean isExchange) {
	}

	@Transient
	public Boolean getIsExchangePoint() {
		return typeCategory != null
				&& (typeCategory
						.equals(ITicketUtilType.TICKET_TYPE_CATEGORY_POINT));
	}

	public void setIsExchangePoint(Boolean isExchangePoint) {
	}

	// @Column(name = "OA_ID", length = 100)
	@Transient
	public String getOaId() {
		return oaId;
	}

	public void setOaId(String oaId) {
		this.oaId = oaId;
	}

	@OneToMany(fetch = FetchType.EAGER, mappedBy = "tTicketType")
	@OrderBy("cardTypeId")
	@Fetch(FetchMode.SUBSELECT)
	public List<TCardTicketType> gettCardTicketTypes() {
		return tCardTicketTypes;
	}

	public void settCardTicketTypes(List<TCardTicketType> tCardTicketTypes) {
		this.tCardTicketTypes = tCardTicketTypes;
	}

	@OneToMany(fetch = FetchType.EAGER, mappedBy = "tTicketType")
	@OrderBy("voucherTypeId")
	@Fetch(FetchMode.SUBSELECT)
	public List<TVoucherTicketType> gettVoucherTicketTypes() {
		return tVoucherTicketTypes;
	}

	public void settVoucherTicketTypes(
			List<TVoucherTicketType> tVoucherTicketTypes) {
		this.tVoucherTicketTypes = tVoucherTicketTypes;
	}

	@OneToMany(fetch = FetchType.EAGER, mappedBy = "tTicketType")
	@OrderBy("cardTypeId")
	@Fetch(FetchMode.SUBSELECT)
	public List<TTicketTypePaymentCard> gettTicketPayCards() {
		return tTicketPayCards;
	}

	public void settTicketPayCards(List<TTicketTypePaymentCard> tTicketPayCards) {
		this.tTicketPayCards = tTicketPayCards;
	}

	@OneToMany(fetch = FetchType.EAGER, mappedBy = "tTicketType")
	@OrderBy("voucherTypeId")
	@Fetch(FetchMode.SUBSELECT)
	public List<TTicketTypePaymentVoucher> gettTicketPayVouchers() {
		return tTicketPayVouchers;
	}

	public void settTicketPayVouchers(
			List<TTicketTypePaymentVoucher> tTicketPayVouchers) {
		this.tTicketPayVouchers = tTicketPayVouchers;
	}

	@Transient
	public boolean getCanEditName() {
		if (this.typeCategory.endsWith("C") || this.typeCategory.endsWith("V"))
			return false;
		return true;
	}

	@Column(name = "NEED_AUTHORIZE", length = 1)
	public String getNeedAuthorize() {
		return needAuthorize;
	}

	public void setNeedAuthorize(String needAuthorize) {
		this.needAuthorize = needAuthorize;
	}
	
	@Column(name = "REGION_MODIFY", length = 1)
	public String getRegionModify() {
		return regionModify;
	}

	public void setRegionModify(String regionModify) {
		this.regionModify = regionModify;
	}

	@Transient
	public Boolean getIsNeedAuthorize() {
		return needAuthorize != null && (needAuthorize.equals("Y"));
	}

	public void setIsNeedAuthorize(Boolean isNeedAuthorize) {
	}

	@Transient
	public Vector<Rule> getLimitRules() {
		return limitRules;
	}

	public void setLimitRules(Vector<Rule> limitRules) {
		this.limitRules = limitRules;
	}

	@Transient
	public Vector<Rule> getUseRules() {
		return useRules;
	}

	public void setUseRules(Vector<Rule> useRules) {
		this.useRules = useRules;
	}	
}
