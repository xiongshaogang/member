package com.wanda.ccs.model;

// Generated 2011-11-2 12:36:06 by Hibernate Tools 3.2.4.GA

import com.xcesys.extras.core.dao.model.VersionableEntity;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import static javax.persistence.GenerationType.SEQUENCE;

import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.persistence.Transient;

/**
 * TCard generated by hbm2java
 */
@Entity
@Table(name = "T_CARD")
@org.hibernate.annotations.Entity(dynamicUpdate = true, dynamicInsert = true)
public class TCard extends VersionableEntity implements java.io.Serializable {
	private static final long serialVersionUID = 2187525271254290750L;
	
	private Long id;
	private TCinema tCinema; //发行卡的影城
	private TCardType tCardType; //卡类型
	private Long serialNumber; //序列号
	private String cardStatus;//卡状态 I-已预制、P-已初始化但未发放、O-正常、D-禁用、R-已 换卡不可用、N - 已补卡不可用、U-已升级不可用、L-已丢失不可用、X-已销卡、E-预制卡失败、T - 已退卡不可用 
	private String custName;//客户姓名
	private String password;//密码
	private Date birthDate;//生日
	private String idNum;//身份证号
	private String phoneNum;//电话号码
	private String email;//电子邮箱
	private String issueRegion;//发行卡影城所属区域
	private String address; //客户联系地址
	private String postalCode;//客户邮编
	private String gender;//性别
	private String cardNumber;//卡号
	private Long cardOrderId;//制卡申请单编号
	private Float balance;//卡余额
	private Date issueDate;//发卡日期
	private Long points;//卡积分
	private Date expiryDate ;//到期日期
	private String idType;//证件类型
	private String qqNum;//QQ号
	private Set<TCardTrans> tCardTrans = new HashSet<TCardTrans>(0);
	private Set<TCardSvc> tCardSvcsForCardId = new HashSet<TCardSvc>(0);
	private Set<TCardSvc> tCardSvcsForNewCardId = new HashSet<TCardSvc>(0);
	private Long cardTypeId; //卡类型编号
	private Long cinemaId;
	
	private String isVirtual; // 是否为虚拟卡，Y:虚拟卡，N:实物卡

	public TCard() {
	}

	public TCard(TCardType tCardType, Long serialNumber, String cardStatus,
			String cardNumber, Long cardOrderId, Long cardTypeId) {
		this.tCardType = tCardType;
		this.serialNumber = serialNumber;
		this.cardStatus = cardStatus;
		this.cardNumber = cardNumber;
		this.cardOrderId = cardOrderId;
		this.cardTypeId = cardTypeId;
	}

	public TCard(TCinema tCinema, TCardType tCardType, Long serialNumber,
			String cardStatus, String custName, String password, Date birthDate,
			String idNum, String phoneNum, String email, String issueRegion,
			String address, String postalCode, String gender, String cardNumber,
			Long cardOrderId, Float balance, Date issueDate, Long points, Long cardTypeId,
			Set<TCardTrans> tCardTrans,
			Set<TCardSvc> tCardSvcsForCardId,
			Set<TCardSvc> tCardSvcsForNewCardId) {
		this.tCinema = tCinema;
		this.tCardType = tCardType;
		this.serialNumber = serialNumber;
		this.cardStatus = cardStatus;
		this.custName = custName;
		this.password = password;
		this.birthDate = birthDate;
		this.idNum = idNum;
		this.phoneNum = phoneNum;
		this.email = email;
		this.issueRegion = issueRegion;
		this.address = address;
		this.postalCode = postalCode;
		this.gender = gender;
		this.cardNumber = cardNumber;
		this.cardOrderId = cardOrderId;
		this.balance = balance;
		this.issueDate = issueDate;
		this.points = points;
		this.tCardTrans = tCardTrans;
		this.tCardSvcsForCardId = tCardSvcsForCardId;
		this.tCardSvcsForNewCardId = tCardSvcsForNewCardId;
		this.cardTypeId = cardTypeId;
	}
	@SequenceGenerator(name = "generator", sequenceName = "S_T_CARD", allocationSize = 1)
	@Id
	@GeneratedValue(strategy = SEQUENCE, generator = "generator")
	@Column(name = "CARD_ID", unique = true, nullable = false, precision = 38, scale = 0)
	public Long getId() {
		return this.id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "ISSUE_CINEMA",insertable = false, updatable=false)
	public TCinema gettCinema() {
		return this.tCinema;
	}

	public void settCinema(TCinema tCinema) {
		this.tCinema = tCinema;
	}
	
	@Column(name = "ISSUE_CINEMA")
	public Long getCinemaId() {
		return cinemaId;
	}

	public void setCinemaId(Long cinemaId) {
		this.cinemaId = cinemaId;
	}
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "CARD_TYPE_ID", nullable = false, insertable = false, updatable = false)
	public TCardType gettCardType() {
		return this.tCardType;
	}

	public void settCardType(TCardType tCardType) {
		this.tCardType = tCardType;
	}
	
	@Column(name = "CARD_TYPE_ID", nullable = false)
	public Long getCardTypeId() {
		return this.cardTypeId;
	}

	public void setCardTypeId(Long cardTypeId) {
		this.cardTypeId = cardTypeId;
	}
	
	@Column(name = "SERIAL_NUMBER", nullable = false, precision = 20, scale = 0)
	public Long getSerialNumber() {
		return this.serialNumber;
	}

	public void setSerialNumber(Long serialNumber) {
		this.serialNumber = serialNumber;
	}

	@Column(name = "CARD_STATUS", nullable = false, length = 1)
	public String getCardStatus() {
		return this.cardStatus;
	}

	public void setCardStatus(String cardStatus) {
		this.cardStatus = cardStatus;
	}

	@Column(name = "CUST_NAME", length = 1024)
	public String getCustName() {
		return this.custName;
	}

	public void setCustName(String custName) {
		this.custName = custName;
	}

	@Column(name = "PASSWORD", length = 1024)
	public String getPassword() {
		return this.password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	@Column(name = "BIRTH_DATE", length = 7)
	public Date getBirthDate() {
		return this.birthDate;
	}

	public void setBirthDate(Date birthDate) {
		this.birthDate = birthDate;
	}

	@Column(name = "ID_NUM", length = 30)
	public String getIdNum() {
		return this.idNum;
	}

	public void setIdNum(String idNum) {
		this.idNum = idNum;
	}

	@Column(name = "PHONE_NUM", length = 20)
	public String getPhoneNum() {
		return this.phoneNum;
	}

	public void setPhoneNum(String phoneNum) {
		this.phoneNum = phoneNum;
	}

	@Column(name = "EMAIL", length = 256)
	public String getEmail() {
		return this.email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	@Column(name = "ISSUE_REGION", length = 20)
	public String getIssueRegion() {
		return this.issueRegion;
	}

	public void setIssueRegion(String issueRegion) {
		this.issueRegion = issueRegion;
	}

	@Column(name = "ADDRESS")
	public String getAddress() {
		return this.address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	@Column(name = "POSTAL_CODE", length = 20)
	public String getPostalCode() {
		return this.postalCode;
	}

	public void setPostalCode(String postalCode) {
		this.postalCode = postalCode;
	}

	@Column(name = "GENDER", length = 1)
	public String getGender() {
		return this.gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	@Column(name = "CARD_NUMBER", nullable = false, length = 50)
	public String getCardNumber() {
		return this.cardNumber;
	}

	public void setCardNumber(String cardNumber) {
		this.cardNumber = cardNumber;
	}

	@Column(name = "CARD_ORDER_ID", nullable = false, precision = 38, scale = 0)
	public Long getCardOrderId() {
		return this.cardOrderId;
	}

	public void setCardOrderId(Long cardOrderId) {
		this.cardOrderId = cardOrderId;
	}

	@Column(name = "BALANCE", precision = 10)
	public Float getBalance() {
		return this.balance;
	}

	public void setBalance(Float balance) {
		this.balance = balance;
	}

	@Column(name = "ISSUE_DATE", length = 7)
	public Date getIssueDate() {
		return this.issueDate;
	}

	public void setIssueDate(Date issueDate) {
		this.issueDate = issueDate;
	}

	@Column(name = "POINTS", precision = 10)
	public Long getPoints() {
		return this.points;
	}

	public void setPoints(Long points) {
		this.points = points;
	}
	
	@Column(name = "EXPIRY_DATE", length = 7)
	public Date getExpiryDate() {
		return expiryDate;
	}

	public void setExpiryDate(Date expiryDate) {
		this.expiryDate = expiryDate;
	}

	@Column(name="ID_TYPE",length = 1)
	public String getIdType() {
		return idType;
	}

	public void setIdType(String idType) {
		this.idType = idType;
	}
	
	@Column(name="QQ_NUM",length = 30)
	public String getQqNum() {
		return qqNum;
	}

	public void setQqNum(String qqNum) {
		this.qqNum = qqNum;
	}

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "tCard")
	public Set<TCardTrans> gettCardTrans() {
		return this.tCardTrans;
	}

	public void settCardTrans(Set<TCardTrans> tCardTrans) {
		this.tCardTrans = tCardTrans;
	}

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "tCardByCardId")
	public Set<TCardSvc> gettCardSvcsForCardId() {
		return this.tCardSvcsForCardId;
	}

	public void settCardSvcsForCardId(Set<TCardSvc> tCardSvcsForCardId) {
		this.tCardSvcsForCardId = tCardSvcsForCardId;
	}

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "tCardByNewCardId")
	public Set<TCardSvc> gettCardSvcsForNewCardId() {
		return this.tCardSvcsForNewCardId;
	}

	public void settCardSvcsForNewCardId(Set<TCardSvc> tCardSvcsForNewCardId) {
		this.tCardSvcsForNewCardId = tCardSvcsForNewCardId;
	}
	
	@Transient
	public String getStringDate(){
		if(expiryDate != null)
			return new SimpleDateFormat("yyyy-MM-dd").format(expiryDate);
		return "";
	}

	@Column(name = "IS_VIRTUAL",length=1)
	public String getIsVirtual() {
		return isVirtual;
	}

	public void setIsVirtual(String isVirtual) {
		this.isVirtual = isVirtual;
	}
}
