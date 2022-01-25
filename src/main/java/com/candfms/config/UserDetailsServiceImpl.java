package com.candfms.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

import com.candfms.models.User;
import com.candfms.repositories.UserRepositories;
 

public class UserDetailsServiceImpl implements UserDetailsService{
	
	@Autowired
	private UserRepositories userRepository;

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		//fetching user from database
		User user = userRepository.getUserByUserName(username);
		
		/*
		 * if(user==null) { throw new
		 * UsernameNotFoundException("Could not found user !!"); }
		 * 
		 * CustomUserDetails customUserDetails=new CustomUserDetails(user); return
		 * customUserDetails;
		 */
		
		 if(user != null && user.isEnabled()) {//here you can check that
			 CustomUserDetails customUserDetails=new CustomUserDetails(user);
				return customUserDetails;
         } 

         else {
             throw new UsernameNotFoundException("username not found");
         }
	}
	
	
	

}
