package com.candfms.models;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;


@Entity
@Table(name = "COURSOUT")
@JsonIdentityInfo(generator = ObjectIdGenerators.PropertyGenerator.class, property = "id")
public class Coursout {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int cId;
	private String statust;

	private String title;
	//private int chairNameId; // fmie_id
	public String ccode;
	private String cmodule;
	private String cps;

	private String clecture;
	private String ctutrial;
	private String claboratory;
	private String cstudy;

	private String preRequi;
	//private int tgroupId; //groupt_id
	private String aYear;  //year_id
	//private int cSemesterId; //semester_id

	private String courseobjectone;
	private String courseobjecttwo;
	
	private String courseobjectthree;
	private String courseobjectfour;
	private String courseobjectfive;
	private String courseobjectsix;	
	private String courseobjectseven;
	private String courseobjecteight;
	private String courseobjectnine;
	private String courseobjectten;

	@Column(length = 1500)
	private String cdescription;

	private int chapaf;
	private int chapbf;
	
	public int chapbfmidplan;
	public int chapafmidplan;
	public int assbfmidplan;
	public int assafmidplan;

	
	/*
	 * private int assessment1; private int assessment2; private int assessment3;
	 * private int assessment4; private int assessment5; private int assessment6;
	 * private int assessment7; private int assessment8; private int assessment9;
	 */
	 

	@Column(length = 500)
	private String cPolicy;

	private String book1;
	private String book2;
	
	
	
	
	
	@ManyToOne
	@JoinColumn(name="fmieid", insertable=false, updatable=false)
	public Fmie fmie;	
	public Integer fmieid;
	
	
	@ManyToOne
	@JoinColumn(name="yearid", insertable=false, updatable=false)
	public Year year;	
	public Integer yearid;

	
	@ManyToOne
	@JoinColumn(name="semesterid", insertable=false, updatable=false)
	public Semester semester;	
	public Integer semesterid;
		
	@ManyToOne
	@JoinColumn(name="grouptid", insertable=false, updatable=false)
	public Groupt groupt;	
	public Integer grouptid;
				
	@ManyToOne
	@JoinColumn(name="referid", insertable=false, updatable=false)
	public Refer refer;	
	public Integer referid;
			
	@ManyToOne
	@JoinColumn(name="weekid", insertable=false, updatable=false)
	public Week week;	
	public Integer weekid;
			
	@ManyToOne
	@JoinColumn(name="chapterbfid", insertable=false, updatable=false)
	public Chapterbf chapterbf;	
	public Integer chapterbfid;
			
	@ManyToOne
	@JoinColumn(name="chapterafid", insertable=false, updatable=false)
	public Chapteraf chapteraf;	
	public Integer chapterafid;
	
	@ManyToOne
	@JoinColumn(name="chapterlastid", insertable=false, updatable=false)
	public Chapterlast chapterlast;	
	public Integer chapterlastid;
	
	@ManyToOne
	@JoinColumn(name="assessid", insertable=false, updatable=false)
	public Assess assess;	
	public Integer assessid;
	
	/* new */
	@ManyToOne
	@JoinColumn(name="comlearnid", insertable=false, updatable=false)
	public ComLearn comlearn;	
	public Integer comlearnid;
	
	@ManyToOne
	@JoinColumn(name="methodoid", insertable=false, updatable=false)
	public Methodo methodo;	
	public Integer methodoid;
	
	@ManyToOne
	@JoinColumn(name="actilabid", insertable=false, updatable=false)
	public ActiLab actilab;	
	public Integer actilabid;
	
	@ManyToOne
	@JoinColumn(name="tabrefid", insertable=false, updatable=false)
	public TabRef tabref;	
	public Integer tabrefid;
	
	@ManyToOne
	@JoinColumn(name="asweekid", insertable=false, updatable=false)
	public AssWeek asweek;	
	public Integer asweekid;
	
	
	
	 
	 
	/*
	 * @OneToMany(mappedBy="coursout") public List<UserCoursout> userCoursouts;
	 */
		/*
		 * @OneToMany(mappedBy="coursout") public List<UserCoursoutAssign>
		 * userCoursoutAssigns;
		 */
	 @OneToMany(mappedBy="coursout") 
	 public List<UserCoursoutCart> userCoursoutCarts;
	 
	 @OneToMany(mappedBy="coursout") 
	 public List<UserCoursoutDetile> userCoursoutDetiles;
	 
	 
		/*
		 * @OneToMany(mappedBy="coursout") public List<ProformRequ> ProformRequs;
		 */
	 
	 @OneToMany(mappedBy="coursout") 
	 public List<InstaCart> instaCarts;
	 
	 @OneToMany(mappedBy="coursout") 
	 public List<StuCart> stuCarts;
	 
	
	 
	 @OneToMany(mappedBy="coursout") 
	 public List<InstaOrderDetile> instaOrderDetiles;
	 
	 @OneToMany(mappedBy="coursout") 
	 public List<StuOrderDetile> stuOrderDetiles;
	 
	 @OneToMany(mappedBy="coursout") 
	 public List<LabOrder> LabOrders;
	 
	 
	
	/* geter and seter */
	 
	

	public Coursout() {
		super();
		// TODO Auto-generated constructor stub
	}


	public List<UserCoursoutCart> getUserCoursoutCarts() {
		return userCoursoutCarts;
	}

	public void setUserCoursoutCarts(List<UserCoursoutCart> userCoursoutCarts) {
		this.userCoursoutCarts = userCoursoutCarts;
	}

	public List<UserCoursoutDetile> getUserCoursoutDetiles() {
		return userCoursoutDetiles;
	}

	public void setUserCoursoutDetiles(List<UserCoursoutDetile> userCoursoutDetiles) {
		this.userCoursoutDetiles = userCoursoutDetiles;
	}

	public int getcId() {
		return cId;
	}

	public void setcId(int cId) {
		this.cId = cId;
	}

	public String getStatust() {
		return statust;
	}

	public void setStatust(String statust) {
		this.statust = statust;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getCcode() {
		return ccode;
	}

	public void setCcode(String ccode) {
		this.ccode = ccode;
	}

	public String getCmodule() {
		return cmodule;
	}

	public void setCmodule(String cmodule) {
		this.cmodule = cmodule;
	}

	public String getCps() {
		return cps;
	}

	public void setCps(String cps) {
		this.cps = cps;
	}

	public String getClecture() {
		return clecture;
	}

	public void setClecture(String clecture) {
		this.clecture = clecture;
	}

	public String getCtutrial() {
		return ctutrial;
	}

	public void setCtutrial(String ctutrial) {
		this.ctutrial = ctutrial;
	}

	public String getClaboratory() {
		return claboratory;
	}

	public void setClaboratory(String claboratory) {
		this.claboratory = claboratory;
	}

	public String getCstudy() {
		return cstudy;
	}

	public void setCstudy(String cstudy) {
		this.cstudy = cstudy;
	}

	public String getPreRequi() {
		return preRequi;
	}

	public void setPreRequi(String preRequi) {
		this.preRequi = preRequi;
	}

	public String getaYear() {
		return aYear;
	}

	public void setaYear(String aYear) {
		this.aYear = aYear;
	}

	public String getCourseobjectone() {
		return courseobjectone;
	}

	public void setCourseobjectone(String courseobjectone) {
		this.courseobjectone = courseobjectone;
	}

	public String getCourseobjecttwo() {
		return courseobjecttwo;
	}

	public void setCourseobjecttwo(String courseobjecttwo) {
		this.courseobjecttwo = courseobjecttwo;
	}

	public String getCourseobjectthree() {
		return courseobjectthree;
	}

	public void setCourseobjectthree(String courseobjectthree) {
		this.courseobjectthree = courseobjectthree;
	}

	public String getCourseobjectfour() {
		return courseobjectfour;
	}

	public void setCourseobjectfour(String courseobjectfour) {
		this.courseobjectfour = courseobjectfour;
	}

	public String getCourseobjectfive() {
		return courseobjectfive;
	}

	public void setCourseobjectfive(String courseobjectfive) {
		this.courseobjectfive = courseobjectfive;
	}

	public String getCourseobjectsix() {
		return courseobjectsix;
	}

	public void setCourseobjectsix(String courseobjectsix) {
		this.courseobjectsix = courseobjectsix;
	}

	public String getCourseobjectseven() {
		return courseobjectseven;
	}

	public void setCourseobjectseven(String courseobjectseven) {
		this.courseobjectseven = courseobjectseven;
	}

	public String getCourseobjecteight() {
		return courseobjecteight;
	}

	public void setCourseobjecteight(String courseobjecteight) {
		this.courseobjecteight = courseobjecteight;
	}

	public String getCourseobjectnine() {
		return courseobjectnine;
	}

	public void setCourseobjectnine(String courseobjectnine) {
		this.courseobjectnine = courseobjectnine;
	}

	public String getCourseobjectten() {
		return courseobjectten;
	}

	public void setCourseobjectten(String courseobjectten) {
		this.courseobjectten = courseobjectten;
	}

	public String getCdescription() {
		return cdescription;
	}

	public void setCdescription(String cdescription) {
		this.cdescription = cdescription;
	}

	public int getChapaf() {
		return chapaf;
	}

	public void setChapaf(int chapaf) {
		this.chapaf = chapaf;
	}

	public int getChapbf() {
		return chapbf;
	}

	public void setChapbf(int chapbf) {
		this.chapbf = chapbf;
	}

	public int getChapbfmidplan() {
		return chapbfmidplan;
	}

	public void setChapbfmidplan(int chapbfmidplan) {
		this.chapbfmidplan = chapbfmidplan;
	}

	public int getChapafmidplan() {
		return chapafmidplan;
	}

	public void setChapafmidplan(int chapafmidplan) {
		this.chapafmidplan = chapafmidplan;
	}

	public int getAssbfmidplan() {
		return assbfmidplan;
	}

	public void setAssbfmidplan(int assbfmidplan) {
		this.assbfmidplan = assbfmidplan;
	}

	public int getAssafmidplan() {
		return assafmidplan;
	}

	public void setAssafmidplan(int assafmidplan) {
		this.assafmidplan = assafmidplan;
	}

	public String getcPolicy() {
		return cPolicy;
	}

	public void setcPolicy(String cPolicy) {
		this.cPolicy = cPolicy;
	}

	public String getBook1() {
		return book1;
	}

	public void setBook1(String book1) {
		this.book1 = book1;
	}

	public String getBook2() {
		return book2;
	}

	public void setBook2(String book2) {
		this.book2 = book2;
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

	public Groupt getGroupt() {
		return groupt;
	}

	public void setGroupt(Groupt groupt) {
		this.groupt = groupt;
	}

	public Integer getGrouptid() {
		return grouptid;
	}

	public void setGrouptid(Integer grouptid) {
		this.grouptid = grouptid;
	}

	public Refer getRefer() {
		return refer;
	}

	public void setRefer(Refer refer) {
		this.refer = refer;
	}

	public Integer getReferid() {
		return referid;
	}

	public void setReferid(Integer referid) {
		this.referid = referid;
	}

	public Week getWeek() {
		return week;
	}

	public void setWeek(Week week) {
		this.week = week;
	}

	public Integer getWeekid() {
		return weekid;
	}

	public void setWeekid(Integer weekid) {
		this.weekid = weekid;
	}

	public Chapterbf getChapterbf() {
		return chapterbf;
	}

	public void setChapterbf(Chapterbf chapterbf) {
		this.chapterbf = chapterbf;
	}

	public Integer getChapterbfid() {
		return chapterbfid;
	}

	public void setChapterbfid(Integer chapterbfid) {
		this.chapterbfid = chapterbfid;
	}

	public Chapteraf getChapteraf() {
		return chapteraf;
	}

	public void setChapteraf(Chapteraf chapteraf) {
		this.chapteraf = chapteraf;
	}

	public Integer getChapterafid() {
		return chapterafid;
	}

	public void setChapterafid(Integer chapterafid) {
		this.chapterafid = chapterafid;
	}

	public Chapterlast getChapterlast() {
		return chapterlast;
	}

	public void setChapterlast(Chapterlast chapterlast) {
		this.chapterlast = chapterlast;
	}

	public Integer getChapterlastid() {
		return chapterlastid;
	}

	public void setChapterlastid(Integer chapterlastid) {
		this.chapterlastid = chapterlastid;
	}

	public Assess getAssess() {
		return assess;
	}

	public void setAssess(Assess assess) {
		this.assess = assess;
	}

	public Integer getAssessid() {
		return assessid;
	}

	public void setAssessid(Integer assessid) {
		this.assessid = assessid;
	}

	public ComLearn getComlearn() {
		return comlearn;
	}

	public void setComlearn(ComLearn comlearn) {
		this.comlearn = comlearn;
	}

	public Integer getComlearnid() {
		return comlearnid;
	}

	public void setComlearnid(Integer comlearnid) {
		this.comlearnid = comlearnid;
	}

	public Methodo getMethodo() {
		return methodo;
	}

	public void setMethodo(Methodo methodo) {
		this.methodo = methodo;
	}

	public Integer getMethodoid() {
		return methodoid;
	}

	public void setMethodoid(Integer methodoid) {
		this.methodoid = methodoid;
	}

	public ActiLab getActilab() {
		return actilab;
	}

	public void setActilab(ActiLab actilab) {
		this.actilab = actilab;
	}

	public Integer getActilabid() {
		return actilabid;
	}

	public void setActilabid(Integer actilabid) {
		this.actilabid = actilabid;
	}

	public TabRef getTabref() {
		return tabref;
	}

	public void setTabref(TabRef tabref) {
		this.tabref = tabref;
	}

	public Integer getTabrefid() {
		return tabrefid;
	}

	public void setTabrefid(Integer tabrefid) {
		this.tabrefid = tabrefid;
	}

	

	public AssWeek getAsweek() {
		return asweek;
	}

	public void setAsweek(AssWeek asweek) {
		this.asweek = asweek;
	}

	public Integer getAsweekid() {
		return asweekid;
	}

	public void setAsweekid(Integer asweekid) {
		this.asweekid = asweekid;
	}

	


	public List<InstaCart> getInstaCarts() {
		return instaCarts;
	}

	public void setInstaCarts(List<InstaCart> instaCarts) {
		this.instaCarts = instaCarts;
	}

	public List<StuCart> getStuCarts() {
		return stuCarts;
	}

	public void setStuCarts(List<StuCart> stuCarts) {
		this.stuCarts = stuCarts;
	}

	public List<InstaOrderDetile> getInstaOrderDetiles() {
		return instaOrderDetiles;
	}

	public void setInstaOrderDetiles(List<InstaOrderDetile> instaOrderDetiles) {
		this.instaOrderDetiles = instaOrderDetiles;
	}

	public List<StuOrderDetile> getStuOrderDetiles() {
		return stuOrderDetiles;
	}

	public void setStuOrderDetiles(List<StuOrderDetile> stuOrderDetiles) {
		this.stuOrderDetiles = stuOrderDetiles;
	}

	public List<LabOrder> getLabOrders() {
		return LabOrders;
	}

	public void setLabOrders(List<LabOrder> labOrders) {
		LabOrders = labOrders;
	}

	@Override
	public String toString() {
		return "Coursout [ccode=" + ccode + ", cmodule=" + cmodule + "]";
	}

	public Coursout(String ccode, String cmodule) {
		super();
		this.ccode = ccode;
		this.cmodule = cmodule;
	}
	
	
	
	
	
	

}
