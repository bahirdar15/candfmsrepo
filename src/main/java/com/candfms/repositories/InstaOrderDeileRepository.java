package com.candfms.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.candfms.models.Coursout;
import com.candfms.models.Feedback;
import com.candfms.models.InstaCart;
import com.candfms.models.InstaOrder;
import com.candfms.models.InstaOrderDetile;
import com.candfms.models.LabOrder;
import com.candfms.models.UserCoursoutDetile;

public interface InstaOrderDeileRepository extends JpaRepository<InstaOrderDetile,Integer>{
	
	/*
	 * @Query("from Feedback as f where f.user.id=:userId") public List<Feedback>
	 * findFeedbackByUser(@Param("userId")int userId);
	 */
	/*
	 * @Query("from InstaCart as i where i.userid=:userid") public List<InstaCart>
	 * findByUserId(@Param("userid")int userid);
	 */
	
	@Query("from InstaOrderDetile as i where i.orderid=:orderid")
	public List<InstaOrderDetile> findByOrderId(@Param("orderid")int orderid);
	
	
	/* COALESCE(sum(e.ncco),0) */	
	@Query("select  COALESCE(sum(e.ncco),0)  from InstaOrderDetile e where e.orderid=:orderid and e.yearid=:yearid")
	public String SumNcc(@Param("orderid") int  orderid,@Param("yearid") int  yearid); 	
	
	@Query("select COALESCE(sum(i.ncp),0) from InstaOrderDetile as i where i.ayear=:ayear and i.semesterid=:semesterid and i.bam=:bam and i.prog=:prog  and i.fmieid=:fmieid")
	public Integer findncpBy5allYear(@Param("ayear")String ayear,@Param("semesterid")int semesterid,@Param("bam")String bam,@Param("prog")String prog,@Param("fmieid") int fmieid);
	@Query("select COALESCE(sum(i.ncco),0) from InstaOrderDetile as i where i.ayear=:ayear and i.semesterid=:semesterid and i.bam=:bam and i.prog=:prog  and i.fmieid=:fmieid")
	public Integer findnccoBy5allYear(@Param("ayear")String ayear,@Param("semesterid")int semesterid,@Param("bam")String bam,@Param("prog")String prog,@Param("fmieid") int fmieid);
	@Query("select COALESCE(sum(i.nap),0) from InstaOrderDetile as i where i.ayear=:ayear and i.semesterid=:semesterid and i.bam=:bam and i.prog=:prog  and i.fmieid=:fmieid")
	public Integer findnapBy5allYear(@Param("ayear")String ayear,@Param("semesterid")int semesterid,@Param("bam")String bam,@Param("prog")String prog,@Param("fmieid") int fmieid);
	@Query("select COALESCE(sum(i.nad),0) from InstaOrderDetile as i where i.ayear=:ayear and i.semesterid=:semesterid and i.bam=:bam and i.prog=:prog  and i.fmieid=:fmieid")
	public Integer findnadBy5allYear(@Param("ayear")String ayear,@Param("semesterid")int semesterid,@Param("bam")String bam,@Param("prog")String prog,@Param("fmieid") int fmieid);
	@Query("select COALESCE(sum(i.naf),0) from InstaOrderDetile as i where i.ayear=:ayear and i.semesterid=:semesterid and i.bam=:bam and i.prog=:prog  and i.fmieid=:fmieid")
	public Integer findnafBy5allYear(@Param("ayear")String ayear,@Param("semesterid")int semesterid,@Param("bam")String bam,@Param("prog")String prog,@Param("fmieid") int fmieid);	
	
	@Query("select COALESCE(sum(i.ncp),0) from InstaOrderDetile as i where i.ayear=:ayear and i.semesterid=:semesterid and i.yearid=:yearid and i.bam=:bam and i.prog=:prog  and i.fmieid=:fmieid")
	public Integer findncpBy6(@Param("ayear")String ayear,@Param("semesterid")int semesterid,@Param("yearid")int yearid,@Param("bam")String bam,@Param("prog")String prog,@Param("fmieid") int fmieid);
	@Query("select COALESCE(sum(i.ncco),0) from InstaOrderDetile as i where i.ayear=:ayear and i.semesterid=:semesterid and i.yearid=:yearid and i.bam=:bam and i.prog=:prog  and i.fmieid=:fmieid")
	public Integer findnccoBy6(@Param("ayear")String ayear,@Param("semesterid")int semesterid,@Param("yearid")int yearid,@Param("bam")String bam,@Param("prog")String prog,@Param("fmieid") int fmieid);
	@Query("select COALESCE(sum(i.nap),0) from InstaOrderDetile as i where i.ayear=:ayear and i.semesterid=:semesterid and i.yearid=:yearid and i.bam=:bam and i.prog=:prog  and i.fmieid=:fmieid")
	public Integer findnapBy6(@Param("ayear")String ayear,@Param("semesterid")int semesterid,@Param("yearid")int yearid,@Param("bam")String bam,@Param("prog")String prog,@Param("fmieid") int fmieid);
	@Query("select COALESCE(sum(i.nad),0) from InstaOrderDetile as i where i.ayear=:ayear and i.semesterid=:semesterid and i.yearid=:yearid and i.bam=:bam and i.prog=:prog  and i.fmieid=:fmieid")
	public Integer findnadBy6(@Param("ayear")String ayear,@Param("semesterid")int semesterid,@Param("yearid")int yearid,@Param("bam")String bam,@Param("prog")String prog,@Param("fmieid") int fmieid);
	@Query("select COALESCE(sum(i.naf),0) from InstaOrderDetile as i where i.ayear=:ayear and i.semesterid=:semesterid and i.yearid=:yearid and i.bam=:bam and i.prog=:prog  and i.fmieid=:fmieid")
	public Integer findnafBy6(@Param("ayear")String ayear,@Param("semesterid")int semesterid,@Param("yearid")int yearid,@Param("bam")String bam,@Param("prog")String prog,@Param("fmieid") int fmieid);
	
	@Query("select distinct e.fmieid from InstaOrderDetile e where e.fmieid is not null")
	List<Integer> allFmieId();
	@Query("select distinct(e.fmieid) from InstaOrderDetile e where e.fmieid is not null")
	List<Integer> allFmieId2();	
	@Query("select  i.ncp from InstaOrderDetile as i where i.ayear=:ayear and i.semesterid=:semesterid and i.yearid=:yearid and i.bam=:bam and i.prog=:prog  and i.fmieid=:fmieid")
	public Integer findncpBy69(@Param("ayear")String ayear,@Param("semesterid")int semesterid,@Param("yearid")int yearid,@Param("bam")String bam,@Param("prog")String prog,@Param("fmieid") int fmieid);
	
	
	@Query("from InstaOrderDetile as i where i.ayear=:ayear and i.semesterid=:semesterid and i.bam=:bam and i.prog=:prog ")
	public List<InstaOrderDetile> findnafBy4allYearFmie(@Param("ayear")String ayear,@Param("semesterid")int semesterid,@Param("bam")String bam,@Param("prog")String prog);	

	/* select 4 distinct */
	@Query("select distinct i.compaid from InstaOrderDetile as i where i.ayear=:ayear and i.semesterid=:semesterid and i.bam=:bam and i.prog=:prog ")
	public Integer findnafBy4allYearFmieDistinctcompaid(@Param("ayear")String ayear,@Param("semesterid")int semesterid,@Param("bam")String bam,@Param("prog")String prog);	
	
	@Query("select distinct i.endorsdeanid from InstaOrderDetile as i where i.ayear=:ayear and i.semesterid=:semesterid and i.bam=:bam and i.prog=:prog ")
	public Integer findnafBy4allYearFmieDistinctendorsdeanid(@Param("ayear")String ayear,@Param("semesterid")int semesterid,@Param("bam")String bam,@Param("prog")String prog);		
	
	@Query("select distinct i.copadate from InstaOrderDetile as i where i.ayear=:ayear and i.semesterid=:semesterid and i.bam=:bam and i.prog=:prog ")
	public String findnafBy4allYearFmieDistinctcopadate(@Param("ayear")String ayear,@Param("semesterid")int semesterid,@Param("bam")String bam,@Param("prog")String prog);	
		
	@Query("select distinct i.endorsedeandate from InstaOrderDetile as i where i.ayear=:ayear and i.semesterid=:semesterid and i.bam=:bam and i.prog=:prog ")
	public String findnafBy4allYearFmieDistinctendorsedeandate(@Param("ayear")String ayear,@Param("semesterid")int semesterid,@Param("bam")String bam,@Param("prog")String prog);	
	
	
	@Query("select distinct i.compaid from InstaOrderDetile as i where i.ayear=:ayear and i.semesterid=:semesterid and i.bam=:bam and i.prog=:prog")
	public Integer findnafBy34compaid(@Param("ayear")String ayear,@Param("semesterid")int semesterid,@Param("bam")String bam,@Param("prog")String prog);
	
	@Query("select distinct i.compaid from InstaOrderDetile as i where i.ayear=:ayear and i.semesterid=:semesterid and i.bam=:bam and i.prog=:prog and i.filledby=:filledby and i.yearid=:yearid and i.sect=:sect and i.coursoutid=:coursoutid")
	public Integer findnafBy8compaid(@Param("ayear")String ayear,@Param("semesterid")int semesterid,@Param("bam")String bam,@Param("prog")String prog,@Param("filledby")int filledby,@Param("yearid")int yearid,@Param("sect")String sect,@Param("coursoutid")int coursoutid);
	
	
}
