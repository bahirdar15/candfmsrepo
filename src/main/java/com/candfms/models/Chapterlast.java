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
@Table(name = "CHAPTERLAST")
@JsonIdentityInfo(generator = ObjectIdGenerators.PropertyGenerator.class, property = "id")
public class Chapterlast {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	public int lId;	
	
	//last bf mid
	public String chapter6;
	public String chapter61;
	public String chapter62;
	public String chapter63;
	public String chapter64;
	public String chapter65;
	public String chapter66;
	public String chapter67;
	public String chapter68;
	public String chapter69;
	public String chapter610;
		
	public String chapter7;
	public String chapter71;
	public String chapter72;
	public String chapter73;
	public String chapter74;
	public String chapter75;
	public String chapter76;
	public String chapter77;
	public String chapter78;
	public String chapter79;
	public String chapter710;

	//last af mid
	
	public String chapter13;
	public String chapter131;
	public String chapter132;
	public String chapter133;
	public String chapter134;
	public String chapter135;
	public String chapter136;
	public String chapter137;
	public String chapter138;
	public String chapter139;
	public String chapter1310;
		
	public String chapter14;
	public String chapter141;
	public String chapter142;
	public String chapter143;
	public String chapter144;
	public String chapter145;
	public String chapter146;
	public String chapter147;
	public String chapter148;
	public String chapter149;
	public String chapter1410;
	

	@OneToMany(mappedBy="chapterlast")
	public List<Coursout> coursouts;


	public int getlId() {
		return lId;
	}


	public void setlId(int lId) {
		this.lId = lId;
	}


	public String getChapter6() {
		return chapter6;
	}


	public void setChapter6(String chapter6) {
		this.chapter6 = chapter6;
	}


	public String getChapter61() {
		return chapter61;
	}


	public void setChapter61(String chapter61) {
		this.chapter61 = chapter61;
	}


	public String getChapter62() {
		return chapter62;
	}


	public void setChapter62(String chapter62) {
		this.chapter62 = chapter62;
	}


	public String getChapter63() {
		return chapter63;
	}


	public void setChapter63(String chapter63) {
		this.chapter63 = chapter63;
	}


	public String getChapter64() {
		return chapter64;
	}


	public void setChapter64(String chapter64) {
		this.chapter64 = chapter64;
	}


	public String getChapter65() {
		return chapter65;
	}


	public void setChapter65(String chapter65) {
		this.chapter65 = chapter65;
	}


	public String getChapter66() {
		return chapter66;
	}


	public void setChapter66(String chapter66) {
		this.chapter66 = chapter66;
	}


	public String getChapter67() {
		return chapter67;
	}


	public void setChapter67(String chapter67) {
		this.chapter67 = chapter67;
	}


	public String getChapter68() {
		return chapter68;
	}


	public void setChapter68(String chapter68) {
		this.chapter68 = chapter68;
	}


	public String getChapter69() {
		return chapter69;
	}


	public void setChapter69(String chapter69) {
		this.chapter69 = chapter69;
	}


	public String getChapter610() {
		return chapter610;
	}


	public void setChapter610(String chapter610) {
		this.chapter610 = chapter610;
	}


	public String getChapter7() {
		return chapter7;
	}


	public void setChapter7(String chapter7) {
		this.chapter7 = chapter7;
	}


	public String getChapter71() {
		return chapter71;
	}


	public void setChapter71(String chapter71) {
		this.chapter71 = chapter71;
	}


	public String getChapter72() {
		return chapter72;
	}


	public void setChapter72(String chapter72) {
		this.chapter72 = chapter72;
	}


	public String getChapter73() {
		return chapter73;
	}


	public void setChapter73(String chapter73) {
		this.chapter73 = chapter73;
	}


	public String getChapter74() {
		return chapter74;
	}


	public void setChapter74(String chapter74) {
		this.chapter74 = chapter74;
	}


	public String getChapter75() {
		return chapter75;
	}


	public void setChapter75(String chapter75) {
		this.chapter75 = chapter75;
	}


	public String getChapter76() {
		return chapter76;
	}


	public void setChapter76(String chapter76) {
		this.chapter76 = chapter76;
	}


	public String getChapter77() {
		return chapter77;
	}


	public void setChapter77(String chapter77) {
		this.chapter77 = chapter77;
	}


	public String getChapter78() {
		return chapter78;
	}


	public void setChapter78(String chapter78) {
		this.chapter78 = chapter78;
	}


	public String getChapter79() {
		return chapter79;
	}


	public void setChapter79(String chapter79) {
		this.chapter79 = chapter79;
	}


	public String getChapter710() {
		return chapter710;
	}


	public void setChapter710(String chapter710) {
		this.chapter710 = chapter710;
	}


	public String getChapter13() {
		return chapter13;
	}


	public void setChapter13(String chapter13) {
		this.chapter13 = chapter13;
	}


	public String getChapter131() {
		return chapter131;
	}


	public void setChapter131(String chapter131) {
		this.chapter131 = chapter131;
	}


	public String getChapter132() {
		return chapter132;
	}


	public void setChapter132(String chapter132) {
		this.chapter132 = chapter132;
	}


	public String getChapter133() {
		return chapter133;
	}


	public void setChapter133(String chapter133) {
		this.chapter133 = chapter133;
	}


	public String getChapter134() {
		return chapter134;
	}


	public void setChapter134(String chapter134) {
		this.chapter134 = chapter134;
	}


	public String getChapter135() {
		return chapter135;
	}


	public void setChapter135(String chapter135) {
		this.chapter135 = chapter135;
	}


	public String getChapter136() {
		return chapter136;
	}


	public void setChapter136(String chapter136) {
		this.chapter136 = chapter136;
	}


	public String getChapter137() {
		return chapter137;
	}


	public void setChapter137(String chapter137) {
		this.chapter137 = chapter137;
	}


	public String getChapter138() {
		return chapter138;
	}


	public void setChapter138(String chapter138) {
		this.chapter138 = chapter138;
	}


	public String getChapter139() {
		return chapter139;
	}


	public void setChapter139(String chapter139) {
		this.chapter139 = chapter139;
	}


	public String getChapter1310() {
		return chapter1310;
	}


	public void setChapter1310(String chapter1310) {
		this.chapter1310 = chapter1310;
	}


	public String getChapter14() {
		return chapter14;
	}


	public void setChapter14(String chapter14) {
		this.chapter14 = chapter14;
	}


	public String getChapter141() {
		return chapter141;
	}


	public void setChapter141(String chapter141) {
		this.chapter141 = chapter141;
	}


	public String getChapter142() {
		return chapter142;
	}


	public void setChapter142(String chapter142) {
		this.chapter142 = chapter142;
	}


	public String getChapter143() {
		return chapter143;
	}


	public void setChapter143(String chapter143) {
		this.chapter143 = chapter143;
	}


	public String getChapter144() {
		return chapter144;
	}


	public void setChapter144(String chapter144) {
		this.chapter144 = chapter144;
	}


	public String getChapter145() {
		return chapter145;
	}


	public void setChapter145(String chapter145) {
		this.chapter145 = chapter145;
	}


	public String getChapter146() {
		return chapter146;
	}


	public void setChapter146(String chapter146) {
		this.chapter146 = chapter146;
	}


	public String getChapter147() {
		return chapter147;
	}


	public void setChapter147(String chapter147) {
		this.chapter147 = chapter147;
	}


	public String getChapter148() {
		return chapter148;
	}


	public void setChapter148(String chapter148) {
		this.chapter148 = chapter148;
	}


	public String getChapter149() {
		return chapter149;
	}


	public void setChapter149(String chapter149) {
		this.chapter149 = chapter149;
	}


	public String getChapter1410() {
		return chapter1410;
	}


	public void setChapter1410(String chapter1410) {
		this.chapter1410 = chapter1410;
	}


	public List<Coursout> getCoursouts() {
		return coursouts;
	}


	public void setCoursouts(List<Coursout> coursouts) {
		this.coursouts = coursouts;
	}


	


	
	
	
}
