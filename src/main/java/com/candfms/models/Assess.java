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
@Table(name = "ASSESS")
@JsonIdentityInfo(generator = ObjectIdGenerators.PropertyGenerator.class, property = "id")
public class Assess {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int asseId;
	private String asses11;
	private String asses12;
	private String asses13;
	
	private String asses21;
	private String asses22;
	private String asses23;
	
	private String asses31;
	private String asses32;
	private String asses33;
	
	private String asses41;
	private String asses42;
	private String asses43;
	
	private String asses51;
	private String asses52;
	private String asses53;
	
	private String asses61;
	private String asses62;
	private String asses63;
	
	private String asses71;
	private String asses72;
	private String asses73;
	
	private String asses81;
	private String asses82;
	private String asses83;
	
	private String asses91;
	private String asses92;
	private String asses93;
	
	private String asstotal;
	
	
	@OneToMany(mappedBy="assess")
	public List<Coursout> coursouts;


	


	



	public int getAsseId() {
		return asseId;
	}


	public void setAsseId(int asseId) {
		this.asseId = asseId;
	}


	public String getAsses11() {
		return asses11;
	}


	public void setAsses11(String asses11) {
		this.asses11 = asses11;
	}


	public String getAsses12() {
		return asses12;
	}


	public void setAsses12(String asses12) {
		this.asses12 = asses12;
	}


	public String getAsses13() {
		return asses13;
	}


	public void setAsses13(String asses13) {
		this.asses13 = asses13;
	}


	public String getAsses21() {
		return asses21;
	}


	public void setAsses21(String asses21) {
		this.asses21 = asses21;
	}


	public String getAsses22() {
		return asses22;
	}


	public void setAsses22(String asses22) {
		this.asses22 = asses22;
	}


	public String getAsses23() {
		return asses23;
	}


	public void setAsses23(String asses23) {
		this.asses23 = asses23;
	}


	public String getAsses31() {
		return asses31;
	}


	public void setAsses31(String asses31) {
		this.asses31 = asses31;
	}


	public String getAsses32() {
		return asses32;
	}


	public void setAsses32(String asses32) {
		this.asses32 = asses32;
	}


	public String getAsses33() {
		return asses33;
	}


	public void setAsses33(String asses33) {
		this.asses33 = asses33;
	}


	public String getAsses41() {
		return asses41;
	}


	public void setAsses41(String asses41) {
		this.asses41 = asses41;
	}


	public String getAsses42() {
		return asses42;
	}


	public void setAsses42(String asses42) {
		this.asses42 = asses42;
	}


	public String getAsses43() {
		return asses43;
	}


	public void setAsses43(String asses43) {
		this.asses43 = asses43;
	}


	public String getAsses51() {
		return asses51;
	}


	public void setAsses51(String asses51) {
		this.asses51 = asses51;
	}


	public String getAsses52() {
		return asses52;
	}


	public void setAsses52(String asses52) {
		this.asses52 = asses52;
	}


	public String getAsses53() {
		return asses53;
	}


	public void setAsses53(String asses53) {
		this.asses53 = asses53;
	}


	public String getAsses61() {
		return asses61;
	}


	public void setAsses61(String asses61) {
		this.asses61 = asses61;
	}


	public String getAsses62() {
		return asses62;
	}


	public void setAsses62(String asses62) {
		this.asses62 = asses62;
	}


	public String getAsses63() {
		return asses63;
	}


	public void setAsses63(String asses63) {
		this.asses63 = asses63;
	}


	public String getAsses71() {
		return asses71;
	}


	public void setAsses71(String asses71) {
		this.asses71 = asses71;
	}


	public String getAsses72() {
		return asses72;
	}


	public void setAsses72(String asses72) {
		this.asses72 = asses72;
	}


	public String getAsses73() {
		return asses73;
	}


	public void setAsses73(String asses73) {
		this.asses73 = asses73;
	}


	public String getAsses81() {
		return asses81;
	}


	public void setAsses81(String asses81) {
		this.asses81 = asses81;
	}


	public String getAsses82() {
		return asses82;
	}


	public void setAsses82(String asses82) {
		this.asses82 = asses82;
	}


	public String getAsses83() {
		return asses83;
	}


	public void setAsses83(String asses83) {
		this.asses83 = asses83;
	}


	public String getAsses91() {
		return asses91;
	}


	public void setAsses91(String asses91) {
		this.asses91 = asses91;
	}


	public String getAsses92() {
		return asses92;
	}


	public void setAsses92(String asses92) {
		this.asses92 = asses92;
	}


	public String getAsses93() {
		return asses93;
	}


	public void setAsses93(String asses93) {
		this.asses93 = asses93;
	}


	public String getAsstotal() {
		return asstotal;
	}


	public void setAsstotal(String asstotal) {
		this.asstotal = asstotal;
	}


	public List<Coursout> getCoursouts() {
		return coursouts;
	}


	public void setCoursouts(List<Coursout> coursouts) {
		this.coursouts = coursouts;
	}
	
	
	
	
	
	
}
