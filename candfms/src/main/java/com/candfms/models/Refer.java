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
@Table(name = "REFER")
@JsonIdentityInfo(generator = ObjectIdGenerators.PropertyGenerator.class, property = "id")
public class Refer {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	public int refId;
	
	
	public String refer1;
	public String refer2;
	public String refer3;
	public String refer4;
	public String refer5;
	public String refer6;
	public String refer7;
	public String refer8;
	public String refer9;
	public String refer10;

	
	
	
	
	@OneToMany(mappedBy="refer")
	public List<Coursout> coursouts;
	


	public int getRefId() {
		return refId;
	}
	public void setRefId(int refId) {
		this.refId = refId;
	}
	public String getRefer4() {
		return refer4;
	}
	public void setRefer4(String refer4) {
		this.refer4 = refer4;
	}
	public String getRefer5() {
		return refer5;
	}
	public void setRefer5(String refer5) {
		this.refer5 = refer5;
	}
	public String getRefer6() {
		return refer6;
	}
	public void setRefer6(String refer6) {
		this.refer6 = refer6;
	}
	public String getRefer7() {
		return refer7;
	}
	public void setRefer7(String refer7) {
		this.refer7 = refer7;
	}
	public String getRefer8() {
		return refer8;
	}
	public void setRefer8(String refer8) {
		this.refer8 = refer8;
	}
	public String getRefer9() {
		return refer9;
	}
	public void setRefer9(String refer9) {
		this.refer9 = refer9;
	}
	public String getRefer10() {
		return refer10;
	}
	public void setRefer10(String refer10) {
		this.refer10 = refer10;
	}
	
	public String getRefer1() {
		return refer1;
	}
	public void setRefer1(String refer1) {
		this.refer1 = refer1;
	}
	public String getRefer2() {
		return refer2;
	}
	public void setRefer2(String refer2) {
		this.refer2 = refer2;
	}
	public String getRefer3() {
		return refer3;
	}
	public void setRefer3(String refer3) {
		this.refer3 = refer3;
	}
	public List<Coursout> getCoursouts() {
		return coursouts;
	}
	public void setCoursouts(List<Coursout> coursouts) {
		this.coursouts = coursouts;
	}
	
	
	
	
}
