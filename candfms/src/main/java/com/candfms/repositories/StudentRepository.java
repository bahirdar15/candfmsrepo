package com.candfms.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;


import com.candfms.models.Student;

public interface StudentRepository extends JpaRepository<Student,Integer>{
	
	/*
	 * @Query("from Student as s where s.user.id=:userId") public List<Student>
	 * findStudentByUser(@Param("userId")int userId);
	 */
}
