package com.candfms.models;

import java.util.List;

import javax.persistence.CascadeType;
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
@Table(name = "USERCOURSOUTASSIGN")
@JsonIdentityInfo(generator = ObjectIdGenerators.PropertyGenerator.class, property = "id")
public class UserCoursoutAssign {

	

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	public int id;
	
	public int instaId;
	public String assignstatust;
	public String statust;
	
	public String assigndate;
	public String reqdate;
	public String apprdate;
	
	
	
	@ManyToOne
	@JoinColumn(name="userid", insertable=false, updatable=false)
	public User user;	
	public Integer userid;
	
	
	@OneToMany(mappedBy="userCoursoutAssign",cascade = CascadeType.ALL,orphanRemoval = true) 
	public List<UserCoursoutDetile> userCoursoutDetiles;


	public int getId() {
		return id;
	}


	public String getAssignstatust() {
		return assignstatust;
	}


	public void setAssignstatust(String assignstatust) {
		this.assignstatust = assignstatust;
	}


	public void setId(int id) {
		this.id = id;
	}


	public int getInstaId() {
		return instaId;
	}


	public void setInstaId(int instaId) {
		this.instaId = instaId;
	}


	public String getStatust() {
		return statust;
	}


	public void setStatust(String statust) {
		this.statust = statust;
	}


	public String getAssigndate() {
		return assigndate;
	}


	public void setAssigndate(String assigndate) {
		this.assigndate = assigndate;
	}


	public String getReqdate() {
		return reqdate;
	}


	public void setReqdate(String reqdate) {
		this.reqdate = reqdate;
	}


	public String getApprdate() {
		return apprdate;
	}


	public void setApprdate(String apprdate) {
		this.apprdate = apprdate;
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


	public List<UserCoursoutDetile> getUserCoursoutDetiles() {
		return userCoursoutDetiles;
	}


	public void setUserCoursoutDetiles(List<UserCoursoutDetile> userCoursoutDetiles) {
		this.userCoursoutDetiles = userCoursoutDetiles;
	}
	
	
	
}
