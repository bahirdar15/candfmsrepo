package com.candfms.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.candfms.models.Coursout;
import com.candfms.models.Feedback;
import com.candfms.models.InstaCart;

public interface OrderRepository extends JpaRepository<InstaCart,Integer>{
	
	
	@Query("from InstaCart as i where i.userid=:userid")
	public List<InstaCart> findByUserId(@Param("userid")int userid);

}
