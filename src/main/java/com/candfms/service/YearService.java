package com.candfms.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.candfms.models.Year;
import com.candfms.repositories.YearRepository;
@Service
public class YearService {

	
	@Autowired
	private YearRepository yearRepository;
	
	//Return list of year
	public List<Year> getYears(){
		return yearRepository.findAll();
	}
	
	//SAve new year
		public void save(Year year) {
			yearRepository.save(year);
		}
		
		//get by id
		public Optional<Year> findById(int id) {
			return yearRepository.findById(id);
		}

		public void delete(Integer id) {
			yearRepository.deleteById(id);
		}
}
