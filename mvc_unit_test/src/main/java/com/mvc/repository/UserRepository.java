package com.mvc.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.mvc.entity.User;

public interface UserRepository extends JpaRepository<User, Integer>{
	Optional<User> findById(int id);
	User save(User user);
	void deleteById(int id);
	List<User> findAll(); 
}	
