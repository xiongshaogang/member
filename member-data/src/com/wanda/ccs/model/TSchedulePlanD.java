package com.wanda.ccs.model;

// Generated 2011-10-26 10:19:09 by Hibernate Tools 3.4.0.CR1

import java.util.Arrays;
import java.util.Calendar;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.persistence.Transient;

import org.hibernate.annotations.Cache;
import org.hibernate.annotations.CacheConcurrencyStrategy;

import com.xcesys.extras.core.dao.model.BlameableEntity;
import com.xcesys.extras.core.util.DateUtil;
import com.xcesys.extras.core.util.StringUtil;
import com.xcesys.extras.util.ConvertUtil;

/**
 * TSchedulePlanB generated by hbm2java
 */
@Entity
@Table(name = "T_SCHEDULE_PLAN_D")
@org.hibernate.annotations.Entity(dynamicUpdate = true, dynamicInsert = true)
public class TSchedulePlanD extends BlameableEntity implements
		Comparable<TSchedulePlanD> {

	private static final long serialVersionUID = 3370405084436815869L;
	private Long id;
	/**
	 * 连场影片
	 */
	private THall tHall;
	private Long hallId;
	private Long filmId;
	private TFilm tFilm;
	private TSchedulePlanH header;
	private String roundNo;
	private String hallCode;
	private String type;
	private String language;
	/**
	 * 开放销售渠道
	 */
	private String channel;
	/**
	 * 销售渠道的数组表现形式
	 */
	private String[] channels;
	private Integer sortSeq;
	private Long runningTime;
	private Integer cleanTime;
	private Integer adTime;
	private Date startTime;
	private Date oldStartTime;
	private Date endTime;
	private int startTimeOffset;
	private int endTimeOffset;
	private Boolean published;
	/**
	 * 分账比例
	 * 
	 */
	private Integer rate;

	/**
	 * 会员优惠
	 */
	private Boolean memberDiscount;

	/**
	 * 对号入座
	 */
	private Boolean matchSeat;

	/**
	 * 场次有错误
	 */
	private Boolean error;

	/**
	 * 锁定场次可编辑
	 */
	private Boolean locked = false;

	/**
	 * 是否有初始化的票类票价。
	 */
	private Boolean priced;

	/**
	 * 场次是否已经广播到POS系统
	 * 
	 */
	private Boolean broadcast;
	public Object getfi;

	public TSchedulePlanD() {
	}

	public TSchedulePlanD(String roundNo) {
		this.roundNo = roundNo;
	}

	public TSchedulePlanD(TSchedulePlanH h) {
		this.header = h;
	}

	@Override
	public int compareTo(TSchedulePlanD o) {
		String hall1 = this.getHallCode();
		String hall2 = o.getHallCode();
		if (hall1 != null && hall2 != null) {
			int ret = hall1.compareTo(hall2);
			if (ret != 0) {
				return ret;
			}
		}
		Date st1 = this.getStartTime();
		Date st2 = o.getStartTime();
		// Integer seq1 = this.getSortSeq();
		// if (seq1 == null) {
		// seq1 = 1;
		// }
		// Integer seq2 = o.getSortSeq();
		// if (seq2 == null) {
		// seq2 = 1;
		// }
		int ret = 0;
		if (st1 == null) {
			ret = -1;
		} else if (st2 == null) {
			ret = 1;
		} else {
			ret = DateUtil.compareDateToField(st1, st2, Calendar.MINUTE);
		}
		return ret;
	}

	/**
	 * 实际片长是影片片长+广告时长。
	 * 
	 * @return
	 */
	@Transient
	public long getActualRunningTime() {
		return (this.getRunningTime() == null ? 0 : this.getRunningTime())
				+ (this.getAdTime() == null ? 0 : this.getAdTime());
	}

	@Column(name = "AD_TIME", precision = 38, scale = 0)
	public Integer getAdTime() {
		return adTime;
	}

	@Column(name = "broadcast")
	public Boolean getBroadcast() {
		return broadcast;
	}

	@Column(name = "CHANNEL", length = 50)
	public String getChannel() {
		return channel;
	}

	@Transient
	public String[] getChannels() {
		if (!StringUtil.isNullOrBlank(this.channel)) {
			this.channels = this.channel.split(",");
			Arrays.sort(this.channels);
		}
		return channels;
	}

	@Column(name = "CLEAN_TIME", precision = 38, scale = 0)
	public Integer getCleanTime() {
		return this.cleanTime;
	}

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "END_TIME")
	public Date getEndTime() {
		return this.endTime;
	}

	@Transient
	public int getEndTimeOffset() {
		return endTimeOffset;
	}

	@Column(name = "ERROR", length = 1)
	public Boolean getError() {
		return error;
	}

	@Column(name = "FILM_ID")
	public Long getFilmId() {
		return filmId;
	}

	@Column(name = "HALL_CODE")
	public String getHallCode() {
		if (StringUtil.isNullOrBlank(hallCode) && this.tHall != null) {
			this.hallCode = this.tHall.getName();
		}
		return hallCode;
	}

	@Column(name = "HALL_ID")
	public Long getHallId() {
		return hallId;
	}

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "SCHEDULE_PLAN_H_ID")
	@Cache(usage = CacheConcurrencyStrategy.READ_WRITE)
	public TSchedulePlanH getHeader() {
		return this.header;
	}

	@Override
	@Id
	// @GenericGenerator(name = "assignedGenerator", strategy = "assigned")
	// @GeneratedValue(generator = "assignedGenerator")
	@Column(name = "SEQID", unique = true, nullable = false, precision = 38, scale = 0)
	public Long getId() {
		return this.id;
	}

	@Column(name = "LANGUAGE")
	public String getLanguage() {
		return language;
	}

	@Column(name = "LOCKED", length = 1)
	public Boolean getLocked() {
		return locked;
	}

	@Column(name = "MATCH_SEAT")
	public Boolean getMatchSeat() {
		return matchSeat;
	}

	@Column(name = "MEMBER_DISCOUNT")
	public Boolean getMemberDiscount() {
		return memberDiscount;
	}

	@Transient
	public Date getOldStartTime() {
		if (oldStartTime == null) {
			return startTime;
		}
		return oldStartTime;
	}

	@Column(name = "PRICED")
	public Boolean getPriced() {
		return priced;
	}

	@Column(name = "PUBLISHED", length = 1)
	public Boolean getPublished() {
		return published;
	}

	@Column(name = "RATE")
	public Integer getRate() {
		return rate;
	}

	@Column(name = "ROUND_NO", nullable = false, length = 20)
	public String getRoundNo() {
		return this.roundNo;
	}

	@Column(name = "RUNNING_TIME", precision = 38, scale = 0)
	public Long getRunningTime() {
		if (this.runningTime == null || this.runningTime == 0) {
			this.runningTime = this.gettFilm() == null ? 0 : this.gettFilm()
					.getRunningTime();
		}
		return this.runningTime;
	}

	@Column(name = "SORT_SEQ", precision = 38, scale = 0)
	public Integer getSortSeq() {
		return sortSeq;
	}

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "START_TIME")
	public Date getStartTime() {
		return this.startTime;
	}

	@Transient
	public int getStartTimeOffset() {
		return startTimeOffset;
	}

	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "FILM_ID", insertable = false, updatable = false)
	@Cache(usage = CacheConcurrencyStrategy.READ_WRITE)
	public TFilm gettFilm() {
		return this.tFilm;
	}

	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "HALL_ID", insertable = false, updatable = false)
	@Cache(usage = CacheConcurrencyStrategy.READ_WRITE)
	public THall gettHall() {
		return this.tHall;
	}

	@Column(name = "TYPE", length = 2)
	public String getType() {
		return this.type;
	}
	
	/**
	 * 判断场次是否为未来日期。
	 * 
	 * @return
	 */
	@Transient
	public boolean isFuture() {
		Date currentDate = DateUtil.getCurrentDate();
		return currentDate.before(this.startTime);
	}

	public void setAdTime(Integer adTime) {
		this.adTime = adTime;
	}

	public void setBroadcast(Boolean broadcast) {
		this.broadcast = broadcast;
	}

	public void setChannel(String channel) {
		this.channel = channel;
	}

	public void setChannels(String[] channels) {
		this.channels = channels;
		if (this.channels != null) {
			Arrays.sort(channels);
			this.channel = ConvertUtil.convertArrayToCommaString(this.channels);
		} else {
			this.channel = null;
		}
	}

	public void setCleanTime(Integer cleanTime) {
		this.cleanTime = cleanTime;
	}

	public void setEndTime(Date endTime) {
		this.endTime = endTime;
	}

	public void setEndTimeOffset(int endTimeOffset) {
		this.endTimeOffset = endTimeOffset;
	}

	public void setError(Boolean error) {
		this.error = error;
	}

	public void setFilmId(Long filmId) {
		this.filmId = filmId;
	}

	public void setHallCode(String hallCode) {
		this.hallCode = hallCode;
	}

	public void setHallId(Long hallId) {
		this.hallId = hallId;
	}

	public void setHeader(TSchedulePlanH tSchedulePlanH) {
		this.header = tSchedulePlanH;
	}

	@Override
	public void setId(Long id) {
		this.id = id;
	}

	public void setLanguage(String language) {
		this.language = language;
	}

	public void setLocked(Boolean editable) {
		this.locked = editable;
	}

	public void setMatchSeat(Boolean matchSeat) {
		this.matchSeat = matchSeat;
	}

	public void setMemberDiscount(Boolean memberDiscount) {
		this.memberDiscount = memberDiscount;
	}

	public void setOldStartTime(Date oldStartTime) {
		this.oldStartTime = oldStartTime;
	}

	public void setPriced(Boolean priced) {
		this.priced = priced;
	}

	public void setPublished(Boolean published) {
		this.published = published;
		if (this.published == null) {
			this.published = false;
		}
	}

	public void setRate(Integer rate) {
		this.rate = rate;
	}

	public void setRoundNo(String roundNo) {
		this.roundNo = roundNo;
	}

	public void setRunningTime(Long runningTime) {
		this.runningTime = runningTime;
	}

	public void setSortSeq(Integer sortSeq) {
		this.sortSeq = sortSeq;
	}

	public void setStartTime(Date startTime) {
		if (this.startTime != null) {
			setOldStartTime((Date) this.startTime.clone());
		}
		this.startTime = startTime;
	}

	public void setStartTimeOffset(int startTimeOffset) {
		this.startTimeOffset = startTimeOffset;
	}

	public void settFilm(TFilm tFilm) {
		this.tFilm = tFilm;
	}

	public void settHall(THall tHall) {
		this.tHall = tHall;
	}

	public void setType(String roundSeq) {
		this.type = roundSeq;
	}

	@Override
	public String toString() {
		return "场次[" + StringUtil.avoidNull(roundNo)
				+ (StringUtil.isNullOrBlank(roundNo) ? "" : "， ")
				+ (tFilm == null ? "连场" : tFilm) + "， "
				+ DateUtil.formatDateTime(startTime) + " ~ "
				+ DateUtil.formatDateTime(endTime) + "]";
	}
}
