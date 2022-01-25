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
@Table(name = "ACTILAB")
@JsonIdentityInfo(generator = ObjectIdGenerators.PropertyGenerator.class, property = "id")
public class ActiLab {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int alabId;


	private String actlab11;
	private String actlab12;
	private String actlab13;
	
	private String actlab21;
	private String actlab22;
	private String actlab23;
	
	private String actlab31;
	private String actlab32;
	private String actlab33;
	
	private String actlab41;
	private String actlab42;
	private String actlab43;
	
	private String actlab51;
	private String actlab52;
	private String actlab53;
	
	private String actlab61;
	private String actlab62;
	private String actlab63;
	
	private String actlab71;
	private String actlab72;
	private String actlab73;
	
	private String actlab91;
	private String actlab92;
	private String actlab93;
	
	private String actlab101;
	private String actlab102;
	private String actlab103;
	
	private String actlab111;
	private String actlab112;
	private String actlab113;
	
	private String actlab121;
	private String actlab122;
	private String actlab123;
	
	private String actlab131;
	private String actlab132;
	private String actlab133;
	
	private String actlab141;
	private String actlab142;
	private String actlab143;
	
	private String actlab151;
	private String actlab152;
	private String actlab153;
	
	
	
	
	@OneToMany(mappedBy="actilab")
	public List<Coursout> coursouts;




	public int getAlabId() {
		return alabId;
	}




	public void setAlabId(int alabId) {
		this.alabId = alabId;
	}




	public String getActlab11() {
		return actlab11;
	}




	public void setActlab11(String actlab11) {
		this.actlab11 = actlab11;
	}




	public String getActlab12() {
		return actlab12;
	}




	public void setActlab12(String actlab12) {
		this.actlab12 = actlab12;
	}




	public String getActlab13() {
		return actlab13;
	}




	public void setActlab13(String actlab13) {
		this.actlab13 = actlab13;
	}




	public String getActlab21() {
		return actlab21;
	}




	public void setActlab21(String actlab21) {
		this.actlab21 = actlab21;
	}




	public String getActlab22() {
		return actlab22;
	}




	public void setActlab22(String actlab22) {
		this.actlab22 = actlab22;
	}




	public String getActlab23() {
		return actlab23;
	}




	public void setActlab23(String actlab23) {
		this.actlab23 = actlab23;
	}




	public String getActlab31() {
		return actlab31;
	}




	public void setActlab31(String actlab31) {
		this.actlab31 = actlab31;
	}




	public String getActlab32() {
		return actlab32;
	}




	public void setActlab32(String actlab32) {
		this.actlab32 = actlab32;
	}




	public String getActlab33() {
		return actlab33;
	}




	public void setActlab33(String actlab33) {
		this.actlab33 = actlab33;
	}




	public String getActlab41() {
		return actlab41;
	}




	public void setActlab41(String actlab41) {
		this.actlab41 = actlab41;
	}




	public String getActlab42() {
		return actlab42;
	}




	public void setActlab42(String actlab42) {
		this.actlab42 = actlab42;
	}




	public String getActlab43() {
		return actlab43;
	}




	public void setActlab43(String actlab43) {
		this.actlab43 = actlab43;
	}




	public String getActlab51() {
		return actlab51;
	}




	public void setActlab51(String actlab51) {
		this.actlab51 = actlab51;
	}




	public String getActlab52() {
		return actlab52;
	}




	public void setActlab52(String actlab52) {
		this.actlab52 = actlab52;
	}




	public String getActlab53() {
		return actlab53;
	}




	public void setActlab53(String actlab53) {
		this.actlab53 = actlab53;
	}




	public String getActlab61() {
		return actlab61;
	}




	public void setActlab61(String actlab61) {
		this.actlab61 = actlab61;
	}




	public String getActlab62() {
		return actlab62;
	}




	public void setActlab62(String actlab62) {
		this.actlab62 = actlab62;
	}




	public String getActlab63() {
		return actlab63;
	}




	public void setActlab63(String actlab63) {
		this.actlab63 = actlab63;
	}




	public String getActlab71() {
		return actlab71;
	}




	public void setActlab71(String actlab71) {
		this.actlab71 = actlab71;
	}




	public String getActlab72() {
		return actlab72;
	}




	public void setActlab72(String actlab72) {
		this.actlab72 = actlab72;
	}




	public String getActlab73() {
		return actlab73;
	}




	public void setActlab73(String actlab73) {
		this.actlab73 = actlab73;
	}




	public String getActlab91() {
		return actlab91;
	}




	public void setActlab91(String actlab91) {
		this.actlab91 = actlab91;
	}




	public String getActlab92() {
		return actlab92;
	}




	public void setActlab92(String actlab92) {
		this.actlab92 = actlab92;
	}




	public String getActlab93() {
		return actlab93;
	}




	public void setActlab93(String actlab93) {
		this.actlab93 = actlab93;
	}




	public String getActlab101() {
		return actlab101;
	}




	public void setActlab101(String actlab101) {
		this.actlab101 = actlab101;
	}




	public String getActlab102() {
		return actlab102;
	}




	public void setActlab102(String actlab102) {
		this.actlab102 = actlab102;
	}




	public String getActlab103() {
		return actlab103;
	}




	public void setActlab103(String actlab103) {
		this.actlab103 = actlab103;
	}




	public String getActlab111() {
		return actlab111;
	}




	public void setActlab111(String actlab111) {
		this.actlab111 = actlab111;
	}




	public String getActlab112() {
		return actlab112;
	}




	public void setActlab112(String actlab112) {
		this.actlab112 = actlab112;
	}




	public String getActlab113() {
		return actlab113;
	}




	public void setActlab113(String actlab113) {
		this.actlab113 = actlab113;
	}




	public String getActlab121() {
		return actlab121;
	}




	public void setActlab121(String actlab121) {
		this.actlab121 = actlab121;
	}




	public String getActlab122() {
		return actlab122;
	}




	public void setActlab122(String actlab122) {
		this.actlab122 = actlab122;
	}




	public String getActlab123() {
		return actlab123;
	}




	public void setActlab123(String actlab123) {
		this.actlab123 = actlab123;
	}




	public String getActlab131() {
		return actlab131;
	}




	public void setActlab131(String actlab131) {
		this.actlab131 = actlab131;
	}




	public String getActlab132() {
		return actlab132;
	}




	public void setActlab132(String actlab132) {
		this.actlab132 = actlab132;
	}




	public String getActlab133() {
		return actlab133;
	}




	public void setActlab133(String actlab133) {
		this.actlab133 = actlab133;
	}




	public String getActlab141() {
		return actlab141;
	}




	public void setActlab141(String actlab141) {
		this.actlab141 = actlab141;
	}




	public String getActlab142() {
		return actlab142;
	}




	public void setActlab142(String actlab142) {
		this.actlab142 = actlab142;
	}




	public String getActlab143() {
		return actlab143;
	}




	public void setActlab143(String actlab143) {
		this.actlab143 = actlab143;
	}




	public String getActlab151() {
		return actlab151;
	}




	public void setActlab151(String actlab151) {
		this.actlab151 = actlab151;
	}




	public String getActlab152() {
		return actlab152;
	}




	public void setActlab152(String actlab152) {
		this.actlab152 = actlab152;
	}




	public String getActlab153() {
		return actlab153;
	}




	public void setActlab153(String actlab153) {
		this.actlab153 = actlab153;
	}




	public List<Coursout> getCoursouts() {
		return coursouts;
	}




	public void setCoursouts(List<Coursout> coursouts) {
		this.coursouts = coursouts;
	}


	
	
	
}
