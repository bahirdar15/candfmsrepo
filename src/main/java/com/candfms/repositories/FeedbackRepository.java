package com.candfms.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.candfms.models.Coursout;
import com.candfms.models.Feedback;

public interface FeedbackRepository extends JpaRepository<Feedback,Integer>{
	
	/*
	 * @Query("from Feedback as f where f.user.id=:userId") public List<Feedback>
	 * findFeedbackByUser(@Param("userId")int userId);
	 */
	@Query("from Feedback as f where f.approvedBy=:approvedById")
	public List<Feedback> findApprovedBy(@Param("approvedById")int approvedById);

}
