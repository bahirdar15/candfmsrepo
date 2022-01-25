package com.candfms.repositories;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.candfms.models.LabOrder;
import com.candfms.models.User;

import com.candfms.models.UserCoursoutAssign;
import com.candfms.models.UserCoursoutDetile;


public interface UserCoursoutDetileRepository extends JpaRepository<UserCoursoutDetile, Integer>{

	
	@Query("from UserCoursoutDetile as c where c.instaId=:instaId  ORDER BY c.id DESC") 
	  public List<UserCoursoutDetile> findByInstaUserId(@Param("instaId")int instaId);
	
	//@Query("from UserCoursoutDetile as c where c.userid=:userid") 
	//  public List<UserCoursoutDetile> findByChirUserId(@Param("userid")int userid);
	
	//@Query("from ((SELECT DISTINCT c.instaId from UserCoursoutDetile as c) where c.userid=:userid") 
	//  public List<UserCoursoutDetile> findByInstaUserIduu(@Param("userid")int userid);
	  
	  
	 
}
