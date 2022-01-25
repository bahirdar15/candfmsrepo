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
@Table(name="YEAR")
@JsonIdentityInfo(generator = ObjectIdGenerators.PropertyGenerator.class, property = "id")
public class Year {

	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	private String name;	
	
	
	/*
	 * @OneToMany(mappedBy = "year",cascade = CascadeType.ALL,orphanRemoval = true)
	 * private List<Coursout> coursouts = new ArrayList<>();
	 */
	
	@OneToMany(mappedBy="year")
	public List<InstaCart> instaCarts;
	
	@OneToMany(mappedBy="year")
	public List<InstaOrderDetile> instaOrderDetiles;
	
	
	
	
	
	
	@OneToMany(mappedBy="year")
	public List<Coursout> coursouts;
	
	
	@OneToMany(mappedBy="year")
	public List<LabOrder> labOrders;
	
	@OneToMany(mappedBy="year")
	public List<StuOrder> stuOrders;
	
	 @OneToMany(mappedBy="year",cascade = CascadeType.ALL,orphanRemoval = true) 
	  public List<StuOrderDetile> StuOrderDetiles;
	  

	public List<StuOrderDetile> getStuOrderDetiles() {
		return StuOrderDetiles;
	}


	public void setStuOrderDetiles(List<StuOrderDetile> stuOrderDetiles) {
		StuOrderDetiles = stuOrderDetiles;
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


	public List<LabOrder> getLabOrders() {
		return labOrders;
	}


	public void setLabOrders(List<LabOrder> labOrders) {
		this.labOrders = labOrders;
	}


	public List<StuOrder> getStuOrders() {
		return stuOrders;
	}


	public void setStuOrders(List<StuOrder> stuOrders) {
		this.stuOrders = stuOrders;
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
