package com.notepadApp.notepad.dtos.requests;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class UserRegistrationRequest {
    private String email;
    private String password;
}
