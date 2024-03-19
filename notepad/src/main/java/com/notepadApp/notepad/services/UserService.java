package com.notepadApp.notepad.services;

import com.notepadApp.notepad.data.models.NotePad;
import com.notepadApp.notepad.dtos.requests.UserRegisterRequest;
import com.notepadApp.notepad.dtos.responses.UserRegistrationResponse;

public interface UserService {
    UserRegistrationResponse register(UserRegisterRequest request);

    void write(Long id, Long notepad, String title, String body);

    NotePad getNotepad(Long id, Long findNotePadId);

    void delete(Long id, Long notepad, String title, String body);
}
