package com.notepadApp.notepad.services;

import com.notepadApp.notepad.dtos.requests.UserRegisterRequest;
import com.notepadApp.notepad.dtos.responses.UserRegistrationResponse;

public interface UserService {

    UserRegistrationResponse register(UserRegisterRequest request);
}
