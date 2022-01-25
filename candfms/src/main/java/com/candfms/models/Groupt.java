package com.candfms.models;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;

import com.fasterxml.jackson.annotation.ObjectIdGenerators;

@Entity
@Table(name="GROUPT")
@JsonIdentityInfo(generator = ObjectIdGenerators.PropertyGenerator.class, property = "id")

public class Groupt {

	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	private String name;	
	
	
	/*
	 * @OneToMany(mappedBy = "groupt",cascade = CascadeType.ALL,orphanRemoval =
	 * true) private List<Coursout> coursouts = new ArrayList<>();
	 */
	@OneToMany(mappedBy="groupt")
	public List<Coursout> coursouts;

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
