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
@Table(name = "CHAPTERAF")
@JsonIdentityInfo(generator = ObjectIdGenerators.PropertyGenerator.class, property = "id")
public class Chapteraf {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	public int afId;		
	
	public String chapter8;
	public String chapter81;

	
	public String chapter82;
	public String chapter83;
	public String chapter84;
	public String chapter85;
	public String chapter86;
	public String chapter87;
	public String chapter88;
	public String chapter89;
	public String chapter810;
	
	
	public String chapter9;
	public String chapter91;
	public String chapter92;
	public String chapter93;
	public String chapter94;
	public String chapter95;
	public String chapter96;
	public String chapter97;
	public String chapter98;
	public String chapter99;
	public String chapter910;
	
	public String chapter10;
	public String chapter101;
	public String chapter102;
	public String chapter103;
	public String chapter104;
	public String chapter105;
	public String chapter106;
	public String chapter107;
	public String chapter108;
	public String chapter109;
	public String chapter1010;
		
	public String chapter11;
	public String chapter111;
	public String chapter112;
	public String chapter113;
	public String chapter114;
	public String chapter115;
	public String chapter116;
	public String chapter117;
	public String chapter118;
	public String chapter119;
	public String chapter1110;
		
	public String chapter12;
	public String chapter121;
	public String chapter122;
	public String chapter123;
	public String chapter124;
	public String chapter125;
	public String chapter126;
	public String chapter127;
	public String chapter128;
	public String chapter129;
	public String chapter1210;
	
	
	
	public String getChapter102() {
		return chapter102;
	}

	public void setChapter102(String chapter102) {
		this.chapter102 = chapter102;
	}

	public String getChapter103() {
		return chapter103;
	}

	public void setChapter103(String chapter103) {
		this.chapter103 = chapter103;
	}

	public String getChapter104() {
		return chapter104;
	}

	public void setChapter104(String chapter104) {
		this.chapter104 = chapter104;
	}

	public String getChapter105() {
		return chapter105;
	}

	public void setChapter105(String chapter105) {
		this.chapter105 = chapter105;
	}

	public String getChapter106() {
		return chapter106;
	}

	public void setChapter106(String chapter106) {
		this.chapter106 = chapter106;
	}

	public String getChapter107() {
		return chapter107;
	}

	public void setChapter107(String chapter107) {
		this.chapter107 = chapter107;
	}

	public String getChapter108() {
		return chapter108;
	}

	public void setChapter108(String chapter108) {
		this.chapter108 = chapter108;
	}

	public String getChapter109() {
		return chapter109;
	}

	public void setChapter109(String chapter109) {
		this.chapter109 = chapter109;
	}

	public String getChapter1010() {
		return chapter1010;
	}

	public void setChapter1010(String chapter1010) {
		this.chapter1010 = chapter1010;
	}

	public String getChapter11() {
		return chapter11;
	}

	public void setChapter11(String chapter11) {
		this.chapter11 = chapter11;
	}

	public String getChapter111() {
		return chapter111;
	}

	public void setChapter111(String chapter111) {
		this.chapter111 = chapter111;
	}

	public String getChapter112() {
		return chapter112;
	}

	public void setChapter112(String chapter112) {
		this.chapter112 = chapter112;
	}

	public String getChapter113() {
		return chapter113;
	}

	public void setChapter113(String chapter113) {
		this.chapter113 = chapter113;
	}

	public String getChapter114() {
		return chapter114;
	}

	public void setChapter114(String chapter114) {
		this.chapter114 = chapter114;
	}

	public String getChapter115() {
		return chapter115;
	}

	public void setChapter115(String chapter115) {
		this.chapter115 = chapter115;
	}

	public String getChapter116() {
		return chapter116;
	}

	public void setChapter116(String chapter116) {
		this.chapter116 = chapter116;
	}

	public String getChapter117() {
		return chapter117;
	}

	public void setChapter117(String chapter117) {
		this.chapter117 = chapter117;
	}

	public String getChapter118() {
		return chapter118;
	}

	public void setChapter118(String chapter118) {
		this.chapter118 = chapter118;
	}

	public String getChapter119() {
		return chapter119;
	}

	public void setChapter119(String chapter119) {
		this.chapter119 = chapter119;
	}

	public String getChapter1110() {
		return chapter1110;
	}

	public void setChapter1110(String chapter1110) {
		this.chapter1110 = chapter1110;
	}

	public String getChapter12() {
		return chapter12;
	}

	public void setChapter12(String chapter12) {
		this.chapter12 = chapter12;
	}

	public String getChapter121() {
		return chapter121;
	}

	public void setChapter121(String chapter121) {
		this.chapter121 = chapter121;
	}

	public String getChapter122() {
		return chapter122;
	}

	public void setChapter122(String chapter122) {
		this.chapter122 = chapter122;
	}

	public String getChapter123() {
		return chapter123;
	}

	public void setChapter123(String chapter123) {
		this.chapter123 = chapter123;
	}

	public String getChapter124() {
		return chapter124;
	}

	public void setChapter124(String chapter124) {
		this.chapter124 = chapter124;
	}

	public String getChapter125() {
		return chapter125;
	}

	public void setChapter125(String chapter125) {
		this.chapter125 = chapter125;
	}

	public String getChapter126() {
		return chapter126;
	}

	public void setChapter126(String chapter126) {
		this.chapter126 = chapter126;
	}

	public String getChapter127() {
		return chapter127;
	}

	public void setChapter127(String chapter127) {
		this.chapter127 = chapter127;
	}

	public String getChapter128() {
		return chapter128;
	}

	public void setChapter128(String chapter128) {
		this.chapter128 = chapter128;
	}

	public String getChapter129() {
		return chapter129;
	}

	public void setChapter129(String chapter129) {
		this.chapter129 = chapter129;
	}

	public String getChapter1210() {
		return chapter1210;
	}

	public void setChapter1210(String chapter1210) {
		this.chapter1210 = chapter1210;
	}

	public String getChapter10() {
		return chapter10;
	}

	public void setChapter10(String chapter10) {
		this.chapter10 = chapter10;
	}

	public String getChapter101() {
		return chapter101;
	}

	public void setChapter101(String chapter101) {
		this.chapter101 = chapter101;
	}

	public int getAfId() {
		return afId;
	}

	public void setAfId(int afId) {
		this.afId = afId;
	}

	public String getChapter8() {
		return chapter8;
	}

	public void setChapter8(String chapter8) {
		this.chapter8 = chapter8;
	}

	public String getChapter81() {
		return chapter81;
	}

	public void setChapter81(String chapter81) {
		this.chapter81 = chapter81;
	}

	public String getChapter82() {
		return chapter82;
	}

	public void setChapter82(String chapter82) {
		this.chapter82 = chapter82;
	}

	public String getChapter83() {
		return chapter83;
	}

	public void setChapter83(String chapter83) {
		this.chapter83 = chapter83;
	}

	public String getChapter84() {
		return chapter84;
	}

	public void setChapter84(String chapter84) {
		this.chapter84 = chapter84;
	}

	public String getChapter85() {
		return chapter85;
	}

	public void setChapter85(String chapter85) {
		this.chapter85 = chapter85;
	}

	public String getChapter86() {
		return chapter86;
	}

	public void setChapter86(String chapter86) {
		this.chapter86 = chapter86;
	}

	public String getChapter87() {
		return chapter87;
	}

	public void setChapter87(String chapter87) {
		this.chapter87 = chapter87;
	}

	public String getChapter88() {
		return chapter88;
	}

	public void setChapter88(String chapter88) {
		this.chapter88 = chapter88;
	}

	public String getChapter89() {
		return chapter89;
	}

	public void setChapter89(String chapter89) {
		this.chapter89 = chapter89;
	}

	public String getChapter810() {
		return chapter810;
	}

	public void setChapter810(String chapter810) {
		this.chapter810 = chapter810;
	}

	public String getChapter9() {
		return chapter9;
	}

	public void setChapter9(String chapter9) {
		this.chapter9 = chapter9;
	}

	public String getChapter91() {
		return chapter91;
	}

	public void setChapter91(String chapter91) {
		this.chapter91 = chapter91;
	}

	public String getChapter92() {
		return chapter92;
	}

	public void setChapter92(String chapter92) {
		this.chapter92 = chapter92;
	}

	public String getChapter93() {
		return chapter93;
	}

	public void setChapter93(String chapter93) {
		this.chapter93 = chapter93;
	}

	public String getChapter94() {
		return chapter94;
	}

	public void setChapter94(String chapter94) {
		this.chapter94 = chapter94;
	}

	public String getChapter95() {
		return chapter95;
	}

	public void setChapter95(String chapter95) {
		this.chapter95 = chapter95;
	}

	public String getChapter96() {
		return chapter96;
	}

	public void setChapter96(String chapter96) {
		this.chapter96 = chapter96;
	}

	public String getChapter97() {
		return chapter97;
	}

	public void setChapter97(String chapter97) {
		this.chapter97 = chapter97;
	}

	public String getChapter98() {
		return chapter98;
	}

	public void setChapter98(String chapter98) {
		this.chapter98 = chapter98;
	}

	public String getChapter99() {
		return chapter99;
	}

	public void setChapter99(String chapter99) {
		this.chapter99 = chapter99;
	}

	public String getChapter910() {
		return chapter910;
	}

	public void setChapter910(String chapter910) {
		this.chapter910 = chapter910;
	}

	public List<Coursout> getCoursouts() {
		return coursouts;
	}

	public void setCoursouts(List<Coursout> coursouts) {
		this.coursouts = coursouts;
	}

	@OneToMany(mappedBy="chapteraf")
	public List<Coursout> coursouts;


	


	
	
	
}
