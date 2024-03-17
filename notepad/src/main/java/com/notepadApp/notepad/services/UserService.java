package com.notepadApp.notepad.services;

import com.notepadApp.notepad.dtos.requests.UserLoginRequest;
import com.notepadApp.notepad.dtos.requests.UserRegistrationRequest;
import com.notepadApp.notepad.dtos.responses.LoginResponse;
import com.notepadApp.notepad.dtos.responses.UserRegistrationResponse;

public interface UserService {
    UserRegistrationResponse register(UserRegistrationRequest request);

    LoginResponse login(UserLoginRequest loginRequest);
}
