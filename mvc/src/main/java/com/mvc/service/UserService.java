package com.mvc.service;

import java.util.Optional;

import com.mvc.entity.User;
import com.mvc.repository.UserRepository;

public class UserService {

	private final UserRepository repository;
	
	public UserService(UserRepository repository) {
		this.repository = repository;
	}
	public String getUserNameById(int id) {
		Optional<User> user =  repository.findById(id);
		
		if(user.isPresent()) {
			return user.get().getName();
		}else {
			return "invalid id";
		}
			
	}
}
