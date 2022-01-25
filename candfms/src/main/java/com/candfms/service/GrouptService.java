package com.candfms.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.candfms.models.Groupt;
import com.candfms.repositories.GrouptRepository;


@Service
public class GrouptService {

	
	@Autowired
	private GrouptRepository grouptRepository;
	
	//Return list of group
	public List<Groupt> getGroupts(){
		return grouptRepository.findAll();
	}
	
	//SAve new group
		public void save(Groupt groupt) {
			grouptRepository.save(groupt);
		}
		
		//get by id
		public Optional<Groupt> findById(int id) {
			return grouptRepository.findById(id);
		}

		public void delete(Integer id) {
			grouptRepository.deleteById(id);
		}
}
