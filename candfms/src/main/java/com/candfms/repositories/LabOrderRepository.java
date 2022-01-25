package com.candfms.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.candfms.models.Coursout;
import com.candfms.models.Feedback;
import com.candfms.models.InstaCart;
import com.candfms.models.InstaOrder;
import com.candfms.models.LabOrder;
import com.candfms.models.StuOrder;

public interface LabOrderRepository extends JpaRepository<LabOrder,Integer>{
	
	/*
	 * @Query("from Feedback as f where f.user.id=:userId") public List<Feedback>
	 * findFeedbackByUser(@Param("userId")int userId);
	 * @Query("from InstaCart as i where i.userid=:userid") public List<InstaCart>
	 * findByUserId(@Param("userid")int userid);
	 
	 */
	/**/
	 @Query("from LabOrder  ORDER BY id DESC") 
	 public List<LabOrder> findAll();
	 
	@Query("from LabOrder as i where i.userid=:userid and i.data='oncart' ORDER BY i.id DESC")
	public List<LabOrder> findByOrderUserId(@Param("userid")int userid);
	
	@Query("from LabOrder as i where i.userid=:userid and i.data='ordered' ORDER BY i.id DESC")
	public List<LabOrder> findByOrderUserDataId(@Param("userid")int userid);
	
	@Query("from LabOrder as i where i.approvedby=:approvedby ORDER BY i.id DESC")
	public List<LabOrder> findByApprovedCourseChairId(@Param("approvedby")int approvedby);
	
	@Query("from LabOrder as i where i.endorsedby=:endorsedby ORDER BY i.id DESC")
	public List<LabOrder> findByEndorsedChairHolderId(@Param("endorsedby")int endorsedby);

	@Query("select i.id from LabOrder as i where i.ayear=:ayear and i.semesterid=:semesterid and i.bam=:bam and i.prog=:prog and i.yearid=:yearid and i.section=:section and i.coursoutid=:coursoutid and i.grou=:grou and i.userid=:userid  and i.data='oncart'")
	public List<Integer> findnafBy9compaid(@Param("ayear")String ayear,@Param("semesterid")int semesterid,@Param("bam")String bam,@Param("prog")String prog,@Param("yearid")int yearid,@Param("section")String section,@Param("coursoutid")int coursoutid,@Param("grou")String grou,@Param("userid")int userid);
	
}
