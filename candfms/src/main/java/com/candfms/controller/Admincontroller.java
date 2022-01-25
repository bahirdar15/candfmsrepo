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
import com.candfms.models.Fmie;
import com.candfms.models.Switcch;
import com.candfms.models.User;
import com.candfms.repositories.AdminRepository;
import com.candfms.repositories.CoursoutRepository;
import com.candfms.repositories.SwitcchRepository;
import com.candfms.repositories.UserRepositories;
import com.candfms.service.AdminService;
import com.candfms.service.FmieService;

@Controller
@RequestMapping("/admin")
public class Admincontroller {


	
	
	@Autowired
	private AdminService adminService;
	

	@Autowired
	private AdminRepository adminRepository;
	
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
		
		/*
		 * String roledd = "ROLE_DIV"; List<User> uuu=
		 * this.userRepository.getUserByRole(roledd); model.addAttribute("userss", uuu);
		 */
	}
	
	
	
	@GetMapping("/userShow")
	public String getAdmins(Model model,HttpSession session) {	
		try {
		model.addAttribute("title","C|And|F - Users");	
		List<User> adminList = adminService.getUsers();	
		model.addAttribute("admins", adminList);	
			
		return "faculty/userShow";
		} catch(Exception e) {
			e.printStackTrace(); 
			session.setAttribute("message", new Message("Somthing Went wrong !!"+e.getMessage(),"alert-danger"));
			return "faculty/index";
		}
	}	
	
	@PostMapping("/addNewUser")
	public String addNewUser(User user,HttpSession session) {
		
		try {
		int idd=8;
		user.setEnabled(false);
		user.setId(idd);
		adminService.save(user);
		//message success...........
		session.setAttribute("message", new Message("Successfully Add New User  !!","alert-success"));
    
		return "redirect:/admin/userShow";
		} catch(Exception e) {
			e.printStackTrace(); 
			session.setAttribute("message", new Message("Somthing Went wrong !!"+e.getMessage(),"alert-danger"));
			return "faculty/index";
		}
	}
	
	@RequestMapping("/findById")
	@ResponseBody
	public Optional<User> findById(int id) {
		
		return adminService.findById(id);	
		
	}	
	
	@RequestMapping(value="/update", method= {RequestMethod.PUT, RequestMethod.GET})
	public String update(User user,HttpSession session) {
		try {
		adminService.save(user);
		//message success...........
		session.setAttribute("message", new Message("Successfully Updated  !!","alert-success"));
    
		return "redirect:/admin/userShow";
		} catch(Exception e) {
			e.printStackTrace(); 
			session.setAttribute("message", new Message("Somthing Went wrong !!"+e.getMessage(),"alert-danger"));
			return "faculty/index";
		}
	}
	
	@RequestMapping(value="/delete", method= {RequestMethod.DELETE, RequestMethod.GET})
	public String delete(int id,HttpSession session) {
		try {
		adminService.delete(id);
		//message success...........
		session.setAttribute("message", new Message("Successfully Deleted  !!","alert-success"));
    
		return "redirect:/admin/userShow";
		} catch(Exception e) {
			e.printStackTrace(); 
			session.setAttribute("message", new Message("Somthing Went wrong !!"+e.getMessage(),"alert-danger"));
			return "faculty/index";
		}
	}
}
