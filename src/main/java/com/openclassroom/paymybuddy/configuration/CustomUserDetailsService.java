package com.openclassroom.paymybuddy.configuration;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.openclassroom.paymybuddy.Repository.UserRepository;
import com.openclassroom.paymybuddy.model.User;


@Service
public class CustomUserDetailsService implements UserDetailsService {

	@Autowired
	private UserRepository userReository;

	//private final static String USER_NOT_FOUND_MSG = "user with email %s not found";

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		
		
		User user = userReository.findByEmail(username);
		CustomUserDetails userPrincipal = new CustomUserDetails(user);
		
		
		return userPrincipal;
		
	}

}
