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
@Table(name = "EVALUATIONSUPER")
@JsonIdentityInfo(generator = ObjectIdGenerators.PropertyGenerator.class, property = "id")
public class Evaluationsuper {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	
	public int scc1;
	public int scc2;
	public int scc3;
	public int scc4;
	public int scc5;
	public int scc6;
	public int scc7;
	public int scc8;
	public int scc9;
	public int scc10;
		
	public int spc1;
	public int spc2;
	public int spc3;
	public int spc4;
	
	public int stm1;
	public int stm2;
	public int stm3;
	
	public int sec1;
	public int sec2;
	public int sec3;
	
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
	
	
	
	
	
	

	
	
	//geter seter
	
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getScc1() {
		return scc1;
	}

	public void setScc1(int scc1) {
		this.scc1 = scc1;
	}

	public int getScc2() {
		return scc2;
	}

	public void setScc2(int scc2) {
		this.scc2 = scc2;
	}

	public int getScc3() {
		return scc3;
	}

	public void setScc3(int scc3) {
		this.scc3 = scc3;
	}

	public int getScc4() {
		return scc4;
	}

	public void setScc4(int scc4) {
		this.scc4 = scc4;
	}

	public int getScc5() {
		return scc5;
	}

	public void setScc5(int scc5) {
		this.scc5 = scc5;
	}

	public int getScc6() {
		return scc6;
	}

	public void setScc6(int scc6) {
		this.scc6 = scc6;
	}

	public int getScc7() {
		return scc7;
	}

	public void setScc7(int scc7) {
		this.scc7 = scc7;
	}

	public int getScc8() {
		return scc8;
	}

	public void setScc8(int scc8) {
		this.scc8 = scc8;
	}

	public int getScc9() {
		return scc9;
	}

	public void setScc9(int scc9) {
		this.scc9 = scc9;
	}

	public int getScc10() {
		return scc10;
	}

	public void setScc10(int scc10) {
		this.scc10 = scc10;
	}

	public int getSpc1() {
		return spc1;
	}

	public void setSpc1(int spc1) {
		this.spc1 = spc1;
	}

	public int getSpc2() {
		return spc2;
	}

	public void setSpc2(int spc2) {
		this.spc2 = spc2;
	}

	public int getSpc3() {
		return spc3;
	}

	public void setSpc3(int spc3) {
		this.spc3 = spc3;
	}

	public int getSpc4() {
		return spc4;
	}

	public void setSpc4(int spc4) {
		this.spc4 = spc4;
	}

	public int getStm1() {
		return stm1;
	}

	public void setStm1(int stm1) {
		this.stm1 = stm1;
	}

	public int getStm2() {
		return stm2;
	}

	public void setStm2(int stm2) {
		this.stm2 = stm2;
	}

	public int getStm3() {
		return stm3;
	}

	public void setStm3(int stm3) {
		this.stm3 = stm3;
	}

	public int getSec1() {
		return sec1;
	}

	public void setSec1(int sec1) {
		this.sec1 = sec1;
	}

	public int getSec2() {
		return sec2;
	}

	public void setSec2(int sec2) {
		this.sec2 = sec2;
	}

	public int getSec3() {
		return sec3;
	}

	public void setSec3(int sec3) {
		this.sec3 = sec3;
	}

	
	public float getTotal() {
		return total;
	}

	public void setTotal(float total) {
		this.total = total;
	}

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

	
	
	// total
	public float getTotald() {
		return (total);
	}
	
	public float getAvtotald() {
		return (float) ((0.35)* (getTotald()));
	}
	
	
	
}
