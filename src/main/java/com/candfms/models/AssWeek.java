package com.candfms.models;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;

@Entity
@Table(name = "ASSWEEK")
@JsonIdentityInfo(generator = ObjectIdGenerators.PropertyGenerator.class, property = "id")
public class AssWeek {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int aswId;
	private String asswe1;
	private String asswe2;
	private String asswe3;
	private String asswe4;
	private String asswe5;
	private String asswe6;
	private String asswe7;
	private String asswe8;
	private String asswe9;
	
	
	
	@OneToMany(mappedBy="asweek")
	public List<Coursout> coursouts;



	public int getAswId() {
		return aswId;
	}



	public void setAswId(int aswId) {
		this.aswId = aswId;
	}



	public String getAsswe1() {
		return asswe1;
	}



	public void setAsswe1(String asswe1) {
		this.asswe1 = asswe1;
	}



	public String getAsswe2() {
		return asswe2;
	}



	public void setAsswe2(String asswe2) {
		this.asswe2 = asswe2;
	}



	public String getAsswe3() {
		return asswe3;
	}



	public void setAsswe3(String asswe3) {
		this.asswe3 = asswe3;
	}



	public String getAsswe4() {
		return asswe4;
	}



	public void setAsswe4(String asswe4) {
		this.asswe4 = asswe4;
	}



	public String getAsswe5() {
		return asswe5;
	}



	public void setAsswe5(String asswe5) {
		this.asswe5 = asswe5;
	}



	public String getAsswe6() {
		return asswe6;
	}



	public void setAsswe6(String asswe6) {
		this.asswe6 = asswe6;
	}



	public String getAsswe7() {
		return asswe7;
	}



	public void setAsswe7(String asswe7) {
		this.asswe7 = asswe7;
	}



	public String getAsswe8() {
		return asswe8;
	}



	public void setAsswe8(String asswe8) {
		this.asswe8 = asswe8;
	}



	public String getAsswe9() {
		return asswe9;
	}



	public void setAsswe9(String asswe9) {
		this.asswe9 = asswe9;
	}



	public List<Coursout> getCoursouts() {
		return coursouts;
	}



	public void setCoursouts(List<Coursout> coursouts) {
		this.coursouts = coursouts;
	}


	
	
	
}
