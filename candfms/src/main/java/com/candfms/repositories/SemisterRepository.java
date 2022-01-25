package com.candfms.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.candfms.models.Semester;


public interface SemisterRepository extends JpaRepository<Semester, Integer>{

	
	@Query("select s from Semester s where s.id=:semesterid")
	public Semester getNameBysemesterid(@Param("semesterid") int semesterid);
}
