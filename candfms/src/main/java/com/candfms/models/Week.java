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
@Table(name = "WEEK")
@JsonIdentityInfo(generator = ObjectIdGenerators.PropertyGenerator.class, property = "id")
public class Week {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	public int wId;
	
	
	public String weekone;
	public String weektwo;
	public String weekthree;
	public String weekfour;
	public String weekfive;
	public String weeksix;
	public String weekseven;
	public String weeknine;
	public String weekten;
	public String weekeleven;
	public String weektwelve;
	public String weekthirteen;	
	public String weekfourteen;
	public String weekfifteen;

	
	
	
	
	@OneToMany(mappedBy="week")
	public List<Coursout> coursouts;





	public int getwId() {
		return wId;
	}





	public void setwId(int wId) {
		this.wId = wId;
	}





	public String getWeekone() {
		return weekone;
	}





	public void setWeekone(String weekone) {
		this.weekone = weekone;
	}





	public String getWeektwo() {
		return weektwo;
	}





	public void setWeektwo(String weektwo) {
		this.weektwo = weektwo;
	}





	public String getWeekthree() {
		return weekthree;
	}





	public void setWeekthree(String weekthree) {
		this.weekthree = weekthree;
	}





	public String getWeekfour() {
		return weekfour;
	}





	public void setWeekfour(String weekfour) {
		this.weekfour = weekfour;
	}





	public String getWeekfive() {
		return weekfive;
	}





	public void setWeekfive(String weekfive) {
		this.weekfive = weekfive;
	}





	public String getWeeksix() {
		return weeksix;
	}





	public void setWeeksix(String weeksix) {
		this.weeksix = weeksix;
	}





	public String getWeekseven() {
		return weekseven;
	}





	public void setWeekseven(String weekseven) {
		this.weekseven = weekseven;
	}





	public String getWeeknine() {
		return weeknine;
	}





	public void setWeeknine(String weeknine) {
		this.weeknine = weeknine;
	}





	public String getWeekten() {
		return weekten;
	}





	public void setWeekten(String weekten) {
		this.weekten = weekten;
	}





	public String getWeekeleven() {
		return weekeleven;
	}





	public void setWeekeleven(String weekeleven) {
		this.weekeleven = weekeleven;
	}





	public String getWeektwelve() {
		return weektwelve;
	}





	public void setWeektwelve(String weektwelve) {
		this.weektwelve = weektwelve;
	}





	public String getWeekthirteen() {
		return weekthirteen;
	}





	public void setWeekthirteen(String weekthirteen) {
		this.weekthirteen = weekthirteen;
	}





	public String getWeekfourteen() {
		return weekfourteen;
	}





	public void setWeekfourteen(String weekfourteen) {
		this.weekfourteen = weekfourteen;
	}





	public String getWeekfifteen() {
		return weekfifteen;
	}





	public void setWeekfifteen(String weekfifteen) {
		this.weekfifteen = weekfifteen;
	}





	public List<Coursout> getCoursouts() {
		return coursouts;
	}





	public void setCoursouts(List<Coursout> coursouts) {
		this.coursouts = coursouts;
	}
	
	
	
	
	
	
}
