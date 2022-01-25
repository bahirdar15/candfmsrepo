package com.candfms.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.candfms.models.Coursout;
import com.candfms.models.Feedback;
import com.candfms.models.InstaCart;
import com.candfms.models.LabCart;
import com.candfms.models.StuCart;

public interface LabCartStuRepository extends JpaRepository<LabCart,Integer>{
	
	/*
	 * @Query("from Feedback as f where f.user.id=:userId") public List<Feedback>
	 * findFeedbackByUser(@Param("userId")int userId);
	 */
	@Query("from LabCart as i where i.userid=:userid")
	public List<LabCart> findByUserId(@Param("userid")int userid);
	
	@Query("from LabCart as i where i.orderid=:orderid")
	public List<LabCart> findByOrderId(@Param("orderid")int orderid);

}
