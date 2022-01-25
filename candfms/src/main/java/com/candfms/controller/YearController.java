package com.candfms.controller;

import java.security.Principal;
import java.util.List;
import java.util.Optional;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.candfms.helper.Message;
import com.candfms.models.Switcch;
import com.candfms.models.User;
import com.candfms.models.Year;
import com.candfms.repositories.CoursoutRepository;
import com.candfms.repositories.SwitcchRepository;
import com.candfms.repositories.UserRepositories;
import com.candfms.service.YearService;

@Controller
@RequestMapping("/year")
public class YearController {
	@Autowired
	private YearService yearService;
	
	@Autowired
	private CoursoutRepository coursoutRepository;
	

	@Autowired
	private UserRepositories userRepository;
	
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
	
	
	
	@GetMapping("/yearShow")
	public String getCountries(Model model) {	
		model.addAttribute("title","C|And|F - Dashboard");	
		List<Year> yearList = yearService.getYears();	
		model.addAttribute("years", yearList);	
			
		return "faculty/yearShow";
	}	
	
	@PostMapping("/addNew")
	public String addNew(Year year,HttpSession session) {
		yearService.save(year);
		//message success...........
		session.setAttribute("message", new Message("Successfully Add New Year  !!","alert-success"));
    
		return "redirect:/year/yearShow";
	}
	
	@RequestMapping("/findById")
	@ResponseBody
	public Optional<Year> findById(int id) {
	  return yearService.findById(id);	
	}	
	
	@RequestMapping(value="/update", method= {RequestMethod.PUT, RequestMethod.GET})
	public String update(Year year,HttpSession session) {
		yearService.save(year);
		//message success...........
		session.setAttribute("message", new Message("Successfully Updated  !!","alert-success"));
    
		return "redirect:/year/yearShow";
	}
	
	@RequestMapping(value="/delete", method= {RequestMethod.DELETE, RequestMethod.GET})
	public String delete(Integer id,HttpSession session) {
		yearService.delete(id);
		//message success...........
		session.setAttribute("message", new Message("Successfully Deleted  !!","alert-success"));
    
		return "redirect:/year/yearShow";
	}
}
