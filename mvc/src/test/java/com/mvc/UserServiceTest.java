package com.mvc;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.util.Optional;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import com.mvc.entity.User;
import com.mvc.repository.UserRepository;
import com.mvc.service.UserService;

@ExtendWith(MockitoExtension.class)
public class UserServiceTest {
	@Mock
	private UserRepository repository;
	
	@InjectMocks
	private UserService service;
	
	@Test
	void testGetUserName_found() {
		when(repository.findById(1)).thenReturn(Optional.of(new User(1,"Alice")));
		String name = service.getUsername(1);
		assertEquals("Alice" , name);
		verify(repository , times(1)).findById(1);
		
	}
	
}
