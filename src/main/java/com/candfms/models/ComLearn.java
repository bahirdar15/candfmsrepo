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
@Table(name = "COMLEARN")
@JsonIdentityInfo(generator = ObjectIdGenerators.PropertyGenerator.class, property = "id")
public class ComLearn {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int clenId;
	private String comlearn1;
	private String comlearn2;
	private String comlearn3;
	private String comlearn4;
	private String comlearn5;
	
	
	
	@OneToMany(mappedBy="comlearn")
	public List<Coursout> coursouts;



	public int getClenId() {
		return clenId;
	}



	public void setClenId(int clenId) {
		this.clenId = clenId;
	}



	public String getComlearn1() {
		return comlearn1;
	}



	public void setComlearn1(String comlearn1) {
		this.comlearn1 = comlearn1;
	}



	public String getComlearn2() {
		return comlearn2;
	}



	public void setComlearn2(String comlearn2) {
		this.comlearn2 = comlearn2;
	}



	public String getComlearn3() {
		return comlearn3;
	}



	public void setComlearn3(String comlearn3) {
		this.comlearn3 = comlearn3;
	}



	public String getComlearn4() {
		return comlearn4;
	}



	public void setComlearn4(String comlearn4) {
		this.comlearn4 = comlearn4;
	}



	public String getComlearn5() {
		return comlearn5;
	}



	public void setComlearn5(String comlearn5) {
		this.comlearn5 = comlearn5;
	}



	public List<Coursout> getCoursouts() {
		return coursouts;
	}



	public void setCoursouts(List<Coursout> coursouts) {
		this.coursouts = coursouts;
	}


	
	
	
}
