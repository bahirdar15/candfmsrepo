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
@Table(name = "PROFORMREQU")
@JsonIdentityInfo(generator = ObjectIdGenerators.PropertyGenerator.class, property = "id")
public class ProformRequ {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	public int id;
	public int ayear;
	public String requestdate;
	public String approveddate;	
	public String status;	
	public int approvedby;
	
	public int countstu;
	public int countinsta;
	public int countchair;
	public int sumofcount;
	
	/*
	 * @ManyToOne
	 * 
	 * @JoinColumn(name="coursoutid", insertable=false, updatable=false) public
	 * Coursout coursout; public Integer coursoutid;
	 */
	
	@ManyToOne
	@JoinColumn(name="userid", insertable=false, updatable=false)
	public User user;	
	public Integer userid;
	
	@ManyToOne
	@JoinColumn(name="fmieid", insertable=false, updatable=false)
	public Fmie fmie;	
	public Integer fmieid;	
	
	@ManyToOne
	@JoinColumn(name="semesterid", insertable=false, updatable=false)
	public Semester semester;	
	public Integer semesterid;
	
	@OneToMany(mappedBy="proformRequ")
	public List<EvaluationCo> evaluationCos;

	
	
	
	
	
	
	
	
	
	

	public int getSumofcount() {
		return sumofcount;
	}



	public void setSumofcount(int sumofcount) {
		this.sumofcount = sumofcount;
	}



	public ProformRequ() {
		super();
		// TODO Auto-generated constructor stub
	}

	

	public int getCountstu() {
		return countstu;
	}



	public void setCountstu(int countstu) {
		this.countstu = countstu;
	}



	public int getCountinsta() {
		return countinsta;
	}



	public void setCountinsta(int countinsta) {
		this.countinsta = countinsta;
	}



	public int getCountchair() {
		return countchair;
	}



	public void setCountchair(int countchair) {
		this.countchair = countchair;
	}



	public int getAyear() {
		return ayear;
	}



	public void setAyear(int ayear) {
		this.ayear = ayear;
	}



	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	

	public String getRequestdate() {
		return requestdate;
	}

	public void setRequestdate(String requestdate) {
		this.requestdate = requestdate;
	}

	public String getApproveddate() {
		return approveddate;
	}

	public void setApproveddate(String approveddate) {
		this.approveddate = approveddate;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public int getApprovedby() {
		return approvedby;
	}

	public void setApprovedby(int approvedby) {
		this.approvedby = approvedby;
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

	public Fmie getFmie() {
		return fmie;
	}

	public void setFmie(Fmie fmie) {
		this.fmie = fmie;
	}

	public Integer getFmieid() {
		return fmieid;
	}

	public void setFmieid(Integer fmieid) {
		this.fmieid = fmieid;
	}

	public Semester getSemester() {
		return semester;
	}

	public void setSemester(Semester semester) {
		this.semester = semester;
	}

	public Integer getSemesterid() {
		return semesterid;
	}

	public void setSemesterid(Integer semesterid) {
		this.semesterid = semesterid;
	}

	public List<EvaluationCo> getEvaluationCos() {
		return evaluationCos;
	}

	public void setEvaluationCos(List<EvaluationCo> evaluationCos) {
		evaluationCos = evaluationCos;
	}
	
	

}
