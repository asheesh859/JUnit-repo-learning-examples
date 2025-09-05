package com.mvc;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.never;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.util.Optional;

import com.mvc.entity.User;
import com.mvc.repository.*;
import com.mvc.service.*;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

@ExtendWith(MockitoExtension.class)
class UserServiceTest {

    @Mock
    private UserRepository userRepository;

    @InjectMocks
    private UserService userService;

    
    @Test
    void getUserName_Found() {
        when(userRepository.findById(1)).thenReturn(Optional.of(new User(1, "John Doe")));
        String result = userService.getUserName(1);
        assert("John Doe" .equals(result));
        verify(userRepository , times(1)).findById(1);
    }
    
   
    @Test
    void getUserName_NotFound() {
    	when(userRepository.findById(99)).thenReturn(Optional.empty());
    	String result = userService.getUserName(99);
    	assertEquals("unknown user" , result);
    	
    	verify(userRepository , times(1)).findById(99);	
    	
    }

    @Test
    void createUser_saves() {
    	
    	User input = new User(10,"Bob");
    	when(userRepository.save(any(User.class))).thenReturn(input);
    	User saved = userService.createUser(input);
    	assertEquals("Bob" , saved.getName());	
    	verify(userRepository).save(input);
    }
    
    @Test
    void upateUser_notFound() {
    	when(userRepository.findById(6)).thenReturn(Optional.empty());
    	var result = userService.updateUser(6, new User(6,"X"));
    	assertEquals(false,result.isPresent());
    	verify(userRepository).findById(6);
    	verify(userRepository , never()).save(any());
    	
    }
    
}
