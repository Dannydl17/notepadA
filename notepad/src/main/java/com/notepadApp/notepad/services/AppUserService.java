package com.notepadApp.notepad.services;

import com.notepadApp.notepad.data.models.User;
import com.notepadApp.notepad.data.repository.UserRepository;
import com.notepadApp.notepad.dtos.requests.UserLoginRequest;
import com.notepadApp.notepad.dtos.requests.UserRegistrationRequest;
import com.notepadApp.notepad.dtos.responses.LoginResponse;
import com.notepadApp.notepad.dtos.responses.UserRegistrationResponse;
import com.notepadApp.notepad.exceptions.InvalidUserEmailException;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class AppUserService implements  UserService{
    private final UserRepository userRepository;
    @Override
    public UserRegistrationResponse register(UserRegistrationRequest request) {
        User user = new User();

        user.setEmail(request.getEmail());
        user.setPassWord(request.getPassword());

        userRepository.save(user);
        User savedUser = userRepository.save(user);

        UserRegistrationResponse response = new UserRegistrationResponse();
        response.setId(savedUser.getId());
        return response;
    }

    @Override
    public LoginResponse login(UserLoginRequest loginRequest) {
         LoginResponse response = new LoginResponse();
           List<User> user = userRepository.findAll();
            if (user.equals(loginRequest.getEmail())) {
                response.setMessage("You have successfully login");
                return response;
            }
            throw new InvalidUserEmailException("Email incorrect");
        }
//           User user = userRepository.findByEmail(loginRequest.getEmail());

    }
}
