package com.candfms.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.candfms.models.Semester;
import com.candfms.repositories.SemisterRepository;
@Service
public class SemesterService {

	
	@Autowired
	private SemisterRepository semesterRepository;
	
	//Return list of year
	public List<Semester> getSemesters(){
		return semesterRepository.findAll();
	}
	
	//Save new year
		public void save(Semester semester) {
			semesterRepository.save(semester);
		}
		
		//get by id
		public Optional<Semester> findById(int id) {
			return semesterRepository.findById(id);
		}

		public void delete(Integer id) {
			semesterRepository.deleteById(id);
		}
}
