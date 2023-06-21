package com.openclassroom.paymybuddy.configuration;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;

@Configuration
@EnableWebSecurity
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {

	
	@Autowired
	private CustomUserDetailsService customUsersDetailss;
	
	

	@Override
	protected void configure(AuthenticationManagerBuilder auth) throws Exception {
		
		auth.userDetailsService(customUsersDetailss).passwordEncoder(passwordEncoder());
		
		
	}
	
	@Override
	public void configure(HttpSecurity http) throws Exception {
		
		
		http
			.authorizeHttpRequests()
			.antMatchers("/login", "/logOff").permitAll() // à modifier après, pour accéder à tous les pages, l'utilisateur doit sse connecter 
			.anyRequest().authenticated()
			.and()
			.formLogin()
			.defaultSuccessUrl("/profil")
			.loginPage("/login")
			.usernameParameter("email")
			.passwordParameter("password")
			.and()
			.logout()
			.logoutRequestMatcher(new AntPathRequestMatcher("/logout"))
			.logoutSuccessUrl("/login")
			.and()
			.rememberMe().tokenValiditySeconds(30000).key("WhatEver!")
			.rememberMeParameter("checkRememberMe");


	}
	
	/*
	
	@Bean
	public UserDetailsService userDetailsService() {
		
		return new CustomUserDetailsService();
	}
	
	*/
	
	@Bean
	public PasswordEncoder passwordEncoder() {
		
		return new BCryptPasswordEncoder();
	}
	
	
	//  testSecurity@gmail.com
	// pwd :  testSecurity@gmail.com
	
	
	
	
	
}
