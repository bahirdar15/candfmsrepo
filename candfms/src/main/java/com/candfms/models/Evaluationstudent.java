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
@Table(name = "EVALUATIONSTUDENT")
@JsonIdentityInfo(generator = ObjectIdGenerators.PropertyGenerator.class, property = "id")
public class Evaluationstudent {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	
	public int tcc1;
	public int tcc2;
	public int tcc3;
	public int tcc4;
	public int tcc5;
	public int tcc6;
	
	public int tpc1;
	public int tpc2;
	public int tpc3;
	public int tpc4;
	public int tpc5;
	public int tpc6;
	public int tpc7;
	public int tpc8;
	
	public int tec1;
	public int tec2;
	public int tec3;
	public int tec4;
		
	public int ttm1;
	public int ttm2;
	
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

	public int getTcc1() {
		return tcc1;
	}

	public void setTcc1(int tcc1) {
		this.tcc1 = tcc1;
	}

	public int getTcc2() {
		return tcc2;
	}

	public void setTcc2(int tcc2) {
		this.tcc2 = tcc2;
	}

	public int getTcc3() {
		return tcc3;
	}

	public void setTcc3(int tcc3) {
		this.tcc3 = tcc3;
	}

	public int getTcc4() {
		return tcc4;
	}

	public void setTcc4(int tcc4) {
		this.tcc4 = tcc4;
	}

	public int getTcc5() {
		return tcc5;
	}

	public void setTcc5(int tcc5) {
		this.tcc5 = tcc5;
	}

	public int getTcc6() {
		return tcc6;
	}

	public void setTcc6(int tcc6) {
		this.tcc6 = tcc6;
	}

	public int getTpc1() {
		return tpc1;
	}

	public void setTpc1(int tpc1) {
		this.tpc1 = tpc1;
	}

	public int getTpc2() {
		return tpc2;
	}

	public void setTpc2(int tpc2) {
		this.tpc2 = tpc2;
	}

	public int getTpc3() {
		return tpc3;
	}

	public void setTpc3(int tpc3) {
		this.tpc3 = tpc3;
	}

	public int getTpc4() {
		return tpc4;
	}

	public void setTpc4(int tpc4) {
		this.tpc4 = tpc4;
	}

	public int getTpc5() {
		return tpc5;
	}

	public void setTpc5(int tpc5) {
		this.tpc5 = tpc5;
	}

	public int getTpc6() {
		return tpc6;
	}

	public void setTpc6(int tpc6) {
		this.tpc6 = tpc6;
	}

	public int getTpc7() {
		return tpc7;
	}

	public void setTpc7(int tpc7) {
		this.tpc7 = tpc7;
	}

	public int getTpc8() {
		return tpc8;
	}

	public void setTpc8(int tpc8) {
		this.tpc8 = tpc8;
	}

	public int getTec1() {
		return tec1;
	}

	public void setTec1(int tec1) {
		this.tec1 = tec1;
	}

	public int getTec2() {
		return tec2;
	}

	public void setTec2(int tec2) {
		this.tec2 = tec2;
	}

	public int getTec3() {
		return tec3;
	}

	public void setTec3(int tec3) {
		this.tec3 = tec3;
	}

	public int getTec4() {
		return tec4;
	}

	public void setTec4(int tec4) {
		this.tec4 = tec4;
	}

	public int getTtm1() {
		return ttm1;
	}

	public void setTtm1(int ttm1) {
		this.ttm1 = ttm1;
	}

	public int getTtm2() {
		return ttm2;
	}

	public void setTtm2(int ttm2) {
		this.ttm2 = ttm2;
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

	
	
	//total
	//return (tcc1+tcc2+tcc3+tcc4+tcc5+tcc6)+(tpc1+tpc2+tpc3+tpc4+tpc5+tpc6+tpc7+tpc8)+(tec1+tec2+tec3+tec4)+(ttm1+ttm2);
	
	public float getTotald() {
		return (total);
	}
	
	public float getAvtotald() {
		return (float) ((0.5)* (getTotald()));
	}
	
	
	
}
