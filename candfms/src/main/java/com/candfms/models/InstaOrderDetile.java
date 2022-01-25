package com.candfms.models;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;

@Entity
@Table(name = "INSTAORDERDETILE")
@JsonIdentityInfo(generator = ObjectIdGenerators.PropertyGenerator.class, property = "id")
public class InstaOrderDetile {

	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	public int id;
	public int ncc;	//
	public int ncp;	//
	public int ncco;	
	public int nap;	//
	public int nad;	
	public int naf;	
	
		
	public String sect;	
	public String prog;	
	public String rema;	
	
	public String bam;
	public String ayear;
	public int approvedby;
	public int endorsedby;
	public int filledby;
	
	public int compaid;
	public int endorsdeanid;
	public String copadate;
	public String endorsedeandate;
	/*
	 * public int chapbfmidplan; 
	 * public int chapafmidplan; 
	 * public int assbfmidplan;
	 * public int assafmidplan;
	 */
	
	@ManyToOne
	@JoinColumn(name="fmieid", insertable=false, updatable=false)
	public Fmie fmie;	
	public Integer fmieid;
	
	
	@ManyToOne
	@JoinColumn(name="yearid", insertable=false, updatable=false)
	public Year year;	
	public Integer yearid;

	
	@ManyToOne
	@JoinColumn(name="semesterid", insertable=false, updatable=false)
	public Semester semester;	
	public Integer semesterid;
	
	
	
	@ManyToOne
	@JoinColumn(name="coursoutid", insertable=false, updatable=false)	    
	public Coursout coursout;	
	public Integer coursoutid;
	
	@ManyToOne
	@JoinColumn(name="orderid", insertable=false, updatable=false)	    
	public InstaOrder instaOrder;	
	public Integer orderid;
	
	
	@ManyToOne
	@JoinColumn(name="userCoursoutDetileid", insertable=false, updatable=false)	    
	public UserCoursoutDetile userCoursoutDetile;	
	public Integer userCoursoutDetileid;
	
	
	
	

	/*
	 * @ManyToOne
	 * 
	 * @JoinColumn(name="userCoursoutid", insertable=false, updatable=false) public
	 * UserCoursout userCoursout; public Integer userCoursoutid;
	 */

	
	/* geter and seter */
	
	
	
	public int getId() {
		return id;
	}
	
	public int getFilledby() {
		return filledby;
	}

	public void setFilledby(int filledby) {
		this.filledby = filledby;
	}

	public int getCompaid() {
		return compaid;
	}

	public void setCompaid(int compaid) {
		this.compaid = compaid;
	}

	public int getEndorsdeanid() {
		return endorsdeanid;
	}

	public void setEndorsdeanid(int endorsdeanid) {
		this.endorsdeanid = endorsdeanid;
	}

	public String getCopadate() {
		return copadate;
	}

	public void setCopadate(String copadate) {
		this.copadate = copadate;
	}

	public String getEndorsedeandate() {
		return endorsedeandate;
	}

	public void setEndorsedeandate(String endorsedeandate) {
		this.endorsedeandate = endorsedeandate;
	}

	public void setId(int id) {
		this.id = id;
	}
	public int getNcc() {
		return ncc;
	}
	public void setNcc(int ncc) {
		this.ncc = ncc;
	}
	public int getNcp() {
		return ncp;
	}
	public void setNcp(int ncp) {
		this.ncp = ncp;
	}
	public int getNcco() {
		return ncco;
	}
	public void setNcco(int ncco) {
		this.ncco = ncco;
	}
	public int getNap() {
		return nap;
	}
	public void setNap(int nap) {
		this.nap = nap;
	}
	public int getNad() {
		return nad;
	}
	public void setNad(int nad) {
		this.nad = nad;
	}
	public int getNaf() {
		return naf;
	}
	public void setNaf(int naf) {
		this.naf = naf;
	}
	public String getSect() {
		return sect;
	}
	public void setSect(String sect) {
		this.sect = sect;
	}
	public String getProg() {
		return prog;
	}
	public void setProg(String prog) {
		this.prog = prog;
	}
	public String getRema() {
		return rema;
	}
	public void setRema(String rema) {
		this.rema = rema;
	}
	public String getBam() {
		return bam;
	}
	public void setBam(String bam) {
		this.bam = bam;
	}
	public String getAyear() {
		return ayear;
	}
	public void setAyear(String ayear) {
		this.ayear = ayear;
	}
	public int getApprovedby() {
		return approvedby;
	}
	public void setApprovedby(int approvedby) {
		this.approvedby = approvedby;
	}
	public int getEndorsedby() {
		return endorsedby;
	}
	public void setEndorsedby(int endorsedby) {
		this.endorsedby = endorsedby;
	}
	public Fmie getFmie() {
		return fmie;
	}
	public void setFmie(Fmie fmie) {
		this.fmie = fmie;
	}
	public Integer getFmieid() {
		return fmieid;
	}
	public void setFmieid(Integer fmieid) {
		this.fmieid = fmieid;
	}
	public Year getYear() {
		return year;
	}
	public void setYear(Year year) {
		this.year = year;
	}
	public Integer getYearid() {
		return yearid;
	}
	public void setYearid(Integer yearid) {
		this.yearid = yearid;
	}
	public Semester getSemester() {
		return semester;
	}
	public void setSemester(Semester semester) {
		this.semester = semester;
	}
	public Integer getSemesterid() {
		return semesterid;
	}
	public void setSemesterid(Integer semesterid) {
		this.semesterid = semesterid;
	}
	public Coursout getCoursout() {
		return coursout;
	}
	public void setCoursout(Coursout coursout) {
		this.coursout = coursout;
	}
	public Integer getCoursoutid() {
		return coursoutid;
	}
	public void setCoursoutid(Integer coursoutid) {
		this.coursoutid = coursoutid;
	}
	public InstaOrder getInstaOrder() {
		return instaOrder;
	}
	public void setInstaOrder(InstaOrder instaOrder) {
		this.instaOrder = instaOrder;
	}
	public Integer getOrderid() {
		return orderid;
	}
	public void setOrderid(Integer orderid) {
		this.orderid = orderid;
	}
	public UserCoursoutDetile getUserCoursoutDetile() {
		return userCoursoutDetile;
	}
	public void setUserCoursoutDetile(UserCoursoutDetile userCoursoutDetile) {
		this.userCoursoutDetile = userCoursoutDetile;
	}
	public Integer getUserCoursoutDetileid() {
		return userCoursoutDetileid;
	}
	public void setUserCoursoutDetileid(Integer userCoursoutDetileid) {
		this.userCoursoutDetileid = userCoursoutDetileid;
	}
	
	
	
	
}
