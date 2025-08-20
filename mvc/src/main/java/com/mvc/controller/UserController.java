package com.mvc.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.mvc.service.UserService;

@RestController
@RequestMapping("/users")
public class UserController {

	private final UserService userService;
	
	public UserController(UserService userService){
		this.userService = userService;
	}
	@GetMapping("/{id}")
	public String getUserName(@PathVariable int id) {
		return userService.getUsername(id);
	}
	
	
}
