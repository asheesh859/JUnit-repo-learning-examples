package com.mvc;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import com.mvc.controller.UserController;
import com.mvc.service.UserService;

@ExtendWith(MockitoExtension.class)
 class UserControllerTest {

	@Mock
	private UserService mockService;
	
	@InjectMocks
	private UserController controller;
	
	@Test
	void testGetUserName_found() {
		when(mockService.getUsername(1)).thenReturn("Alice");
		
		assertEquals("Alice" , controller.getUserName(1));
		verify(mockService , times(1)).getUsername(1);
	}
	
	@Test
	void testGetUserName_NotFound() {
		when(mockService.getUsername(2)).thenReturn("Unknown User");
		assertEquals("Unknown user" , controller.getUserName(2));
		verify(mockService , times(1)).getUsername(2);
	}
	
}
