package com.candfms.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.candfms.models.Fmie;
import com.candfms.models.User;
import com.candfms.repositories.AdminRepository;



@Service
public class AdminService {

	
	@Autowired
	private AdminRepository adminRepository;
	
	//Return list of year
	public List<User> getUsers(){
		return adminRepository.findAll();
	}
	
	//SAve new year
		public void save(User user) {
			adminRepository.save(user);
		}
		
		//get by id
		public Optional<User> findById(int id) {
			return adminRepository.findById(id);
		}

		public void delete(int id) {
			adminRepository.deleteById(id);
		}
}
