package com.candfms.repositories;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.candfms.models.LabOrder;
import com.candfms.models.User;

import com.candfms.models.UserCoursoutAssign;


public interface UserCoursoutAssignRepository extends JpaRepository<UserCoursoutAssign, Integer>{

	
	
	  @Query("from UserCoursoutAssign as c where c.userid=:userid ORDER BY c.id DESC") 
	  public List<UserCoursoutAssign> findReqByAssignerUserId(@Param("userid")int userid);
	  
		/*
		 * @Query("from UserCoursoutAssign as c where c.chnId=:chnId") public
		 * List<UserCoursoutAssign> findByChirIdUc(@Param("chnId")int chnId);
		 * 
		 * public List<UserCoursoutAssign> findByUser(User user);
		 */
	  
	 
}
