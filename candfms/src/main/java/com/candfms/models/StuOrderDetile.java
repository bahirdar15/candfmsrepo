package com.candfms.models;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;

@Entity
@Table(name = "STUORDERDETILE")
@JsonIdentityInfo(generator = ObjectIdGenerators.PropertyGenerator.class, property = "id")
public class StuOrderDetile {

	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	public int id;
	public String ncc;	
	public String ncp;	
	public String ncco;	
	public String nap;	
	public String nad;	
	public String naf;
	
	public String rema;	
	
	public String bam;
	public String ayear;
	public String section;
	public String prog;
	
	
	
	@ManyToOne
	@JoinColumn(name="coursoutid", insertable=false, updatable=false)	    
	public Coursout coursout;	
	public Integer coursoutid;
	
	@ManyToOne
	@JoinColumn(name="orderid", insertable=false, updatable=false)	    
	public StuOrder stuOrder;	
	public Integer orderid;
	
	@ManyToOne
	@JoinColumn(name="userCoursoutDetileid", insertable=false, updatable=false)	    
	public UserCoursoutDetile userCoursoutDetile;	
	public Integer userCoursoutDetileid;
	/* ========================= new ==============================================*/
	@ManyToOne
	@JoinColumn(name="userid", insertable=false, updatable=false)
	public User user;	
	public Integer userid;

	@ManyToOne
	@JoinColumn(name="semesterid", insertable=false, updatable=false)
	public Semester semester;	
	public Integer semesterid;
	
	@ManyToOne
	@JoinColumn(name="yearid", insertable=false, updatable=false)
	public Year year;	
	public Integer yearid;
	/*
	 * @ManyToOne
	 * 
	 * @JoinColumn(name="userCoursoutid", insertable=false, updatable=false) public
	 * UserCoursout userCoursout; public Integer userCoursoutid;
	 */
	

	
	/* geter and seter */
	
	
	
	public UserCoursoutDetile getUserCoursoutDetile() {
		return userCoursoutDetile;
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
	public String getSection() {
		return section;
	}
	public void setSection(String section) {
		this.section = section;
	}
	public String getProg() {
		return prog;
	}
	public void setProg(String prog) {
		this.prog = prog;
	}
	public User getUser() {
		return user;
	}
	public void setUser(User user) {
		this.user = user;
	}
	public Integer getUserid() {
		return userid;
	}
	public void setUserid(Integer userid) {
		this.userid = userid;
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
	public void setUserCoursoutDetile(UserCoursoutDetile userCoursoutDetile) {
		this.userCoursoutDetile = userCoursoutDetile;
	}
	public Integer getUserCoursoutDetileid() {
		return userCoursoutDetileid;
	}
	public void setUserCoursoutDetileid(Integer userCoursoutDetileid) {
		this.userCoursoutDetileid = userCoursoutDetileid;
	}
	
	public int getId() {
		return id;
	}
	public String getNcp() {
		return ncp;
	}
	public void setNcp(String ncp) {
		this.ncp = ncp;
	}
	public String getNcco() {
		return ncco;
	}
	public void setNcco(String ncco) {
		this.ncco = ncco;
	}
	public String getNap() {
		return nap;
	}
	public void setNap(String nap) {
		this.nap = nap;
	}
	public String getNad() {
		return nad;
	}
	public void setNad(String nad) {
		this.nad = nad;
	}
	public String getNaf() {
		return naf;
	}
	public void setNaf(String naf) {
		this.naf = naf;
	}
	
	public String getRema() {
		return rema;
	}
	public void setRema(String rema) {
		this.rema = rema;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getNcc() {
		return ncc;
	}
	public void setNcc(String ncc) {
		this.ncc = ncc;
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
	
	public Integer getOrderid() {
		return orderid;
	}
	public void setOrderid(Integer orderid) {
		this.orderid = orderid;
	}
	public StuOrder getStuOrder() {
		return stuOrder;
	}
	public void setStuOrder(StuOrder stuOrder) {
		this.stuOrder = stuOrder;
	}
	
	
	
	
	
}
