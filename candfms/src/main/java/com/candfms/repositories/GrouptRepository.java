package com.candfms.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.candfms.models.Groupt;


public interface GrouptRepository extends JpaRepository<Groupt, Integer>{

	
	@Query("select g from Groupt g where g.id=:grouptid")
	public Groupt getNameByGrouptid(@Param("grouptid") int grouptid);
}
