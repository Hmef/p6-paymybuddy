package com.openclassroom.paymybuddy.service;

import java.util.Optional;

import org.springframework.data.domain.Page;

import com.openclassroom.paymybuddy.model.User;

public interface UserService {

	Iterable<User> getUsers();
	
	Optional<User> getUserById(long id);
	
	void saveUser(User user);
	
	void deleteUser(long userId);
	
	void updateUser(User user);
	
	User findByEmail(String email);
	
	Page<User> findPaginated(int pageNO, int pageSize);
	
}
