package com.candfms.models;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;


@Entity
@Table(name="FMIE")
@JsonIdentityInfo(generator = ObjectIdGenerators.PropertyGenerator.class, property = "id")

public class Fmie {

	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	private String name;	
	
	
	/*
	 * @OneToMany(mappedBy = "fmie",cascade = CascadeType.ALL,orphanRemoval = true)
	 * private List<Coursout> coursouts = new ArrayList<>();
	 * 	@JsonIgnore
	 */
	@OneToMany(mappedBy="fmie")
	@JsonIgnore
	public List<InstaCart> instaCarts;
	
	@OneToMany(mappedBy="fmie")
	@JsonIgnore
	public List<InstaOrderDetile> instaOrderDetiles;
	
	
	
	@OneToMany(mappedBy="fmie")
	@JsonIgnore
	public List<Coursout> coursouts;
	
	@OneToMany(mappedBy="fmie")
	@JsonIgnore
	public List<ProformRequ> proformRequs;
	

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


	public List<ProformRequ> getProformRequs() {
		return proformRequs;
	}


	public void setProformRequs(List<ProformRequ> proformRequs) {
		this.proformRequs = proformRequs;
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


	@Override
	public String toString() {
		return "Fmie [id=" + id + ", name=" + name + ", coursouts=" + coursouts + ", proformRequs=" + proformRequs
				+ ", getProformRequs()=" + getProformRequs() + ", getId()=" + getId() + ", getName()=" + getName()
				+ ", getCoursouts()=" + getCoursouts() + ", getClass()=" + getClass() + ", hashCode()=" + hashCode()
				+ ", toString()=" + super.toString() + "]";
	}


	public Fmie(int id, String name, List<Coursout> coursouts, List<ProformRequ> proformRequs) {
		super();
		this.id = id;
		this.name = name;
		this.coursouts = coursouts;
		this.proformRequs = proformRequs;
	}


	public Fmie() {
		
		
	}
	
	
	
}
