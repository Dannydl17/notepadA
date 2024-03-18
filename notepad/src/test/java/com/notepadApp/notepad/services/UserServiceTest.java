package com.notepadApp.notepad.services;
import com.notepadApp.notepad.data.repository.UserRepository;
import com.notepadApp.notepad.dtos.requests.UserLoginRequest;
import com.notepadApp.notepad.dtos.requests.UserRegistrationRequest;
import com.notepadApp.notepad.dtos.responses.LoginResponse;
import com.notepadApp.notepad.dtos.responses.UserRegistrationResponse;
import com.notepadApp.notepad.exceptions.InvalidUserEmailException;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertThrows;

@SpringBootTest
public class UserServiceTest {
    @Autowired
    private UserService userService;
    @Autowired
    private UserRepository repository;
    @BeforeEach
    public void deleteAll(){
        repository.deleteAll();
    }

    @Test
    public void testThatAUserCanRegisterTest(){
      UserRegistrationRequest request = new UserRegistrationRequest();
      request.setEmail("test@email.com");
      request.setPassword("password");

      UserRegistrationResponse response = userService.register(request);

      assertNotNull(response);
      assertNotNull(response.getId());
    }

    @Test
    public void testThatAUserCanLoginTest(){
        UserRegistrationRequest request = new UserRegistrationRequest();
        request.setEmail("test@email.com");
        request.setPassword("password");
        UserRegistrationResponse response = userService.register(request);
        assertNotNull(response);
        assertNotNull(response.getId());

      UserLoginRequest loginRequest = new UserLoginRequest();
      loginRequest.setEmail("test@email.com");
      loginRequest.setPassword("password");
      LoginResponse responseOne= userService.login(loginRequest);

      assertNotNull(responseOne);
      assertNotNull(responseOne.getMessage());
    }

    @Test
    public void testThatAUserLoginWithWrongEmailThrowExceptionTest(){
        UserRegistrationRequest request = new UserRegistrationRequest();
        request.setEmail("test@email.com");
        request.setPassword("password");

        userService.register(request);

        UserLoginRequest loginRequest = new UserLoginRequest();
        loginRequest.setEmail("danny@email.com");
        loginRequest.setPassword("password");

        assertThrows(InvalidUserEmailException.class,
                () -> userService.login(loginRequest));
    }
}
