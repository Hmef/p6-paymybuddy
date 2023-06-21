package com.openclassroom.paymybuddy.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.openclassroom.paymybuddy.Repository.UserRepository;
import com.openclassroom.paymybuddy.model.User;

@Service
public class UserServiceImpl implements UserService{

	
	@Autowired
	private UserRepository userRepository;
	
	@Autowired
	private PasswordEncoder passwordEncoder;
	

	public Iterable<User> getUsers() {

		return userRepository.findAll();

	}

	
	public Optional<User> getUserById(long id) {

		return userRepository.findById(id);

	}

	
	
	/*
	public Iterable<User> getUserByName(String lastname) {

		return userRepository.findByName(lastname);

	}
	*/

	public void saveUser(User user) {

		user.setActive(1);
		user.setPassword(passwordEncoder.encode(user.getPassword()));
		userRepository.save(user);
	}

	public void deleteUser(long userId) {

		userRepository.deleteById(userId);
	}

	@Override
	public User findByEmail(String email) {
		
		return userRepository.findByEmail(email);
	}
	
	@Override
	public void updateUser(User user) {
		
		user.setActive(1);
		user.setPassword(passwordEncoder.encode(user.getPassword()));
		userRepository.save(user);
	}

	
	@Override
	public Page<User> findPaginated(int pageNo, int pageSize) {
		
		Pageable pageable = PageRequest.of(pageNo - 1, pageSize);
		
		return this.userRepository.findAll(pageable);
	}


}
