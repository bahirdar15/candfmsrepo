package com.candfms.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.candfms.models.Coursout;
import com.candfms.models.Feedback;
import com.candfms.models.InstaCart;
import com.candfms.models.InstaOrder;
import com.candfms.models.StuOrder;

public interface StuOrderRepository extends JpaRepository<StuOrder,Integer>{
	
	/*
	 * @Query("from Feedback as f where f.user.id=:userId") public List<Feedback>
	 * findFeedbackByUser(@Param("userId")int userId);
	 * @Query("from InstaCart as i where i.userid=:userid") public List<InstaCart>
	 * findByUserId(@Param("userid")int userid);
	 
	 */
	/**/
	
	 @Query("from StuOrder  ORDER BY id DESC") 
	 public List<StuOrder> findAll(); 
	 
	@Query("from StuOrder as i where i.userid=:userid ORDER BY i.id DESC")
	public List<StuOrder> findByOrderUserId(@Param("userid")int userid);
	
	@Query("from StuOrder as i where i.approvedby=:approvedby ORDER BY i.id DESC")
	public List<StuOrder> findByApprovedCourseChairId(@Param("approvedby")int approvedby);
	
	@Query("from StuOrder as i where i.endorsedby=:endorsedby ORDER BY i.id DESC")
	public List<StuOrder> findByEndorsedChairHolderId(@Param("endorsedby")int endorsedby);

}
