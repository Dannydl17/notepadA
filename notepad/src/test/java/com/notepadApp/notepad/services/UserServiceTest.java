package com.notepadApp.notepad.services;
import com.notepadApp.notepad.dtos.requests.UserLoginRequest;
import com.notepadApp.notepad.dtos.requests.UserRegistrationRequest;
import com.notepadApp.notepad.dtos.responses.LoginResponse;
import com.notepadApp.notepad.dtos.responses.UserRegistrationResponse;
import com.notepadApp.notepad.exceptions.InvalidUserEmailException;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertThrows;

@SpringBootTest
public class UserServiceTest {
    @Autowired
    private UserService userService;
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
      UserLoginRequest loginRequest = new UserLoginRequest();
      loginRequest.setEmail("test@email.com");
      loginRequest.setPassword("password");
      LoginResponse response = userService.login(loginRequest);

      assertNotNull(response);
      assertNotNull(response.getMessage());
    }

    @Test
    public void testThatAUserLoginWithWrongEmailThrowExceptionTest(){
        UserLoginRequest loginRequest = new UserLoginRequest();
      loginRequest.setEmail("test@email.com");
      loginRequest.setPassword("password");
      LoginResponse response = userService.login(loginRequest);

      assertNotNull(response);
      assertNotNull(response.getMessage());

      UserLoginRequest loginRequestOne = new UserLoginRequest();
      loginRequestOne.setEmail("danny@email.com");
      loginRequestOne.setPassword("password");
//      LoginResponse responseOne = userService.login(loginRequestOne);

//        assertNotNull(responseOne.getMessage());
        assertThrows(InvalidUserEmailException.class,
                () -> userService.login(loginRequestOne));
    }

}
