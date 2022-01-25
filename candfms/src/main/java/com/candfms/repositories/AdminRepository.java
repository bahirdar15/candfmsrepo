package com.candfms.repositories;



import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.candfms.models.Fmie;
import com.candfms.models.User;


public interface AdminRepository extends JpaRepository<User, Integer>{

	
}
