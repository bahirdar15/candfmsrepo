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
@Table(name = "USERCOURSOUTDETILE")
@JsonIdentityInfo(generator = ObjectIdGenerators.PropertyGenerator.class, property = "id")
public class UserCoursoutDetile {

	
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
	
	@ManyToOne
	@JoinColumn(name="userCoursoutAssignid", insertable=false, updatable=false)	    
	public UserCoursoutAssign userCoursoutAssign;	
	public Integer userCoursoutAssignid;
	
	@ManyToOne
	@JoinColumn(name="coursoutid", insertable=false, updatable=false)	    
	public Coursout coursout;	
	public Integer coursoutid;
	
	
	@OneToMany(mappedBy="userCoursoutDetile",cascade = CascadeType.ALL,orphanRemoval = true) 
	public List<InstaCart> instaCarts;
	
	@OneToMany(mappedBy="userCoursoutDetile",cascade = CascadeType.ALL,orphanRemoval = true) 
	public List<InstaOrderDetile> instaOrderDetiles;
	
	@OneToMany(mappedBy="userCoursoutDetile",cascade = CascadeType.ALL,orphanRemoval = true) 
	public List<StuCart> stuCarts;
	
	@OneToMany(mappedBy="userCoursoutDetile",cascade = CascadeType.ALL,orphanRemoval = true) 
	public List<StuOrderDetile> stuOrderDetiles;
	
	/*
	 * @OneToMany(mappedBy="userCoursoutDetile",cascade =
	 * CascadeType.ALL,orphanRemoval = true) public List<StuCart> stuCarts;
	 * 
	 * @OneToMany(mappedBy="userCoursoutDetile",cascade =
	 * CascadeType.ALL,orphanRemoval = true) public List<StuOrderDetile>
	 * stuOrderDetiles;
	 */
	
	
	
	public String getAssignstatust() {
		return assignstatust;
	}
	public List<InstaCart> getInstaCarts() {
		return instaCarts;
	}
	public void setInstaCarts(List<InstaCart> instaCarts) {
		this.instaCarts = instaCarts;
	}
	public List<InstaOrderDetile> getInstaOrderDetiles() {
		return instaOrderDetiles;
	}
	public void setInstaOrderDetiles(List<InstaOrderDetile> instaOrderDetiles) {
		this.instaOrderDetiles = instaOrderDetiles;
	}
	public List<StuCart> getStuCarts() {
		return stuCarts;
	}
	public void setStuCarts(List<StuCart> stuCarts) {
		this.stuCarts = stuCarts;
	}
	public List<StuOrderDetile> getStuOrderDetiles() {
		return stuOrderDetiles;
	}
	public void setStuOrderDetiles(List<StuOrderDetile> stuOrderDetiles) {
		this.stuOrderDetiles = stuOrderDetiles;
	}
	public void setAssignstatust(String assignstatust) {
		this.assignstatust = assignstatust;
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
	
	
	
	
	
	public UserCoursoutAssign getUserCoursoutAssign() {
		return userCoursoutAssign;
	}
	public void setUserCoursoutAssign(UserCoursoutAssign userCoursoutAssign) {
		this.userCoursoutAssign = userCoursoutAssign;
	}
	public Integer getUserCoursoutAssignid() {
		return userCoursoutAssignid;
	}
	public void setUserCoursoutAssignid(Integer userCoursoutAssignid) {
		this.userCoursoutAssignid = userCoursoutAssignid;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
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
	
	
	
	
	/* Getter and steer */
	
	
	
}
