package com.mvc.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

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
	}
	
}
