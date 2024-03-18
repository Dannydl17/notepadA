package com.notepadApp.notepad.services;

import com.notepadApp.notepad.data.models.NotePad;
import com.notepadApp.notepad.data.models.User;
import com.notepadApp.notepad.data.repository.UserRepository;
import com.notepadApp.notepad.dtos.requests.UserRegisterRequest;
import com.notepadApp.notepad.dtos.responses.UserRegistrationResponse;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class AppUserService implements  UserService{
    private final UserRepository userRepository;
    private final NotePadService notePadService;

    @Override
    public UserRegistrationResponse register(UserRegisterRequest request) {
        User user = new User();

        user.setUsername(request.getUsername());
        user.setPassword(request.getPassword());

        User savedUser = userRepository.save(user);
        NotePad notePad = notePadService.createNotePad();
        UserRegistrationResponse response = new UserRegistrationResponse();
        response.setId(savedUser.getId());
        response.setNotepad(notePad.getId());
        return response;
    }
}
