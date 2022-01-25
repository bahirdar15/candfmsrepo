package com.candfms.controller;

import java.security.Principal;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.Optional;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.candfms.helper.Message;
import com.candfms.models.User;
import com.candfms.models.Fmie;
import com.candfms.models.Post;
import com.candfms.models.Switcch;
import com.candfms.repositories.CoursoutRepository;
import com.candfms.repositories.PostRepository;
import com.candfms.repositories.SwitcchRepository;
import com.candfms.repositories.UserRepositories;
import com.candfms.service.FmieService;

@Controller
@RequestMapping("/post")
public class PostController {

	@Autowired
	private FmieService fmieService;
	
	@Autowired
	private CoursoutRepository coursoutRepository;
	
	@Autowired
	private PostRepository postRepo;
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
	
	
	
		@RequestMapping("/postShow")
		public String post(Model model,HttpSession session) {
			model.addAttribute("title","C|And|F - Post");					
			try {
					List<Post> findAllPost = this.postRepo.findAllPost1();
					model.addAttribute("allPost", findAllPost);	
	    
				return "faculty/post";
				} catch(Exception e) {
					e.printStackTrace(); 
					session.setAttribute("message", new Message("Somthing Went wrong !!"+e.getMessage(),"alert-danger"));
					return "faculty/index";
				}
		}
		
		@PostMapping("/process-addpost")
		public String processPost(@ModelAttribute  Post post,Model model,Principal principal,HttpSession session) {			 
			try { 
				DateTimeFormatter dtf = DateTimeFormatter.ofPattern("dd/MM/yyyy");
				LocalDateTime now = LocalDateTime.now();
				
				post.setPostdate(dtf.format(now));
				this.postRepo.save(post); 
				
			//message success...........
				session.setAttribute("message", new Message("Successfully Add New Post  !!","alert-success"));	    
				
			}catch(Exception e) {
				System.out.println("ERROR"+e.getMessage());
				e.printStackTrace(); 
				session.setAttribute("message", new Message("Somthing Went wrong !!"+e.getMessage(),"alert-danger"));
				
			} 
			return "redirect:/post/postShow";
		    
		}
	
		//delete contact handler
				@GetMapping("/delete/{pid}")
				public String deleteCoursout(@PathVariable("pid") Integer pid,Model model,HttpSession session, 
						Principal principal) {
					try {
						 Post post2 = this.postRepo.findById(pid).get(); 
		                 this.postRepo.delete(post2);
					         
					///message....
					session.setAttribute("message", new Message("Successfully Deleted  !!","alert-success"));
					
					return "redirect:/post/postShow";
					} catch(Exception e) {
						e.printStackTrace(); 
						session.setAttribute("message", new Message("Somthing Went wrong !!"+e.getMessage(),"alert-danger"));
						return "faculty/index";
					}
				}
}
