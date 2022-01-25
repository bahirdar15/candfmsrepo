package com.candfms.controller;

import java.security.Principal;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.Optional;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.candfms.helper.Message;
import com.candfms.models.ActiLab;
import com.candfms.models.AssWeek;
import com.candfms.models.Assess;
import com.candfms.models.Chapteraf;
import com.candfms.models.Chapterbf;
import com.candfms.models.Chapterlast;
import com.candfms.models.ComLearn;
import com.candfms.models.Coursout;
import com.candfms.models.Methodo;
import com.candfms.models.Post;
import com.candfms.models.Refer;
import com.candfms.models.TabRef;
import com.candfms.models.User;
import com.candfms.models.Week;
import com.candfms.repositories.PostRepository;
import com.candfms.repositories.UserRepositories;

@Controller
public class HomeController {

	@Autowired
	private UserRepositories userRepositories;
	
	@Autowired
	private PostRepository postRepo;
	
	@RequestMapping("/")
	public String home(Model model) {
		model.addAttribute("title","C|And|F - Login");
		
		/*
		 * User user=new User(); user.setName("mohammed"); user.setEmail("d@dd");
		 * userRepositories.save(user);
		  
		 */
		
		return "login";
	}
	
	// handler for custom login
		@GetMapping("/signin")
		public String customLogin(Model model) {
			model.addAttribute("title","C|And|F - Login");
			return "login";
		}
		
		/*
		 * @GetMapping("/adi/index") public String adLogin(Model model) {
		 * model.addAttribute("title","C|And|F - index"); return "admin/index"; }
		 * 
		 * @RequestMapping("/adi/tables") public String tablea(Model model) {
		 * model.addAttribute("title","C|And|F - Table"); return "admin/tables"; }
		 */
		
		
		@GetMapping("/dd/barChart")
		public String customLoginkk(Model model) {
			model.addAttribute("title","C|And|F - Login");
			return "barChart";
		}
	
		@RequestMapping("/hello")
		public String home(HttpServletRequest request) {
		    String baseUrl = ServletUriComponentsBuilder.fromRequestUri(request)
	            .replacePath(null)
	            .build()
	            .toUriString();
	 
		    System.out.println(baseUrl);
	 
			return "home";
		}
}
