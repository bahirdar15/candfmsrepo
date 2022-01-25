package com.candfms.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.candfms.models.Coursout;
import com.candfms.models.Feedback;
import com.candfms.models.InstaCart;
import com.candfms.models.InstaOrder;
import com.candfms.models.ProformRequ;
import com.candfms.models.User;

public interface ProformRequCollegeRepository extends JpaRepository<ProformRequ,Integer>{ 
	
	@Query("from ProformRequ  ORDER BY id DESC") 
	 public List<ProformRequ> findAll();
	
	@Query("from ProformRequ as i where i.userid=:userid  ORDER BY i.id DESC")
	public List<ProformRequ> findByReqUserId(@Param("userid")int userid);
	
	@Query("from ProformRequ as i where i.user.depar=:depar   ORDER BY i.id DESC")
	public List<ProformRequ> findBydepar(@Param("depar")int depar);
	
	@Query("select u from ProformRequ u where u.userid=:userid")
	public ProformRequ getIdByUserId(@Param("userid") int userid);
	
	@Query("from ProformRequ as i where i.approvedby=:approvedby")
	public List<ProformRequ> findByApprovedCourseChairId(@Param("approvedby")int approvedby);
	
	
	@Query("from ProformRequ as i where i.approvedby=:approvedby")
	public List<ProformRequ> findByApprovedChairHolderId(@Param("approvedby")int approvedby);
	
	@Query("select u from ProformRequ u where u.userid=:userid and u.ayear=:ayear and u.semesterid=:semesterid")
	public List<ProformRequ> getProformRequBytree(@Param("userid") int userid,@Param("ayear") int ayear,@Param("semesterid") int semesterid);

	@Query("select u from ProformRequ u where u.userid=:userid and u.ayear=:ayear and u.semesterid=:semesterid")
	public ProformRequ  getProformRequBytreeSingle(@Param("userid") int userid,@Param("ayear") int ayear,@Param("semesterid") int semesterid);

	@Query("select count(u) from ProformRequ u where u.userid=:userid and u.ayear=:ayear and u.semesterid=:semesterid")
	public Integer countProformRequBytree(@Param("userid") int userid,@Param("ayear") int ayear,@Param("semesterid") int semesterid);
	
	@Query("select count(u) from ProformRequ u where u.userid=:userid")
	public Integer countProformRequByone(@Param("userid") int userid);
	
	@Query("select count(u) from ProformRequ u where u.userid=:userid and u.semesterid=:semesterid")
	public Integer countProformRequBytwo(@Param("userid") int userid,@Param("semesterid") int semesterid);
	
	// @Query("update ProformRequ c set c.sumofcount = :sumofcount WHERE c.id = :id")
   //  void setCustomSum(@Param("id") int id, @Param("name") int sumofcount);
	
	

}
