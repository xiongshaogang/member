package com.wanda.ccs.model;

// Generated 2012-1-12 17:18:19 by Hibernate Tools 3.2.4.GA

import static javax.persistence.GenerationType.SEQUENCE;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import com.xcesys.extras.core.dao.model.AbstractEntity;

/**
 * TNcOmJob generated by hbm2java
 */
@Entity
@Table(name = "T_NC_OM_JOB")
public class TNcOmJob extends AbstractEntity implements java.io.Serializable {
	private static final long serialVersionUID = -6201035360563678406L;
	
	private String pkOmJob;
	private String jobcode;
	private String jobname;
	private String pkDeptdoc;
	private Boolean isdeptrespon;
	private String pkOmDuty;
	private String suporior;
	private String builddate;
	private Boolean isabort;
	private String abortdate;
	private String jobseries;
	private String jobrank;
	private String worksumm;
	private String pkCorp;
	private String createcorp;
	private String bespvised;
	private String tospvise;
	private String incontact;
	private String outcontact;
	private String horisitu;
	private String pkJobdoc;
	private String junior;

	public TNcOmJob() {
	}

	public TNcOmJob(String jobcode, String builddate, Boolean isabort) {
		this.jobcode = jobcode;
		this.builddate = builddate;
		this.isabort = isabort;
	}

	public TNcOmJob(String jobcode, String jobname, String pkDeptdoc,
			Boolean isdeptrespon, String pkOmDuty, String suporior,
			String builddate, Boolean isabort, String abortdate,
			String jobseries, String jobrank, String worksumm, String pkCorp,
			String createcorp, String bespvised, String tospvise,
			String incontact, String outcontact, String horisitu,
			String pkJobdoc, String junior) {
		this.jobcode = jobcode;
		this.jobname = jobname;
		this.pkDeptdoc = pkDeptdoc;
		this.isdeptrespon = isdeptrespon;
		this.pkOmDuty = pkOmDuty;
		this.suporior = suporior;
		this.builddate = builddate;
		this.isabort = isabort;
		this.abortdate = abortdate;
		this.jobseries = jobseries;
		this.jobrank = jobrank;
		this.worksumm = worksumm;
		this.pkCorp = pkCorp;
		this.createcorp = createcorp;
		this.bespvised = bespvised;
		this.tospvise = tospvise;
		this.incontact = incontact;
		this.outcontact = outcontact;
		this.horisitu = horisitu;
		this.pkJobdoc = pkJobdoc;
		this.junior = junior;
	}

	@SequenceGenerator(name = "generator", sequenceName = "S_T_NC_OM_JOB")
	@Id
	@GeneratedValue(strategy = SEQUENCE, generator = "generator")
	@Column(name = "PK_OM_JOB", unique = true, nullable = false, length = 20)
	public String getPkOmJob() {
		return this.pkOmJob;
	}

	public void setPkOmJob(String pkOmJob) {
		this.pkOmJob = pkOmJob;
	}

	@Column(name = "JOBCODE", nullable = false, length = 28)
	public String getJobcode() {
		return this.jobcode;
	}

	public void setJobcode(String jobcode) {
		this.jobcode = jobcode;
	}

	@Column(name = "JOBNAME", length = 20)
	public String getJobname() {
		return this.jobname;
	}

	public void setJobname(String jobname) {
		this.jobname = jobname;
	}

	@Column(name = "PK_DEPTDOC", length = 20)
	public String getPkDeptdoc() {
		return this.pkDeptdoc;
	}

	public void setPkDeptdoc(String pkDeptdoc) {
		this.pkDeptdoc = pkDeptdoc;
	}

	@Column(name = "ISDEPTRESPON", length = 1)
	public Boolean getIsdeptrespon() {
		return this.isdeptrespon;
	}

	public void setIsdeptrespon(Boolean isdeptrespon) {
		this.isdeptrespon = isdeptrespon;
	}

	@Column(name = "PK_OM_DUTY", length = 20)
	public String getPkOmDuty() {
		return this.pkOmDuty;
	}

	public void setPkOmDuty(String pkOmDuty) {
		this.pkOmDuty = pkOmDuty;
	}

	@Column(name = "SUPORIOR", length = 20)
	public String getSuporior() {
		return this.suporior;
	}

	public void setSuporior(String suporior) {
		this.suporior = suporior;
	}

	@Column(name = "BUILDDATE", nullable = false, length = 10)
	public String getBuilddate() {
		return this.builddate;
	}

	public void setBuilddate(String builddate) {
		this.builddate = builddate;
	}

	@Column(name = "ISABORT", nullable = false, length = 1)
	public Boolean getIsabort() {
		return this.isabort;
	}

	public void setIsabort(Boolean isabort) {
		this.isabort = isabort;
	}

	@Column(name = "ABORTDATE", length = 10)
	public String getAbortdate() {
		return this.abortdate;
	}

	public void setAbortdate(String abortdate) {
		this.abortdate = abortdate;
	}

	@Column(name = "JOBSERIES", length = 20)
	public String getJobseries() {
		return this.jobseries;
	}

	public void setJobseries(String jobseries) {
		this.jobseries = jobseries;
	}

	@Column(name = "JOBRANK", length = 20)
	public String getJobrank() {
		return this.jobrank;
	}

	public void setJobrank(String jobrank) {
		this.jobrank = jobrank;
	}

	@Column(name = "WORKSUMM", length = 1000)
	public String getWorksumm() {
		return this.worksumm;
	}

	public void setWorksumm(String worksumm) {
		this.worksumm = worksumm;
	}

	@Column(name = "PK_CORP", length = 4)
	public String getPkCorp() {
		return this.pkCorp;
	}

	public void setPkCorp(String pkCorp) {
		this.pkCorp = pkCorp;
	}

	@Column(name = "CREATECORP", length = 4)
	public String getCreatecorp() {
		return this.createcorp;
	}

	public void setCreatecorp(String createcorp) {
		this.createcorp = createcorp;
	}

	@Column(name = "BESPVISED", length = 256)
	public String getBespvised() {
		return this.bespvised;
	}

	public void setBespvised(String bespvised) {
		this.bespvised = bespvised;
	}

	@Column(name = "TOSPVISE", length = 256)
	public String getTospvise() {
		return this.tospvise;
	}

	public void setTospvise(String tospvise) {
		this.tospvise = tospvise;
	}

	@Column(name = "INCONTACT", length = 256)
	public String getIncontact() {
		return this.incontact;
	}

	public void setIncontact(String incontact) {
		this.incontact = incontact;
	}

	@Column(name = "OUTCONTACT", length = 256)
	public String getOutcontact() {
		return this.outcontact;
	}

	public void setOutcontact(String outcontact) {
		this.outcontact = outcontact;
	}

	@Column(name = "HORISITU", length = 256)
	public String getHorisitu() {
		return this.horisitu;
	}

	public void setHorisitu(String horisitu) {
		this.horisitu = horisitu;
	}

	@Column(name = "PK_JOBDOC", length = 20)
	public String getPkJobdoc() {
		return this.pkJobdoc;
	}

	public void setPkJobdoc(String pkJobdoc) {
		this.pkJobdoc = pkJobdoc;
	}

	@Column(name = "JUNIOR", length = 1024)
	public String getJunior() {
		return this.junior;
	}

	public void setJunior(String junior) {
		this.junior = junior;
	}

	@Override
	public Long getId() {
		return null;
	}

	@Override
	public void setId(Long arg0) {
		
	}

}
