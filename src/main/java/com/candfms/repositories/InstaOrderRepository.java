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

public interface InstaOrderRepository extends JpaRepository<InstaOrder,Integer>{
	
	/*
	 * @Query("from Feedback as f where f.user.id=:userId") public List<Feedback>
	 * findFeedbackByUser(@Param("userId")int userId);
	 * @Query("from InstaCart as i where i.userid=:userid") public List<InstaCart>
	 * findByUserId(@Param("userid")int userid);
	 
	 */
	/**/
	 @Query("from InstaOrder  ORDER BY id DESC") 
	 public List<InstaOrder> findAll();
	 
	@Query("from InstaOrder as i where i.userid=:userid ORDER BY i.id DESC")
	public List<InstaOrder> findByOrderUserId(@Param("userid")int userid);
	
	@Query("from InstaOrder as i where i.approvedby=:approvedby ORDER BY i.id DESC")
	public List<InstaOrder> findByApprovedCourseChairId(@Param("approvedby")int approvedby);
	
	@Query("from InstaOrder as i where i.endorsedby=:endorsedby ORDER BY i.id DESC")
	public List<InstaOrder> findByEndorsedChairHolderId(@Param("endorsedby")int endorsedby);
	
	/*
	 * @Query("from ((SELECT DISTINCT c.ayear from InstaOrder as c) where c.userid=:userid"
	 * ) public List<InstaOrder> findAyear(@Param("userid")int userid);
	 * 
	 */

	
	@Query("from InstaOrder as i where i.ayear=:ayear and i.semesterid=:semesterid and i.prog=:prog and i.bam=:bam")
	public List<InstaOrder> findByFourId(@Param("ayear")String ayear,@Param("semesterid")int semesterid,@Param("prog")String prog,@Param("bam")String bam);
	
	@Query("select distinct e.ayear from InstaOrder e where e.ayear is not null ORDER BY e.id DESC")
	List<Integer> allAyear();
}
