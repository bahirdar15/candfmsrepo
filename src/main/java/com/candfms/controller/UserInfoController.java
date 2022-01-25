package com.candfms.controller;

import java.security.Principal;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

import com.candfms.models.Switcch;
import com.candfms.models.User;
import com.candfms.repositories.SwitcchRepository;
import com.candfms.repositories.UserRepositories;

@Controller
@RequestMapping("/user")
public class UserInfoController {

	
	 @Autowired
		private SwitcchRepository swichRepo;
		
		@ModelAttribute
		public void addCommonData(Model model,Principal principal) { 
			
			Switcch switchFeedback1 = swichRepo.findById(1).get();
			model.addAttribute("switchFeedback1",switchFeedback1);
			Switcch switchFeedback2 = swichRepo.findById(2).get();
			model.addAttribute("switchFeedback2", switchFeedback2);

			Switcch switchPro1 = swichRepo.findById(3).get();
			model.addAttribute("switchPro1", switchPro1);
			Switcch switchPro2 = swichRepo.findById(4).get();
			model.addAttribute("switchPro2", switchPro2);
			
		
		//get the user using username(username)
		String userName=principal.getName();
		User user = userRepository.getUserByUserName(userName);
		
		model.addAttribute("user",user);
		
	}
	
	@Autowired
	private UserRepositories userRepository;
	
	
}
