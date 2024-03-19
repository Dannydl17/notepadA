package com.notepadApp.notepad.services;

import com.notepadApp.notepad.data.models.NotePad;
import com.notepadApp.notepad.data.repository.UserRepository;
import com.notepadApp.notepad.dtos.requests.UserRegisterRequest;
import com.notepadApp.notepad.dtos.responses.UserRegistrationResponse;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

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
    public void testThatUserCanRegisterTest(){
        UserRegisterRequest request = new UserRegisterRequest();
        request.setUsername("Danny");
        request.setPassword("1234");

        UserRegistrationResponse response = userService.register(request);
        assertNotNull(response);
        assertNotNull(response.getId());
    }

    @Test
    public void testThatUserCanWriteTest(){
        UserRegisterRequest request = new UserRegisterRequest();
        request.setUsername("Danny");
        request.setPassword("1234");

        UserRegistrationResponse response = userService.register(request);
        assertNotNull(response);
        assertNotNull(response.getId());

        userService.write(response.getId(), response.getNotepad(), "My first day at school", "Body");

        NotePad notePad = userService.getNotepad(response.getId(), response.getNotepad());
        assertEquals(notePad.getEntries().size(), 1);
    }
    @Test
    public void testThatUserCanDeleteTest(){
        UserRegisterRequest request = new UserRegisterRequest();
        request.setUsername("Danny");
        request.setPassword("1234");

        UserRegistrationResponse response = userService.register(request);
        assertNotNull(response);
        assertNotNull(response.getId());

        userService.write(response.getId(), response.getNotepad(), "My first day at school", "Body");
        NotePad notePad = userService.getNotepad(response.getId(), response.getNotepad());
        assertEquals(notePad.getEntries().size(), 1);

        userService.write(response.getId(), response.getNotepad(), "My first day at church", "Monday");
        NotePad notePadOne = userService.getNotepad(response.getId(), response.getNotepad());
        assertEquals(notePadOne.getEntries().size(),2);

        userService.delete(response.getId(), response.getNotepad(), "My first day at church", "Monday");
        NotePad notePadDeleted = userService.getNotepad(response.getId(), response.getNotepad());
        assertEquals(notePadDeleted.getEntries().size(),1);
    }
}
