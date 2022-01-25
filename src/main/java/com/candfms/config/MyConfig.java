package com.candfms.config;


import java.nio.file.Path;
import java.nio.file.Paths;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;

@Configuration
@EnableWebSecurity
public class MyConfig extends WebSecurityConfigurerAdapter {
	
	
	
	@Bean
	public UserDetailsService getUserDetailService() {
		return new UserDetailsServiceImpl();
	}
	@Bean
	public BCryptPasswordEncoder passwordEncoder() {
		return new BCryptPasswordEncoder();
	}
	
	@Autowired
	private LoginSuccessHandler successHandler;
	
	@Bean
	public DaoAuthenticationProvider authenticationProvider() {
		DaoAuthenticationProvider daoAuthenticationProvider=new DaoAuthenticationProvider();
		daoAuthenticationProvider.setUserDetailsService(this.getUserDetailService());
		daoAuthenticationProvider.setPasswordEncoder(passwordEncoder());
		
		return daoAuthenticationProvider;
	}
	
	///configure method
	
	@Override
	protected void configure(AuthenticationManagerBuilder auth) throws Exception {
		auth.authenticationProvider(authenticationProvider());
		
	}
	@Override
	protected void configure(HttpSecurity http) throws Exception {
		http.authorizeRequests()
		
		//.antMatchers("/user/**").hasAnyAuthority("USER")
		
		//.antMatchers("/user/add-contact/**").hasAuthority("COURSE_CHAIR")
		
		.antMatchers("/div/**").hasAnyAuthority("INSTRUCTOR,ADMIN,CHAIR_HOLDER,COURSE_CHAIR,STUDENT,APO,ADVISOR,ASSISTANT,QUALITY,DEAN")
		.antMatchers("/faculty/**").hasAnyAuthority("INSTRUCTOR,ADMIN,CHAIR_HOLDER,COURSE_CHAIR,STUDENT,APO,ADVISOR,ASSISTANT,QUALITY,DEAN")
		.antMatchers("/request/**").hasAnyAuthority("INSTRUCTOR,ADMIN,CHAIR_HOLDER,COURSE_CHAIR,STUDENT,APO,ADVISOR,ASSISTANT,QUALITY,DEAN")
		.antMatchers("/order/**").hasAnyAuthority("INSTRUCTOR,ADMIN,CHAIR_HOLDER,COURSE_CHAIR,STUDENT,APO,ADVISOR,ASSISTANT,QUALITY,DEAN")
		.antMatchers("/performco/**").hasAnyAuthority("INSTRUCTOR,ADMIN,CHAIR_HOLDER,COURSE_CHAIR,STUDENT,APO,ADVISOR,ASSISTANT,QUALITY,DEAN")
		.antMatchers("/orderStu/**").hasAnyAuthority("INSTRUCTOR,ADMIN,CHAIR_HOLDER,COURSE_CHAIR,STUDENT,APO,ADVISOR,ASSISTANT,QUALITY,DEAN")
		.antMatchers("/orderLab/**").hasAnyAuthority("INSTRUCTOR,ADMIN,CHAIR_HOLDER,COURSE_CHAIR,STUDENT,APO,ADVISOR,ASSISTANT,QUALITY,DEAN")
		.antMatchers("/assign/**").hasAnyAuthority("INSTRUCTOR,ADMIN,CHAIR_HOLDER,COURSE_CHAIR,STUDENT,APO,ADVISOR,ASSISTANT,QUALITY,DEAN")
		.antMatchers("/qualiity/**").hasAnyAuthority("INSTRUCTOR,ADMIN,CHAIR_HOLDER,COURSE_CHAIR,STUDENT,APO,ADVISOR,ASSISTANT,QUALITY,DEAN")
		.antMatchers("/post/**").hasAnyAuthority("INSTRUCTOR,ADMIN,CHAIR_HOLDER,COURSE_CHAIR,STUDENT,APO,ADVISOR,ASSISTANT,QUALITY,DEAN")
		
		//.antMatchers("/student/**").hasRole("LECTURE,DIV")
		//.antMatchers("/div/**").hasRole("LECTURE")
		
		//.antMatchers("/admin/**").hasRole("ADMIN")
		.antMatchers("/student/**").hasAnyAuthority("INSTRUCTOR,ADMIN,CHAIR_HOLDER,APO,ADVISOR,STUDENT,QUALITY,DEAN")
		
		//.antMatchers("/admin/**").hasRole("ADMIN")
		
		.antMatchers("/**").permitAll().and().formLogin()
		.loginPage("/signin")
		.loginProcessingUrl("/dologin")
		.successHandler(successHandler)
		.and().csrf().disable()
		.exceptionHandling().accessDeniedPage("/user/403")
		.and();
		//.rememberMe().tokenValiditySeconds(2592000).key("mySecret!");
		
	}
	
	

}
