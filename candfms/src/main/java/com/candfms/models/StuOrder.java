package com.candfms.models;

import java.sql.Date;
import java.util.List;

import javax.persistence.CascadeType;
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
@Table(name = "STUORDER")
@JsonIdentityInfo(generator = ObjectIdGenerators.PropertyGenerator.class, property = "id")
public class StuOrder {

	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	public int id;
	public String bam;
	public String ayear;
	public String section;
	public String prog;
	
	public String filleddate;
	public String approveddate;
	public String endorseddate;
	
	
	public String status;
	
	public int approvedby;
	public int endorsedby;
	
	
	@ManyToOne
	@JoinColumn(name="userid", insertable=false, updatable=false)
	public User user;	
	public Integer userid;
	
	@OneToMany(mappedBy="stuOrder")
	public List<StuOrderDetile> StuOrderDetiles;
	
	@ManyToOne
	@JoinColumn(name="semesterid", insertable=false, updatable=false)
	public Semester semester;	
	public Integer semesterid;
	
	@ManyToOne
	@JoinColumn(name="yearid", insertable=false, updatable=false)
	public Year year;	
	public Integer yearid;
	
	
	
	/* geter and seter */
	
	
	public int getId() {
		return id;
	}
	
	

	public List<StuOrderDetile> getStuOrderDetiles() {
		return StuOrderDetiles;
	}

	public void setStuOrderDetiles(List<StuOrderDetile> stuOrderDetiles) {
		StuOrderDetiles = stuOrderDetiles;
	}

	public String getSection() {
		return section;
	}

	public void setSection(String section) {
		this.section = section;
	}

	public String getProg() {
		return prog;
	}

	public void setProg(String prog) {
		this.prog = prog;
	}

	public Year getYear() {
		return year;
	}

	public void setYear(Year year) {
		this.year = year;
	}

	public Integer getYearid() {
		return yearid;
	}

	public void setYearid(Integer yearid) {
		this.yearid = yearid;
	}

	public String getApproveddate() {
		return approveddate;
	}

	public void setApproveddate(String approveddate) {
		this.approveddate = approveddate;
	}

	public String getEndorseddate() {
		return endorseddate;
	}

	public void setEndorseddate(String endorseddate) {
		this.endorseddate = endorseddate;
	}

	public int getApprovedby() {
		return approvedby;
	}

	public int getEndorsedby() {
		return endorsedby;
	}

	public void setApprovedby(int approvedby) {
		this.approvedby = approvedby;
	}

	public void setEndorsedby(int endorsedby) {
		this.endorsedby = endorsedby;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
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

	public String getBam() {
		return bam;
	}

	public void setBam(String bam) {
		this.bam = bam;
	}

	public String getAyear() {
		return ayear;
	}

	public void setAyear(String ayear) {
		this.ayear = ayear;
	}

	public String getFilleddate() {
		return filleddate;
	}

	public void setFilleddate(String filleddate) {
		this.filleddate = filleddate;
	}

	

	
	public void setId(int id) {
		this.id = id;
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
	
	
		
	
	
	
	
	
	
}
