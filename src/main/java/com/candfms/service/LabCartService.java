package com.candfms.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.candfms.models.Fmie;
import com.candfms.models.LabCart;
import com.candfms.repositories.FmieRepository;
import com.candfms.repositories.LabCartStuRepository;
@Service
public class LabCartService {

	
	@Autowired
	private LabCartStuRepository laCartRepository;
	
	
	/*
	 * public void save(LabCart labCart) { laCartRepository.save(labCart); }
	 */
		
		

		
		public LabCart saveUser(String lname,String week) {

			LabCart labCart = new LabCart();
			labCart.setWeek(week);
			labCart.setLname(lname);			
			laCartRepository.save(labCart);
			
			return labCart;
		}
		
		
		
}
