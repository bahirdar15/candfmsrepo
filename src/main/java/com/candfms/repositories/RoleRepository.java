package com.candfms.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.candfms.models.Role;
import com.candfms.models.User;

public interface RoleRepository extends JpaRepository<Role, Integer> {
	@Query("SELECT r FROM Role r WHERE r.name = ?1")
	public Role findByName(String name);
	
	@Query("SELECT r FROM Role r  WHERE r.name != 'ADMIN'")
	public  List<Role> findAllExptAdmin();
	
	
}
