package com.mvc.controller;

import java.util.Optional;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.mvc.entity.User;
import com.mvc.service.UserService;

@RestController
@RequestMapping("/users")
public class UserController{
	
	private UserService userService;
	
	public UserController(UserService userService) {
		this.userService = userService;
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<String> getUserName(@PathVariable int id){
		String name = userService.getUserName(id);
		if("Unknown User" .equals(name)) {
			return ResponseEntity.notFound().build();  //404
		}
		return ResponseEntity.ok(name); //200
	}
	
	@PostMapping
	public ResponseEntity<User> create(@RequestBody User user){
		User created = userService.createUser(user);
		return ResponseEntity.status(201).body(created);
	}
	
	@PutMapping("{/id}")
	public ResponseEntity<User> update(@PathVariable int id , @RequestBody User user){
		
		Optional<User> result = userService.updateUser(user , id);
		
		return result.map(ResponseEntity::ok)
					.orElseGet(()-> ResponseEntity.notFound().build());
		
		
		
	} 
	@DeleteMapping("{/id}")
	public ResponseEntity<?> delete(@PathVariable int id) {
		boolean result =userService.deleteUser(id);
		return result ? ResponseEntity.noContent().build() : ResponseEntity.notFound().build();
		
	}
	
}
