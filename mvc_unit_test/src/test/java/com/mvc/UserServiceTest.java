package com.mvc;

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
    void getUserName_NotFound() {
        when(userRepository.findById(1)).thenReturn(Optional.of(new User(1, "John Doe")));
        String result = userService.getUserName(1);
        assert("John Doe" .equals(result));
        verify(userRepository , times(1)).findById(1);
    }

    
}
