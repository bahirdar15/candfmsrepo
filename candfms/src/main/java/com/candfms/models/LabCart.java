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
@Table(name = "LABCART")
@JsonIdentityInfo(generator = ObjectIdGenerators.PropertyGenerator.class, property = "id")
public class LabCart {

	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	public int id;
	public String week;	
	public String lname;	
	public String instrac;	
	public String assista;	
	public String student;	
	public String rema;	
	
	
	@ManyToOne
	@JoinColumn(name="orderid", insertable=false, updatable=false)	    
	public LabOrder labOrder;	
	public Integer orderid;
	
	@ManyToOne
	@JoinColumn(name="userid", insertable=false, updatable=false)
	public User user;	
	public Integer userid;
	
	
	
	
	
	
	
	/* geter and seter */
	
	
	
	public int getId() {
		return id;
	}
	
	
	public String getWeek() {
		return week;
	}


	public void setWeek(String week) {
		this.week = week;
	}


	public String getLname() {
		return lname;
	}


	public void setLname(String lname) {
		this.lname = lname;
	}


	public String getInstrac() {
		return instrac;
	}


	public void setInstrac(String instrac) {
		this.instrac = instrac;
	}


	public String getAssista() {
		return assista;
	}


	public void setAssista(String assista) {
		this.assista = assista;
	}


	public String getStudent() {
		return student;
	}


	public void setStudent(String student) {
		this.student = student;
	}


	public LabOrder getLabOrder() {
		return labOrder;
	}


	public void setLabOrder(LabOrder labOrder) {
		this.labOrder = labOrder;
	}


	public Integer getOrderid() {
		return orderid;
	}


	public void setOrderid(Integer orderid) {
		this.orderid = orderid;
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
	
	
	
}
