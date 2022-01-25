package com.candfms.repositories;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.candfms.models.LabOrder;
import com.candfms.models.User;

import com.candfms.models.UserCoursoutCart;


public interface UserCoursoutCartRepository extends JpaRepository<UserCoursoutCart, Integer>{

	@Query("from UserCoursoutCart as c where c.userid=:userid ORDER BY c.id DESC") 
	  public List<UserCoursoutCart> findByAssignerId(@Param("userid")int userid);
	
	  
	 public List<UserCoursoutCart> findByIdIn(Integer[] id);
}
