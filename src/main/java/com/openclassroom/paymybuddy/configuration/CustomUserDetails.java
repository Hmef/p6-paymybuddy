package com.openclassroom.paymybuddy.configuration;


import java.util.Collection;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import com.openclassroom.paymybuddy.model.User;


public class CustomUserDetails implements UserDetails{
	
	

	private static final long serialVersionUID = -6040192883752441637L;
	
	
	private User user;
	
	
	public CustomUserDetails(User user) {
		
		this.user = user;
	}


	/*
	public User getUser() {
		
		return user;
	}
	
	
	
	public void setUser(User user) {
		
		this.user = user;
	}
	
	*/
	
	public Collection<? extends GrantedAuthority> getAuthorities() {
		
		return null;
	}

	
	@Override
	public String getPassword() {
		
		return user.getPassword();
	}

	@Override
	public String getUsername() {
		
		return user.getEmail();
	}
	
	
	public String getFirstName() {
		
		return user.getFirstname();
	}
	

	@Override
	public boolean isAccountNonExpired() {
		
		return true;
	}

	@Override
	public boolean isAccountNonLocked() {
		
		return true;
	}

	@Override
	public boolean isCredentialsNonExpired() {
		
		return true;
	}

	@Override
	public boolean isEnabled() {
		
		return user.getActive() == 1;
		

	}

}

