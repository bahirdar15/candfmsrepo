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
@Table(name = "METHODO")
@JsonIdentityInfo(generator = ObjectIdGenerators.PropertyGenerator.class, property = "id")
public class Methodo {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int methId;
	
	private String methowe11;
	private String methowe12;
	private String methowe13;
	
	private String methowe21;
	private String methowe22;
	private String methowe23;
	
	private String methowe31;
	private String methowe32;
	private String methowe33;
	
	private String methowe41;
	private String methowe42;
	private String methowe43;
	
	private String methowe51;
	private String methowe52;
	private String methowe53;
	
	private String methowe61;
	private String methowe62;
	private String methowe63;
	
	private String methowe71;
	private String methowe72;
	private String methowe73;
	
	private String methowe91;
	private String methowe92;
	private String methowe93;
	
	private String methowe101;
	private String methowe102;
	private String methowe103;
	
	private String methowe111;
	private String methowe112;
	private String methowe113;
	
	private String methowe121;
	private String methowe122;
	private String methowe123;
	
	private String methowe131;
	private String methowe132;
	private String methowe133;
	
	private String methowe141;
	private String methowe142;
	private String methowe143;
	
	private String methowe151;
	private String methowe152;
	private String methowe153;
	
	
	
	@OneToMany(mappedBy="methodo")
	public List<Coursout> coursouts;



	public int getMethId() {
		return methId;
	}



	public void setMethId(int methId) {
		this.methId = methId;
	}



	public String getMethowe11() {
		return methowe11;
	}



	public void setMethowe11(String methowe11) {
		this.methowe11 = methowe11;
	}



	public String getMethowe12() {
		return methowe12;
	}



	public void setMethowe12(String methowe12) {
		this.methowe12 = methowe12;
	}



	public String getMethowe13() {
		return methowe13;
	}



	public void setMethowe13(String methowe13) {
		this.methowe13 = methowe13;
	}



	public String getMethowe21() {
		return methowe21;
	}



	public void setMethowe21(String methowe21) {
		this.methowe21 = methowe21;
	}



	public String getMethowe22() {
		return methowe22;
	}



	public void setMethowe22(String methowe22) {
		this.methowe22 = methowe22;
	}



	public String getMethowe23() {
		return methowe23;
	}



	public void setMethowe23(String methowe23) {
		this.methowe23 = methowe23;
	}



	public String getMethowe31() {
		return methowe31;
	}



	public void setMethowe31(String methowe31) {
		this.methowe31 = methowe31;
	}



	public String getMethowe32() {
		return methowe32;
	}



	public void setMethowe32(String methowe32) {
		this.methowe32 = methowe32;
	}



	public String getMethowe33() {
		return methowe33;
	}



	public void setMethowe33(String methowe33) {
		this.methowe33 = methowe33;
	}



	public String getMethowe41() {
		return methowe41;
	}



	public void setMethowe41(String methowe41) {
		this.methowe41 = methowe41;
	}



	public String getMethowe42() {
		return methowe42;
	}



	public void setMethowe42(String methowe42) {
		this.methowe42 = methowe42;
	}



	public String getMethowe43() {
		return methowe43;
	}



	public void setMethowe43(String methowe43) {
		this.methowe43 = methowe43;
	}



	public String getMethowe51() {
		return methowe51;
	}



	public void setMethowe51(String methowe51) {
		this.methowe51 = methowe51;
	}



	public String getMethowe52() {
		return methowe52;
	}



	public void setMethowe52(String methowe52) {
		this.methowe52 = methowe52;
	}



	public String getMethowe53() {
		return methowe53;
	}



	public void setMethowe53(String methowe53) {
		this.methowe53 = methowe53;
	}



	public String getMethowe61() {
		return methowe61;
	}



	public void setMethowe61(String methowe61) {
		this.methowe61 = methowe61;
	}



	public String getMethowe62() {
		return methowe62;
	}



	public void setMethowe62(String methowe62) {
		this.methowe62 = methowe62;
	}



	public String getMethowe63() {
		return methowe63;
	}



	public void setMethowe63(String methowe63) {
		this.methowe63 = methowe63;
	}



	public String getMethowe71() {
		return methowe71;
	}



	public void setMethowe71(String methowe71) {
		this.methowe71 = methowe71;
	}



	public String getMethowe72() {
		return methowe72;
	}



	public void setMethowe72(String methowe72) {
		this.methowe72 = methowe72;
	}



	public String getMethowe73() {
		return methowe73;
	}



	public void setMethowe73(String methowe73) {
		this.methowe73 = methowe73;
	}



	public String getMethowe91() {
		return methowe91;
	}



	public void setMethowe91(String methowe91) {
		this.methowe91 = methowe91;
	}



	public String getMethowe92() {
		return methowe92;
	}



	public void setMethowe92(String methowe92) {
		this.methowe92 = methowe92;
	}



	public String getMethowe93() {
		return methowe93;
	}



	public void setMethowe93(String methowe93) {
		this.methowe93 = methowe93;
	}



	public String getMethowe101() {
		return methowe101;
	}



	public void setMethowe101(String methowe101) {
		this.methowe101 = methowe101;
	}



	public String getMethowe102() {
		return methowe102;
	}



	public void setMethowe102(String methowe102) {
		this.methowe102 = methowe102;
	}



	public String getMethowe103() {
		return methowe103;
	}



	public void setMethowe103(String methowe103) {
		this.methowe103 = methowe103;
	}



	public String getMethowe111() {
		return methowe111;
	}



	public void setMethowe111(String methowe111) {
		this.methowe111 = methowe111;
	}



	public String getMethowe112() {
		return methowe112;
	}



	public void setMethowe112(String methowe112) {
		this.methowe112 = methowe112;
	}



	public String getMethowe113() {
		return methowe113;
	}



	public void setMethowe113(String methowe113) {
		this.methowe113 = methowe113;
	}



	public String getMethowe121() {
		return methowe121;
	}



	public void setMethowe121(String methowe121) {
		this.methowe121 = methowe121;
	}



	public String getMethowe122() {
		return methowe122;
	}



	public void setMethowe122(String methowe122) {
		this.methowe122 = methowe122;
	}



	public String getMethowe123() {
		return methowe123;
	}



	public void setMethowe123(String methowe123) {
		this.methowe123 = methowe123;
	}



	public String getMethowe131() {
		return methowe131;
	}



	public void setMethowe131(String methowe131) {
		this.methowe131 = methowe131;
	}



	public String getMethowe132() {
		return methowe132;
	}



	public void setMethowe132(String methowe132) {
		this.methowe132 = methowe132;
	}



	public String getMethowe133() {
		return methowe133;
	}



	public void setMethowe133(String methowe133) {
		this.methowe133 = methowe133;
	}



	public String getMethowe141() {
		return methowe141;
	}



	public void setMethowe141(String methowe141) {
		this.methowe141 = methowe141;
	}



	public String getMethowe142() {
		return methowe142;
	}



	public void setMethowe142(String methowe142) {
		this.methowe142 = methowe142;
	}



	public String getMethowe143() {
		return methowe143;
	}



	public void setMethowe143(String methowe143) {
		this.methowe143 = methowe143;
	}



	public String getMethowe151() {
		return methowe151;
	}



	public void setMethowe151(String methowe151) {
		this.methowe151 = methowe151;
	}



	public String getMethowe152() {
		return methowe152;
	}



	public void setMethowe152(String methowe152) {
		this.methowe152 = methowe152;
	}



	public String getMethowe153() {
		return methowe153;
	}



	public void setMethowe153(String methowe153) {
		this.methowe153 = methowe153;
	}



	public List<Coursout> getCoursouts() {
		return coursouts;
	}



	public void setCoursouts(List<Coursout> coursouts) {
		this.coursouts = coursouts;
	}


	
	
	
}
