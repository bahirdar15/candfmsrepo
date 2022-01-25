package com.candfms.models;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "switcch")
public class Switcch {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;	
	private Integer idswitcch;


	public Integer getId() {
		return id;
	}


	public void setId(Integer id) {
		this.id = id;
	}


	public Integer getIdswitcch() {
		return idswitcch;
	}


	public void setIdswitcch(Integer idswitcch) {
		this.idswitcch = idswitcch;
	}
	
}
