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
@Table(name = "TABREF")
@JsonIdentityInfo(generator = ObjectIdGenerators.PropertyGenerator.class, property = "id")
public class TabRef {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int tbrId;


	private String tabref11;
	private String tabref12;
	private String tabref13;
	
	private String tabref21;
	private String tabref22;
	private String tabref23;
	
	private String tabref31;
	private String tabref32;
	private String tabref33;
	
	private String tabref41;
	private String tabref42;
	private String tabref43;
	
	private String tabref51;
	private String tabref52;
	private String tabref53;
	
	private String tabref61;
	private String tabref62;
	private String tabref63;
	
	private String tabref71;
	private String tabref72;
	private String tabref73;
	
	private String tabref91;
	private String tabref92;
	private String tabref93;
	
	private String tabref101;
	private String tabref102;
	private String tabref103;
	
	private String tabref111;
	private String tabref112;
	private String tabref113;
	
	private String tabref121;
	private String tabref122;
	private String tabref123;
	
	private String tabref131;
	private String tabref132;
	private String tabref133;
	
	private String tabref141;
	private String tabref142;
	private String tabref143;
	
	private String tabref151;
	private String tabref152;
	private String tabref153;
	
	
	
	
	@OneToMany(mappedBy="tabref")
	public List<Coursout> coursouts;




	public int getTbrId() {
		return tbrId;
	}




	public void setTbrId(int tbrId) {
		this.tbrId = tbrId;
	}




	public String getTabref11() {
		return tabref11;
	}




	public void setTabref11(String tabref11) {
		this.tabref11 = tabref11;
	}




	public String getTabref12() {
		return tabref12;
	}




	public void setTabref12(String tabref12) {
		this.tabref12 = tabref12;
	}




	public String getTabref13() {
		return tabref13;
	}




	public void setTabref13(String tabref13) {
		this.tabref13 = tabref13;
	}




	public String getTabref21() {
		return tabref21;
	}




	public void setTabref21(String tabref21) {
		this.tabref21 = tabref21;
	}




	public String getTabref22() {
		return tabref22;
	}




	public void setTabref22(String tabref22) {
		this.tabref22 = tabref22;
	}




	public String getTabref23() {
		return tabref23;
	}




	public void setTabref23(String tabref23) {
		this.tabref23 = tabref23;
	}




	public String getTabref31() {
		return tabref31;
	}




	public void setTabref31(String tabref31) {
		this.tabref31 = tabref31;
	}




	public String getTabref32() {
		return tabref32;
	}




	public void setTabref32(String tabref32) {
		this.tabref32 = tabref32;
	}




	public String getTabref33() {
		return tabref33;
	}




	public void setTabref33(String tabref33) {
		this.tabref33 = tabref33;
	}




	public String getTabref41() {
		return tabref41;
	}




	public void setTabref41(String tabref41) {
		this.tabref41 = tabref41;
	}




	public String getTabref42() {
		return tabref42;
	}




	public void setTabref42(String tabref42) {
		this.tabref42 = tabref42;
	}




	public String getTabref43() {
		return tabref43;
	}




	public void setTabref43(String tabref43) {
		this.tabref43 = tabref43;
	}




	public String getTabref51() {
		return tabref51;
	}




	public void setTabref51(String tabref51) {
		this.tabref51 = tabref51;
	}




	public String getTabref52() {
		return tabref52;
	}




	public void setTabref52(String tabref52) {
		this.tabref52 = tabref52;
	}




	public String getTabref53() {
		return tabref53;
	}




	public void setTabref53(String tabref53) {
		this.tabref53 = tabref53;
	}




	public String getTabref61() {
		return tabref61;
	}




	public void setTabref61(String tabref61) {
		this.tabref61 = tabref61;
	}




	public String getTabref62() {
		return tabref62;
	}




	public void setTabref62(String tabref62) {
		this.tabref62 = tabref62;
	}




	public String getTabref63() {
		return tabref63;
	}




	public void setTabref63(String tabref63) {
		this.tabref63 = tabref63;
	}




	public String getTabref71() {
		return tabref71;
	}




	public void setTabref71(String tabref71) {
		this.tabref71 = tabref71;
	}




	public String getTabref72() {
		return tabref72;
	}




	public void setTabref72(String tabref72) {
		this.tabref72 = tabref72;
	}




	public String getTabref73() {
		return tabref73;
	}




	public void setTabref73(String tabref73) {
		this.tabref73 = tabref73;
	}




	public String getTabref91() {
		return tabref91;
	}




	public void setTabref91(String tabref91) {
		this.tabref91 = tabref91;
	}




	public String getTabref92() {
		return tabref92;
	}




	public void setTabref92(String tabref92) {
		this.tabref92 = tabref92;
	}




	public String getTabref93() {
		return tabref93;
	}




	public void setTabref93(String tabref93) {
		this.tabref93 = tabref93;
	}




	public String getTabref101() {
		return tabref101;
	}




	public void setTabref101(String tabref101) {
		this.tabref101 = tabref101;
	}




	public String getTabref102() {
		return tabref102;
	}




	public void setTabref102(String tabref102) {
		this.tabref102 = tabref102;
	}




	public String getTabref103() {
		return tabref103;
	}




	public void setTabref103(String tabref103) {
		this.tabref103 = tabref103;
	}




	public String getTabref111() {
		return tabref111;
	}




	public void setTabref111(String tabref111) {
		this.tabref111 = tabref111;
	}




	public String getTabref112() {
		return tabref112;
	}




	public void setTabref112(String tabref112) {
		this.tabref112 = tabref112;
	}




	public String getTabref113() {
		return tabref113;
	}




	public void setTabref113(String tabref113) {
		this.tabref113 = tabref113;
	}




	public String getTabref121() {
		return tabref121;
	}




	public void setTabref121(String tabref121) {
		this.tabref121 = tabref121;
	}




	public String getTabref122() {
		return tabref122;
	}




	public void setTabref122(String tabref122) {
		this.tabref122 = tabref122;
	}




	public String getTabref123() {
		return tabref123;
	}




	public void setTabref123(String tabref123) {
		this.tabref123 = tabref123;
	}




	public String getTabref131() {
		return tabref131;
	}




	public void setTabref131(String tabref131) {
		this.tabref131 = tabref131;
	}




	public String getTabref132() {
		return tabref132;
	}




	public void setTabref132(String tabref132) {
		this.tabref132 = tabref132;
	}




	public String getTabref133() {
		return tabref133;
	}




	public void setTabref133(String tabref133) {
		this.tabref133 = tabref133;
	}




	public String getTabref141() {
		return tabref141;
	}




	public void setTabref141(String tabref141) {
		this.tabref141 = tabref141;
	}




	public String getTabref142() {
		return tabref142;
	}




	public void setTabref142(String tabref142) {
		this.tabref142 = tabref142;
	}




	public String getTabref143() {
		return tabref143;
	}




	public void setTabref143(String tabref143) {
		this.tabref143 = tabref143;
	}




	public String getTabref151() {
		return tabref151;
	}




	public void setTabref151(String tabref151) {
		this.tabref151 = tabref151;
	}




	public String getTabref152() {
		return tabref152;
	}




	public void setTabref152(String tabref152) {
		this.tabref152 = tabref152;
	}




	public String getTabref153() {
		return tabref153;
	}




	public void setTabref153(String tabref153) {
		this.tabref153 = tabref153;
	}




	public List<Coursout> getCoursouts() {
		return coursouts;
	}




	public void setCoursouts(List<Coursout> coursouts) {
		this.coursouts = coursouts;
	}


	
	
	
}
