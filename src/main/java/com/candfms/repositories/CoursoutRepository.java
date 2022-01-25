package com.candfms.repositories;

import java.util.Collection;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.candfms.models.Coursout;


public interface CoursoutRepository extends JpaRepository<Coursout,Integer>{

	 @Query("from Coursout as c where c.fmieid IN :fmieids ORDER BY c.id DESC") 
	 public List<Coursout> findCoursoutsByfmieid(@Param("fmieids") List<Integer> fmieids);
	 
	 @Query("from Coursout  ORDER BY id DESC") 
	 public List<Coursout> findAll();
	
	
	/*
	 * @Query("from Coursout as c where c.user.id=:userId") public List<Coursout>
	 * findCoursoutsByUser(@Param("userId")int userId);
	 * 
	 * @Query("from Coursout as c where c.approvedBy=:approvedById") public
	 * List<Coursout> findApprovedBy(@Param("approvedById")int approvedById);
	 * 
	 * @Query("from Coursout as c where c.user.id=:userd") public Coursout
	 * findCoursoutsById(@Param("userd")int userd);
	 */
	public List<Coursout> findBycIdIn(Integer[] cId);
}
