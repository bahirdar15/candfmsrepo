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
import com.candfms.models.LabOrderDetile;
import com.candfms.models.StuOrderDetile;

public interface LabOrderDeileRepository extends JpaRepository<LabOrderDetile,Integer>{
	
	/*
	 * @Query("from Feedback as f where f.user.id=:userId") public List<Feedback>
	 * findFeedbackByUser(@Param("userId")int userId);
	 */
	/*
	 * @Query("from InstaCart as i where i.userid=:userid") public List<InstaCart>
	 * findByUserId(@Param("userid")int userid);
	 */
	
	@Query("from LabOrderDetile as i where i.orderid=:orderid")
	public List<LabOrderDetile> findByOrderId(@Param("orderid")int orderid);
}
