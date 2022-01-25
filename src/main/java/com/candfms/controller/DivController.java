package com.candfms.controller;

import java.security.Principal;
import java.util.List;
import java.util.Optional;

import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.candfms.helper.Message;
import com.candfms.models.Coursout;
import com.candfms.models.Fmie;
import com.candfms.models.Role;
import com.candfms.models.Switcch;
import com.candfms.models.User;
import com.candfms.repositories.RoleRepository;
import com.candfms.repositories.SwitcchRepository;
import com.candfms.repositories.UserRepositories;
import com.candfms.service.FmieService;




@Controller
@RequestMapping("/div")
public class DivController {
	
	@Autowired
	private FmieService fmieService;
	
	@Autowired
	private BCryptPasswordEncoder passwordEncoder;
	
	@Autowired 
	private RoleRepository roleRepo;
	
	
	
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
		
		String role0 = "INSTRUCTOR";
		Integer id0 = roleRepo.findByName(role0).getId();
		List<User> user0 = this.userRepository.findByRole(id0);
		model.addAttribute("userss", user0);
		
		List<Role> listRoles = roleRepo.findAllExptAdmin();			 
		model.addAttribute("listRoles", listRoles);
		
		
		List<Fmie> fmieList = fmieService.getFmies();	
		model.addAttribute("fmies", fmieList);
		
		
	}
	
	@Autowired
	private UserRepositories userRepository;
	

	
	@RequestMapping("/switch")
	public String swtheee(Model model,Principal principal) {
		model.addAttribute("title","C|And|F - Switch");
		
		return "faculty/switch";	
	}
	@RequestMapping("/switchfeedback1/{id}")
	public String swthe(@PathVariable("id") int id,Model model,HttpSession session,Principal principal) {
		try {
		model.addAttribute("title","C|And|F - Switch");
		Switcch switcch = swichRepo.findById(id).get();
		Switcch switcch2 = swichRepo.findById(2).get();
		if(switcch.getIdswitcch().equals(0)) {
			switcch.setIdswitcch(1);
			switcch2.setIdswitcch(0);
			this.swichRepo.save(switcch);
			this.swichRepo.save(switcch2);
			session.setAttribute("message", new Message("Successfully FeedBack System On  !!","alert-success"));
		}else {
			switcch.setIdswitcch(0);
			switcch2.setIdswitcch(0);
			this.swichRepo.save(switcch);
			this.swichRepo.save(switcch2);
			session.setAttribute("message", new Message("Successfully FeedBack System Off  !!","alert-success"));
		}
		
		return "redirect:/div/switch";	
		} catch(Exception e) {
			e.printStackTrace(); 
			session.setAttribute("message", new Message("Somthing Went wrong !!"+e.getMessage(),"alert-danger"));
			return "faculty/index";
		}
	}
	
	@RequestMapping("/switchfeedback2/{id}")
	public String swthe2(@PathVariable("id") int id,Model model,HttpSession session,Principal principal) {
		try {
		model.addAttribute("title","C|And|F - Switch");
		Switcch switcch2 = swichRepo.findById(id).get();
		
		if(switcch2.getIdswitcch().equals(0)) {
			switcch2.setIdswitcch(1);
			 
			this.swichRepo.save(switcch2);
			session.setAttribute("message", new Message("Successfully FeedBack Requester On  !!","alert-success"));
		}else {
			switcch2.setIdswitcch(0);
			
			this.swichRepo.save(switcch2);
			session.setAttribute("message", new Message("Successfully FeedBack Requester Off  !!","alert-success"));
		}
		
		return "redirect:/div/switch";
		} catch(Exception e) {
			e.printStackTrace(); 
			session.setAttribute("message", new Message("Somthing Went wrong !!"+e.getMessage(),"alert-danger"));
			return "faculty/index";
		}
	}
	
	
	
	
	
	
	
	@RequestMapping("/switchPerformance1/{id}")
	public String swthe3(@PathVariable("id") int id,Model model,HttpSession session,Principal principal) {
		try {
		model.addAttribute("title","C|And|F - Switch");
		Switcch switcch = swichRepo.findById(id).get();
		Switcch switcch2 = swichRepo.findById(4).get();
		if(switcch.getIdswitcch().equals(0)) {
			switcch.setIdswitcch(1);
			switcch2.setIdswitcch(0);
			this.swichRepo.save(switcch);
			this.swichRepo.save(switcch2);
			session.setAttribute("message", new Message("Successfully Performance  System On  !!","alert-success"));
		}else {
			switcch.setIdswitcch(0);
			switcch2.setIdswitcch(0);
			this.swichRepo.save(switcch);
			this.swichRepo.save(switcch2);
			session.setAttribute("message", new Message("Successfully Performance  System Off  !!","alert-success"));
		}
		
		return "redirect:/div/switch";	
		} catch(Exception e) {
			e.printStackTrace(); 
			session.setAttribute("message", new Message("Somthing Went wrong !!"+e.getMessage(),"alert-danger"));
			return "faculty/index";
		}
	}
	
	@RequestMapping("/switchPerformance2/{id}")
	public String swthe4(@PathVariable("id") int id,Model model,HttpSession session,Principal principal) {
		try {
		model.addAttribute("title","C|And|F - Switch");
		Switcch switcch2 = swichRepo.findById(id).get();
		
		if(switcch2.getIdswitcch().equals(0)) {
			switcch2.setIdswitcch(1);
			 
			this.swichRepo.save(switcch2);
			session.setAttribute("message", new Message("Successfully Performance Evaluator On  !!","alert-success"));
		}else {
			switcch2.setIdswitcch(0);
			
			this.swichRepo.save(switcch2);
			session.setAttribute("message", new Message("Successfully Performance Evaluator Off  !!","alert-success"));
		}
		
		return "redirect:/div/switch";	
		} catch(Exception e) {
			e.printStackTrace(); 
			session.setAttribute("message", new Message("Somthing Went wrong !!"+e.getMessage(),"alert-danger"));
			return "faculty/index";
		}
	}
	
	
	
	
	
	
	
	
	
	@RequestMapping("/register")
	public String rigistrrr(Model model,Principal principal,HttpSession session) {
		try {
		model.addAttribute("title","C|And|F - Register");
		/* model.addAttribute("user", new User()); */
		
		return "faculty/rigister";
		} catch(Exception e) {
			e.printStackTrace(); 
			session.setAttribute("message", new Message("Somthing Went wrong !!"+e.getMessage(),"alert-danger"));
			return "faculty/index";
		}
	}
	
	// handler for registering user
		@RequestMapping(value="/do_register",method=RequestMethod.POST)
		public String registerUser(@Valid @ModelAttribute("user")User user,BindingResult result1,
				@RequestParam(value="agreement",defaultValue="false") boolean agreement,Model model,HttpSession session) {
			
			
			try {
				if(!agreement) {
					System.out.println("You have not agreed the terms and conditions");
				    throw new Exception("You have not agreed the terms and conditions");
				}
				
				if(result1.hasErrors()) {
					System.out.println("ERROR "+result1.toString());
					 model.addAttribute("user",user); 
					return "faculty/rigister";
				}


				Integer maxId = this.userRepository.getMaxId();
				int iddd= maxId+1; 
				user.setId(iddd);
				 
				user.setEnabled(true);
				user.setEmail("");
				user.setAbout("");
				user.setImageUrl("");
				user.setSignature("");
				user.setAddress("");
				user.setPhone("");
				user.setPassword(passwordEncoder.encode(user.getPassword()));
				
				User result=this.userRepository.save(user); 
				model.addAttribute("user", new User());
				session.setAttribute("message", new Message("Successfully Registered don !!","alert-success"));
				return"faculty/rigister";
				
				
			} catch(Exception e) {
				e.printStackTrace();
				model.addAttribute("user",user);
				session.setAttribute("message", new Message("Somthing Went wrong !!"+e.getMessage(),"alert-danger"));
				return"faculty/rigister";
			}
			
			
		}
	
	//show admin table
	
		@RequestMapping("/showAdmin")
		public String showAdmin(Model model, Principal principal,HttpSession session) {
			try {	
			model.addAttribute("title","C|And|F - Show Admin");
			
			
			List<User> findAll = this.userRepository.findAllExeptAdmin();
			model.addAttribute("userss",findAll);
			
			return "faculty/show_Admin";
			} catch(Exception e) {
				e.printStackTrace(); 
				session.setAttribute("message", new Message("Somthing Went wrong !!"+e.getMessage(),"alert-danger"));
				return "faculty/index";
			}
		}
	
	
	
		//showing perticular admin detailes.		
				@RequestMapping("/{id}/userd")
				public String showConsoutDetaill(@PathVariable("id") int id,
						Model model,Principal principal,HttpSession session) {										
					try {
					model.addAttribute("title","C|And|F - Spesific Admin");
					    
					    
					    Optional<User> useroutOptional = this.userRepository.findById(id);
						User userd = useroutOptional.get();
						
						model.addAttribute("userd", userd);
					
					return "faculty/admin_detail";
					} catch(Exception e) {
						e.printStackTrace(); 
						session.setAttribute("message", new Message("Somthing Went wrong !!"+e.getMessage(),"alert-danger"));
						return "faculty/index";
					}
				}
	
	
				//update form handler
				@PostMapping("/update-userd/{id}")
				public String updateFormcorss(@PathVariable("id") int id, Model model,HttpSession session) {
					try {
					model.addAttribute("title","C|And|F - Update Admin");
					    Optional<User> optional = userRepository.findById(id);
					    User user = optional.get();
						model.addAttribute("userdu", user);
					return "faculty/update-admin";
					} catch(Exception e) {
						e.printStackTrace(); 
						session.setAttribute("message", new Message("Somthing Went wrong !!"+e.getMessage(),"alert-danger"));
						return "faculty/index";
					}
				}
				
				
				// update admin handler
				@RequestMapping(value = "/processd-updateeAdmin", method = RequestMethod.POST)
				public String updateHandlerr(@ModelAttribute User user, 
						Model m, HttpSession session) {

					try {

						
						  user.setPassword(passwordEncoder.encode(user.getPassword()));
						  
						 
						this.userRepository.save(user);


						session.setAttribute("message", new Message("Your contact is updated...", "alert-success"));

					} catch (Exception e) {
						e.printStackTrace();
					}
					
					
					return "redirect:/div/" + user.getId() + "/userd";
				}	
	
	
				//delete admin handler
				@GetMapping("/delete/{id}")
				public String deleteAdmin(@PathVariable("id") int id,Model model,HttpSession session,Principal principal) {
					try {
					userRepository.deleteById(id);
					
					
					//contact.setUser(null);		
					//this.contactRepository.delete(contact);
					
					///message....
					session.setAttribute("message", new Message("Successfully Deleted  !!","alert-success"));
					
					return "redirect:/div/showAdmin";
					} catch(Exception e) {
						e.printStackTrace(); 
						session.setAttribute("message", new Message("Somthing Went wrong !!"+e.getMessage(),"alert-danger"));
						return "faculty/index";
					}
				}
				
				//approve handler
				@GetMapping("/desebl/{id}")
				public String deseblAdmin(@PathVariable("id") int id,Model model,HttpSession session,Principal principal) {
					try {
					Optional<User> optional = userRepository.findById(id);
				    User user = optional.get();
					
					user.setEnabled(false);
					this.userRepository.save(user);
					
					
					//contact.setUser(null);		
					//this.contactRepository.delete(contact);
					
					///message....
					session.setAttribute("message", new Message("Successfully Disabled  !!","alert-success"));
					
					return "redirect:/div/showAdmin";
					} catch(Exception e) {
						e.printStackTrace(); 
						session.setAttribute("message", new Message("Somthing Went wrong !!"+e.getMessage(),"alert-danger"));
						return "faculty/index";
					}
				}
				@GetMapping("/enabl/{id}")
				public String enebleAdmin(@PathVariable("id") int id,Model model,HttpSession session,Principal principal) {
					try {
					Optional<User> optional = userRepository.findById(id);
				    User user = optional.get();
					
					user.setEnabled(true);
					this.userRepository.save(user);
					
					
					//contact.setUser(null);		
					//this.contactRepository.delete(contact);
					
					///message....
					session.setAttribute("message", new Message("Successfully Enabled  !!","alert-success"));
					
					return "redirect:/div/showAdmin";
					} catch(Exception e) {
						e.printStackTrace(); 
						session.setAttribute("message", new Message("Somthing Went wrong !!"+e.getMessage(),"alert-danger"));
						return "faculty/index";
					}
				}
				
				
				///chenge passsword
				
				 //open setting handeler
			    
			    @GetMapping("/settings")
			    public String openSettings(Model m,HttpSession session) {
			    	try {
			    	m.addAttribute("title", "Settings");
			    	return "faculty/settings";
			    	} catch(Exception e) {
						e.printStackTrace(); 
						session.setAttribute("message", new Message("Somthing Went wrong !!"+e.getMessage(),"alert-danger"));
						return "faculty/index";
					}
			    }
			    
			    //change password....handler
			    @PostMapping("/change-password")
			    public String changePassword(@RequestParam("oldPassword") String oldPassword,@RequestParam("newPassword") String newPassword,Principal principal,HttpSession session) {					
			    	try {
			    	String userName=principal.getName();
					User currentUser=this.userRepository.getUserByUserName(userName);										
					if(this.passwordEncoder.matches(oldPassword, currentUser.getPassword())) {
						//change the password
						currentUser.setPassword(this.passwordEncoder.encode(newPassword));
						this.userRepository.save(currentUser);
						//message success...........
					    session.setAttribute("message", new Message("Successfully Password changed  !!","alert-success"));
					}else {
						//message error.............
						session.setAttribute("message", new Message("Old password wrong !!","alert-danger"));
						return "redirect:/div/settings";
					}
					
			    	return "redirect:/div/settings";
			    	} catch(Exception e) {
						e.printStackTrace(); 
						session.setAttribute("message", new Message("Somthing Went wrong !!"+e.getMessage(),"alert-danger"));
						return "faculty/index";
					}
			    }
			    
			    
			    //your profile handler for dashboard
			    @GetMapping("/profile")
			    public String yourProfile(Model model,Principal principal,HttpSession session){
			    	try {
			        model.addAttribute("title", "profile");
			        
			        String userName=principal.getName();
					User userd = userRepository.getUserByUserName(userName);
					
					model.addAttribute("userd", userd);
			    	return "faculty/profile";
			    	} catch(Exception e) {
						e.printStackTrace(); 
						session.setAttribute("message", new Message("Somthing Went wrong !!"+e.getMessage(),"alert-danger"));
						return "faculty/index";
					}
			    }
			    
			 // update admin handler
				@RequestMapping(value = "/processd-updatUserSaid", method = RequestMethod.POST)
				public String updateHandleUserSide(@ModelAttribute User user, 
						Model m, HttpSession session) {

					try {

						
						user.setEnabled(true);
						this.userRepository.save(user);


						session.setAttribute("message", new Message("Your contact is updated...", "alert-success"));

					} catch(Exception e) {
						e.printStackTrace(); 
						session.setAttribute("message", new Message("Somthing Went wrong !!"+e.getMessage(),"alert-danger"));
						return "faculty/index";
					}
					
					
					return "redirect:/div/profile";
				}	

				
				
}
