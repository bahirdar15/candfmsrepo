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
@Table(name = "STUCART")
@JsonIdentityInfo(generator = ObjectIdGenerators.PropertyGenerator.class, property = "id")
public class StuCart {

	
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
	 */
	
	/* geter and seter */
	
	
	
	public int getId() {
		return id;
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
	public String getNcc() {
		return ncc;
	}
	public void setNcc(String ncc) {
		this.ncc = ncc;
	}
	public void setId(int id) {
		this.id = id;
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
	
	
}
