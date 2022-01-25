package com.candfms.models;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;

@Entity
@Table(name="SEMESTER")
@JsonIdentityInfo(generator = ObjectIdGenerators.PropertyGenerator.class, property = "id")

public class Semester {

	
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	private String name;	
	
	
	/*
	 * @OneToMany(mappedBy = "semester",cascade = CascadeType.ALL,orphanRemoval =
	 * true) private List<Coursout> coursouts = new ArrayList<>();
	 */
	
	
	
	@OneToMany(mappedBy="semester")
	public List<InstaOrderDetile> instaOrderDetiles;
	
	
	@OneToMany(mappedBy="semester")
	public List<Coursout> coursouts;
	
	@OneToMany(mappedBy="semester")
	public List<InstaOrder> instaOrders;
	
	@OneToMany(mappedBy="semester")
	public List<StuOrder> stuOrders;
	
	@OneToMany(mappedBy="semester",cascade = CascadeType.ALL,orphanRemoval = true)
	public List<LabOrder> labOrders;

	@OneToMany(mappedBy="semester")
	public List<ProformRequ> proformRequs;
	
	 @OneToMany(mappedBy="semester",cascade = CascadeType.ALL,orphanRemoval = true) 
	  public List<StuOrderDetile> StuOrderDetiles;
	  
	
	
	
	


	public List<StuOrderDetile> getStuOrderDetiles() {
		return StuOrderDetiles;
	}


	public void setStuOrderDetiles(List<StuOrderDetile> stuOrderDetiles) {
		StuOrderDetiles = stuOrderDetiles;
	}


	public List<InstaOrderDetile> getInstaOrderDetiles() {
		return instaOrderDetiles;
	}


	public void setInstaOrderDetiles(List<InstaOrderDetile> instaOrderDetiles) {
		this.instaOrderDetiles = instaOrderDetiles;
	}


	public List<StuOrder> getStuOrders() {
		return stuOrders;
	}


	public void setStuOrders(List<StuOrder> stuOrders) {
		this.stuOrders = stuOrders;
	}


	public List<LabOrder> getLabOrders() {
		return labOrders;
	}


	public void setLabOrders(List<LabOrder> labOrders) {
		this.labOrders = labOrders;
	}


	public List<ProformRequ> getProformRequs() {
		return proformRequs;
	}


	public void setProformRequs(List<ProformRequ> proformRequs) {
		this.proformRequs = proformRequs;
	}


	public List<InstaOrder> getInstaOrders() {
		return instaOrders;
	}


	public void setInstaOrders(List<InstaOrder> instaOrders) {
		this.instaOrders = instaOrders;
	}


	public int getId() {
		return id;
	}


	public void setId(int id) {
		this.id = id;
	}


	public String getName() {
		return name;
	}


	public void setName(String name) {
		this.name = name;
	}


	public List<Coursout> getCoursouts() {
		return coursouts;
	}


	public void setCoursouts(List<Coursout> coursouts) {
		this.coursouts = coursouts;
	}


}
