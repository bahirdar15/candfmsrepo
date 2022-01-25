package com.candfms.models;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;

@Entity
@Table(name="FEEDBACK")
@JsonIdentityInfo(generator = ObjectIdGenerators.PropertyGenerator.class, property = "id")
public class Feedback {
	
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int fId;
	private String nameoffeed;
	private String status;	
	@Column(length=5000)
	private String description;
	private int iass;
	
	
	private int approvedBy;
	
	/*
	 * @ManyToOne // forin Key
	 * 
	 * @JsonIgnore //not to serialize the user. private User user;
	 */
	
	@ManyToOne     // forin Key	
	@JsonIgnore //not to serialize the user.
	private Student student;
	
	public int getfId() {
		return fId;
	}
	public void setfId(int fId) {
		this.fId = fId;
	}
	public String getNameoffeed() {
		return nameoffeed;
	}
	public void setNameoffeed(String nameoffeed) {
		this.nameoffeed = nameoffeed;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}

	/*
	 * public User getUser() { return user; } public void setUser(User user) {
	 * this.user = user; }
	 */
	public Student getStudent() {
		return student;
	}
	public void setStudent(Student student) {
		this.student = student;
	}
	public int getApprovedBy() {
		return approvedBy;
	}
	public void setApprovedBy(int approvedBy) {
		this.approvedBy = approvedBy;
	}
	public int getIass() {
		return iass;
	}
	public void setIass(int iass) {
		this.iass = iass;
	}
	
	
	
	
	
	

}
