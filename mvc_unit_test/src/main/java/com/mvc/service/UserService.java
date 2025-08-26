package com.mvc.service;

import com.mvc.repository.UserRepository;
import com.mvc.entity.User;

import java.util.List;
import java.util.Optional;

public class UserService {
	
	private final UserRepository userRepository;
	
	public UserService(UserRepository userRepository) {
		this.userRepository = userRepository;
	}

	public String getUserName(int id){
		return userRepository.findById(id)
				.map(user -> user.getName())
				.orElse("Unknown User");
	}

	public User createUser(User user){
		return userRepository.save(user);
	}
	public Optional<User> updateUser(User user, int id){
		return userRepository.findById(id).map(existing -> userRepository.save(new User(id ,user.getName())));
	}

	public boolean deleteUser(int id){
		if(userRepository.findById(id).isPresent()) {
			userRepository.deleteById(id);
			return true;
		}
		return false;
	}
	
	public List<User> findAllUser(){
		return userRepository.findAll();
		
	}
	
	
}
