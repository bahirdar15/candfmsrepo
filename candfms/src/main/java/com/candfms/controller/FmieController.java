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
import com.candfms.models.User;
import com.candfms.models.Fmie;
import com.candfms.models.Switcch;
import com.candfms.repositories.CoursoutRepository;
import com.candfms.repositories.SwitcchRepository;
import com.candfms.repositories.UserRepositories;
import com.candfms.service.FmieService;

@Controller
@RequestMapping("/fmie")
public class FmieController {

	@Autowired
	private FmieService fmieService;
	
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
	
	
	
	@GetMapping("/fmieShow")
	public String getCountries(Model model) {	
		model.addAttribute("title","C|And|F - Fmies");	
		List<Fmie> fmieList = fmieService.getFmies();	
		model.addAttribute("fmies", fmieList);	
			
		return "faculty/fmieShow";
	}	
	
	@PostMapping("/addNew")
	public String addNew(Fmie fmie,HttpSession session) {
		fmieService.save(fmie);
		//message success...........
		session.setAttribute("message", new Message("Successfully Add New Fmie  !!","alert-success"));
    
		return "redirect:/fmie/fmieShow";
	}
	
	@RequestMapping("/findById")
	@ResponseBody
	public Optional<Fmie> findById(int id) {
	  return fmieService.findById(id);	
	}	
	
	@RequestMapping(value="/update", method= {RequestMethod.PUT, RequestMethod.GET})
	public String update(Fmie fmie,HttpSession session) {
		fmieService.save(fmie);
		//message success...........
		session.setAttribute("message", new Message("Successfully Updated  !!","alert-success"));
    
		return "redirect:/fmie/fmieShow";
	}
	
	@RequestMapping(value="/delete", method= {RequestMethod.DELETE, RequestMethod.GET})
	public String delete(Integer id,HttpSession session) {
		fmieService.delete(id);
		//message success...........
		session.setAttribute("message", new Message("Successfully Deleted  !!","alert-success"));
		
		//var TempData["Msg"] = "Uploaded successfully";
		
		
	        
		//session.setAttribute("mess", "Uploaded successfully");
    
		return "redirect:/fmie/fmieShow";
	}
}
