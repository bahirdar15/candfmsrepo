package com.candfms.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.candfms.models.Fmie;
import com.candfms.models.User;


public interface FmieRepository extends JpaRepository<Fmie, Integer>{

	
	@Query("select f from Fmie f where f.id=:fmieid")
	public Fmie getNameByFmieid(@Param("fmieid") int fmieid);
}
