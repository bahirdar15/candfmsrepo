package com.candfms.models;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;

@Entity
@Table(name = "EVALUATIONCO")
@JsonIdentityInfo(generator = ObjectIdGenerators.PropertyGenerator.class, property = "id")
public class EvaluationCo {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	
	public int ccs1;
	public int ccs2;
	public int ccs3;
	public int ccs4;
		
	public int ccr1;
	public int ccr2;
	public int ccr3;
	
	public int cpc1;
	public int cpc2;
	public int cpc3;
	public int cpc4;
	public int cpc5;	

	public int cec1;
	public int cec2;
	public int cec3;
	public int cec4;
	public int cec5;
	public int cec6;
	
	public int ctm1;
	public int ctm2;
	
	public float total;
	public float avtotal;
	
	
	public String evaluatdate;	
	@Column(length = 500)
	public String strengths;
	@Column(length = 500)
	public String improve;
	
	
	@ManyToOne
	@JoinColumn(name="userid", insertable=false, updatable=false)
	public User user;	
	public Integer userid;
		
	@ManyToOne
	@JoinColumn(name="proformRequid", insertable=false, updatable=false)
	public ProformRequ proformRequ;	
	public Integer proformRequid;
	
	
	
	
	
	
	
	public float getAvtotal() {
		return avtotal;
	}
	public void setAvtotal(float avtotal) {
		this.avtotal = avtotal;
	}
	public String getEvaluatdate() {
		return evaluatdate;
	}
	public void setEvaluatdate(String evaluatdate) {
		this.evaluatdate = evaluatdate;
	}
	public User getUser() {
		return user;
	}
	public void setUser(User user) {
		this.user = user;
	}
	public Integer getUserid() {
		return userid;
	}
	public void setUserid(Integer userid) {
		this.userid = userid;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public int getCcs1() {
		return ccs1;
	}
	public void setCcs1(int ccs1) {
		this.ccs1 = ccs1;
	}
	public int getCcs2() {
		return ccs2;
	}
	public void setCcs2(int ccs2) {
		this.ccs2 = ccs2;
	}
	public int getCcs3() {
		return ccs3;
	}
	public void setCcs3(int ccs3) {
		this.ccs3 = ccs3;
	}
	public int getCcs4() {
		return ccs4;
	}
	public void setCcs4(int ccs4) {
		this.ccs4 = ccs4;
	}
	
	public int getCcr1() {
		return ccr1;
	}
	public void setCcr1(int ccr1) {
		this.ccr1 = ccr1;
	}
	public int getCcr2() {
		return ccr2;
	}
	public void setCcr2(int ccr2) {
		this.ccr2 = ccr2;
	}
	public int getCcr3() {
		return ccr3;
	}
	public void setCcr3(int ccr3) {
		this.ccr3 = ccr3;
	}
	public int getCpc1() {
		return cpc1;
	}
	public void setCpc1(int cpc1) {
		this.cpc1 = cpc1;
	}
	public int getCpc2() {
		return cpc2;
	}
	public void setCpc2(int cpc2) {
		this.cpc2 = cpc2;
	}
	public int getCpc3() {
		return cpc3;
	}
	public void setCpc3(int cpc3) {
		this.cpc3 = cpc3;
	}
	public int getCpc4() {
		return cpc4;
	}
	public void setCpc4(int cpc4) {
		this.cpc4 = cpc4;
	}
	public int getCpc5() {
		return cpc5;
	}
	public void setCpc5(int cpc5) {
		this.cpc5 = cpc5;
	}
	public int getCec1() {
		return cec1;
	}
	public void setCec1(int cec1) {
		this.cec1 = cec1;
	}
	public int getCec2() {
		return cec2;
	}
	public void setCec2(int cec2) {
		this.cec2 = cec2;
	}
	public int getCec3() {
		return cec3;
	}
	public void setCec3(int cec3) {
		this.cec3 = cec3;
	}
	public int getCec4() {
		return cec4;
	}
	public void setCec4(int cec4) {
		this.cec4 = cec4;
	}
	public int getCec5() {
		return cec5;
	}
	public void setCec5(int cec5) {
		this.cec5 = cec5;
	}
	public int getCec6() {
		return cec6;
	}
	public void setCec6(int cec6) {
		this.cec6 = cec6;
	}
	public int getCtm1() {
		return ctm1;
	}
	public void setCtm1(int ctm1) {
		this.ctm1 = ctm1;
	}
	public int getCtm2() {
		return ctm2;
	}
	public void setCtm2(int ctm2) {
		this.ctm2 = ctm2;
	}
	
	public float getTotal() {
		return total;
	}
	public void setTotal(float total) {
		this.total = total;
	}
	public String getStrengths() {
		return strengths;
	}
	public void setStrengths(String strengths) {
		this.strengths = strengths;
	}
	public String getImprove() {
		return improve;
	}
	public void setImprove(String improve) {
		this.improve = improve;
	}
	public ProformRequ getProformRequ() {
		return proformRequ;
	}
	public void setProformRequ(ProformRequ proformRequ) {
		this.proformRequ = proformRequ;
	}
	public Integer getProformRequid() {
		return proformRequid;
	}
	public void setProformRequid(Integer proformRequid) {
		this.proformRequid = proformRequid;
	}
	
	
	//total
	
	public float getTotald() {
		return (total);
	}
	
	public float getAvtotald() {
		return (float) ((0.15)* (getTotald()));
	}
	
	
	
}
