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
@Table(name = "CHAPTERBF")
@JsonIdentityInfo(generator = ObjectIdGenerators.PropertyGenerator.class, property = "id")
public class Chapterbf {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	public int bfId;
		
	public String chapter1;
	public String chapter11b;
	public String chapter12b;
	public String chapter13b;
	public String chapter14b;
	public String chapter15;
	public String chapter16;
	public String chapter17;
	public String chapter18;
	public String chapter19;
	public String chapter110;	
	
	public String chapter2;
	public String chapter21;
	public String chapter22;
	public String chapter23;
	public String chapter24;
	public String chapter25;
	public String chapter26;
	public String chapter27;
	public String chapter28;
	public String chapter29;
	public String chapter210;
		
	public String chapter3;
	public String chapter31;
	public String chapter32;
	public String chapter33;
	public String chapter34;
	public String chapter35;
	public String chapter36;
	public String chapter37;
	public String chapter38;
	public String chapter39;
	public String chapter310;
		
	public String chapter4;
	public String chapter41;
	public String chapter42;
	public String chapter43;
	public String chapter44;
	public String chapter45;
	public String chapter46;
	public String chapter47;
	public String chapter48;
	public String chapter49;
	public String chapter410;	
	
	public String chapter5;
	public String chapter51;
	public String chapter52;
	public String chapter53;
	public String chapter54;
	public String chapter55;
	public String chapter56;
	public String chapter57;
	public String chapter58;
	public String chapter59;
	public String chapter510;
	
	
	@OneToMany(mappedBy="chapterbf")
	public List<Coursout> coursouts;


	


	

	public String getChapter15() {
		return chapter15;
	}


	public void setChapter15(String chapter15) {
		this.chapter15 = chapter15;
	}


	public String getChapter16() {
		return chapter16;
	}


	public void setChapter16(String chapter16) {
		this.chapter16 = chapter16;
	}


	public String getChapter17() {
		return chapter17;
	}


	public void setChapter17(String chapter17) {
		this.chapter17 = chapter17;
	}


	public String getChapter18() {
		return chapter18;
	}


	public void setChapter18(String chapter18) {
		this.chapter18 = chapter18;
	}


	public String getChapter19() {
		return chapter19;
	}


	public void setChapter19(String chapter19) {
		this.chapter19 = chapter19;
	}


	public String getChapter110() {
		return chapter110;
	}


	public void setChapter110(String chapter110) {
		this.chapter110 = chapter110;
	}


	public String getChapter2() {
		return chapter2;
	}


	public void setChapter2(String chapter2) {
		this.chapter2 = chapter2;
	}


	public String getChapter21() {
		return chapter21;
	}


	public void setChapter21(String chapter21) {
		this.chapter21 = chapter21;
	}


	public String getChapter22() {
		return chapter22;
	}


	public void setChapter22(String chapter22) {
		this.chapter22 = chapter22;
	}


	public String getChapter23() {
		return chapter23;
	}


	public void setChapter23(String chapter23) {
		this.chapter23 = chapter23;
	}


	public String getChapter24() {
		return chapter24;
	}


	public void setChapter24(String chapter24) {
		this.chapter24 = chapter24;
	}


	public String getChapter25() {
		return chapter25;
	}


	public void setChapter25(String chapter25) {
		this.chapter25 = chapter25;
	}


	public String getChapter26() {
		return chapter26;
	}


	public void setChapter26(String chapter26) {
		this.chapter26 = chapter26;
	}


	public String getChapter27() {
		return chapter27;
	}


	public void setChapter27(String chapter27) {
		this.chapter27 = chapter27;
	}


	public String getChapter28() {
		return chapter28;
	}


	public void setChapter28(String chapter28) {
		this.chapter28 = chapter28;
	}


	public String getChapter29() {
		return chapter29;
	}


	public void setChapter29(String chapter29) {
		this.chapter29 = chapter29;
	}


	public String getChapter210() {
		return chapter210;
	}


	public void setChapter210(String chapter210) {
		this.chapter210 = chapter210;
	}


	public String getChapter3() {
		return chapter3;
	}


	public void setChapter3(String chapter3) {
		this.chapter3 = chapter3;
	}


	public String getChapter31() {
		return chapter31;
	}


	public void setChapter31(String chapter31) {
		this.chapter31 = chapter31;
	}


	public String getChapter32() {
		return chapter32;
	}


	public void setChapter32(String chapter32) {
		this.chapter32 = chapter32;
	}


	public String getChapter33() {
		return chapter33;
	}


	public void setChapter33(String chapter33) {
		this.chapter33 = chapter33;
	}


	public String getChapter34() {
		return chapter34;
	}


	public void setChapter34(String chapter34) {
		this.chapter34 = chapter34;
	}


	public String getChapter35() {
		return chapter35;
	}


	public void setChapter35(String chapter35) {
		this.chapter35 = chapter35;
	}


	public String getChapter36() {
		return chapter36;
	}


	public void setChapter36(String chapter36) {
		this.chapter36 = chapter36;
	}


	public String getChapter37() {
		return chapter37;
	}


	public void setChapter37(String chapter37) {
		this.chapter37 = chapter37;
	}


	public String getChapter38() {
		return chapter38;
	}


	public void setChapter38(String chapter38) {
		this.chapter38 = chapter38;
	}


	public String getChapter39() {
		return chapter39;
	}


	public void setChapter39(String chapter39) {
		this.chapter39 = chapter39;
	}


	public String getChapter310() {
		return chapter310;
	}


	public void setChapter310(String chapter310) {
		this.chapter310 = chapter310;
	}


	public String getChapter4() {
		return chapter4;
	}


	public void setChapter4(String chapter4) {
		this.chapter4 = chapter4;
	}


	public String getChapter41() {
		return chapter41;
	}


	public void setChapter41(String chapter41) {
		this.chapter41 = chapter41;
	}


	public String getChapter42() {
		return chapter42;
	}


	public void setChapter42(String chapter42) {
		this.chapter42 = chapter42;
	}


	public String getChapter43() {
		return chapter43;
	}


	public void setChapter43(String chapter43) {
		this.chapter43 = chapter43;
	}


	public String getChapter44() {
		return chapter44;
	}


	public void setChapter44(String chapter44) {
		this.chapter44 = chapter44;
	}


	public String getChapter45() {
		return chapter45;
	}


	public void setChapter45(String chapter45) {
		this.chapter45 = chapter45;
	}


	public String getChapter46() {
		return chapter46;
	}


	public void setChapter46(String chapter46) {
		this.chapter46 = chapter46;
	}


	public String getChapter47() {
		return chapter47;
	}


	public void setChapter47(String chapter47) {
		this.chapter47 = chapter47;
	}


	public String getChapter48() {
		return chapter48;
	}


	public void setChapter48(String chapter48) {
		this.chapter48 = chapter48;
	}


	public String getChapter49() {
		return chapter49;
	}


	public void setChapter49(String chapter49) {
		this.chapter49 = chapter49;
	}


	public String getChapter410() {
		return chapter410;
	}


	public void setChapter410(String chapter410) {
		this.chapter410 = chapter410;
	}


	public String getChapter5() {
		return chapter5;
	}


	public void setChapter5(String chapter5) {
		this.chapter5 = chapter5;
	}


	public String getChapter51() {
		return chapter51;
	}


	public void setChapter51(String chapter51) {
		this.chapter51 = chapter51;
	}


	public String getChapter52() {
		return chapter52;
	}


	public void setChapter52(String chapter52) {
		this.chapter52 = chapter52;
	}


	public String getChapter53() {
		return chapter53;
	}


	public void setChapter53(String chapter53) {
		this.chapter53 = chapter53;
	}


	public String getChapter54() {
		return chapter54;
	}


	public void setChapter54(String chapter54) {
		this.chapter54 = chapter54;
	}


	public String getChapter55() {
		return chapter55;
	}


	public void setChapter55(String chapter55) {
		this.chapter55 = chapter55;
	}


	public String getChapter56() {
		return chapter56;
	}


	public void setChapter56(String chapter56) {
		this.chapter56 = chapter56;
	}


	public String getChapter57() {
		return chapter57;
	}


	public void setChapter57(String chapter57) {
		this.chapter57 = chapter57;
	}


	public String getChapter58() {
		return chapter58;
	}


	public void setChapter58(String chapter58) {
		this.chapter58 = chapter58;
	}


	public String getChapter59() {
		return chapter59;
	}


	public void setChapter59(String chapter59) {
		this.chapter59 = chapter59;
	}


	public String getChapter510() {
		return chapter510;
	}


	public void setChapter510(String chapter510) {
		this.chapter510 = chapter510;
	}


	public int getBfId() {
		return bfId;
	}


	public void setBfId(int bfId) {
		this.bfId = bfId;
	}


	public String getChapter1() {
		return chapter1;
	}


	public void setChapter1(String chapter1) {
		this.chapter1 = chapter1;
	}


	


	public String getChapter11b() {
		return chapter11b;
	}


	public void setChapter11b(String chapter11b) {
		this.chapter11b = chapter11b;
	}


	public String getChapter12b() {
		return chapter12b;
	}


	public void setChapter12b(String chapter12b) {
		this.chapter12b = chapter12b;
	}


	public String getChapter13b() {
		return chapter13b;
	}


	public void setChapter13b(String chapter13b) {
		this.chapter13b = chapter13b;
	}


	public String getChapter14b() {
		return chapter14b;
	}


	public void setChapter14b(String chapter14b) {
		this.chapter14b = chapter14b;
	}


	public List<Coursout> getCoursouts() {
		return coursouts;
	}


	public void setCoursouts(List<Coursout> coursouts) {
		this.coursouts = coursouts;
	}

	
	
	
}
