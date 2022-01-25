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
import com.candfms.models.StuOrderDetile;

public interface StuOrderDeileRepository extends JpaRepository<StuOrderDetile,Integer>{
	
	/*
	 * @Query("from Feedback as f where f.user.id=:userId") public List<Feedback>
	 * findFeedbackByUser(@Param("userId")int userId);
	 */
	/*
	 * @Query("from InstaCart as i where i.userid=:userid") public List<InstaCart>
	 * findByUserId(@Param("userid")int userid);
	 */
	
	@Query("from StuOrderDetile as i where i.orderid=:orderid")
	public List<StuOrderDetile> findByOrderId(@Param("orderid")int orderid);
	
	@Query("select distinct i.id from StuOrderDetile as i where i.ayear=:ayear and i.semesterid=:semesterid and i.bam=:bam and i.prog=:prog and i.userid=:userid and i.yearid=:yearid and i.section=:section and i.coursoutid=:coursoutid")
	public Integer findnafByid(@Param("ayear")String ayear,@Param("semesterid")int semesterid,@Param("bam")String bam,@Param("prog")String prog,@Param("userid")int userid,@Param("yearid")int yearid,@Param("section")String section,@Param("coursoutid")int coursoutid);
	
}
