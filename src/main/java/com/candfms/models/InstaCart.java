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
@Table(name = "INSTACART")
@JsonIdentityInfo(generator = ObjectIdGenerators.PropertyGenerator.class, property = "id")
public class InstaCart {

	
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
	/* public String prog; */
	public String rema;	
	
	
	@ManyToOne
	@JoinColumn(name="fmieid", insertable=false, updatable=false)
	public Fmie fmie;	
	public Integer fmieid;
	
	
	@ManyToOne
	@JoinColumn(name="yearid", insertable=false, updatable=false)
	public Year year;	
	public Integer yearid;

	
	
	
	
	
	
	@ManyToOne
	@JoinColumn(name="userid", insertable=false, updatable=false)
	public User user;	
	public Integer userid;
	
	
	@ManyToOne
	@JoinColumn(name="coursoutid", insertable=false, updatable=false)	    
	public Coursout coursout;	
	public Integer coursoutid;
	
	@ManyToOne
	@JoinColumn(name="userCoursoutDetileid", insertable=false, updatable=false)	    
	public UserCoursoutDetile userCoursoutDetile;	
	public Integer userCoursoutDetileid;
	
	/*
	 * @ManyToOne
	 * 
	 * @JoinColumn(name="userCoursoutid", insertable=false, updatable=false) public
	 * UserCoursout userCoursout; public Integer userCoursoutid;
	 * 
	 */
	
	
	/* Getter and steer */
	
	
	public int getId() {
		return id;
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
	public int getNap() {
		return nap;
	}
	public void setNap(int nap) {
		this.nap = nap;
	}
	public void setId(int id) {
		this.id = id;
	}
	public int getNcco() {
		return ncco;
	}
	public void setNcco(int ncco) {
		this.ncco = ncco;
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
	
	public String getRema() {
		return rema;
	}
	public void setRema(String rema) {
		this.rema = rema;
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
