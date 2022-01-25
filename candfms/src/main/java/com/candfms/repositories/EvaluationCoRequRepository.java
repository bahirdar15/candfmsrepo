package com.candfms.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.candfms.models.EvaluationCo;
import com.candfms.models.Evaluationstudent;

public interface EvaluationCoRequRepository extends JpaRepository<EvaluationCo,Integer>{
	
	
	/*
	 * @Query("select e from EvaluationCo e where e.proformRequid=:proformRequid")
	 * public List<EvaluationCo> getUserByApproveId(@Param("proformRequid") int
	 * proformRequid); EvaluationStudentRequRepository EvaluationSuperRequRepository
	 */
	
	@Query("select count(e) from EvaluationCo e where e.proformRequid=:proformRequid")
	public Integer countEvaluterCo(@Param("proformRequid") int  proformRequid); 
	
	@Query("select COALESCE(sum(e.avtotal),0) from EvaluationCo e where e.proformRequid=:proformRequid")
	public float sumEvaluterCo(@Param("proformRequid") int  proformRequid); 

	@Query("select count(u) from EvaluationCo u where u.proformRequid=:proformRequid and u.userid=:userid")
	public Integer countProformRequBytwo(@Param("proformRequid") int proformRequid,@Param("userid") int userid);
	
	@Query("select u from EvaluationCo u where u.userid=:userid")
	public List<EvaluationCo> findEvalutByUserIdId(@Param("userid") int userid);
}
