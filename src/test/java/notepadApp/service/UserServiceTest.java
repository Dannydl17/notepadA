package notepadApp.service;

import notepadApp.data.models.NotePad;
import notepadApp.data.repository.UserRepository;
import notepadApp.dtos.requests.UserRegisterRequest;
import notepadApp.dtos.responses.UserRegistrationResponse;
import notepadApp.services.AppNotePadService;
import notepadApp.services.AppUserService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

@SpringBootTest
public class UserServiceTest {
    @Autowired
    private AppUserService userService;
    @Autowired
    private AppNotePadService notePadService;
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

         userService.write("Danny", "My first day at school", "I am in the class-room writing");
//        System.out.println(notePad.getEntries().size());
        assertEquals(1, userService.getNotepad(1L,1L).getEntries().size());
    }

    @Test
    public void testThatUserCanDeleteTest(){
        UserRegisterRequest request = new UserRegisterRequest();
        request.setUsername("Danny");
        request.setPassword("1234");

        UserRegistrationResponse response = userService.register(request);
        assertNotNull(response);
        assertNotNull(response.getId());


//        NotePad notePad = userService.write("Danny", "My first day at school", "I am in the class-room writing");
//        assertEquals(1, notePad.getEntries().size());
//        userService.write("Danny", "My first day at school", "I am in the class-room");
//        assertEquals(2, );




//        userService.delete(response.getId(), response.getNotepad(), "My first day at church", "Monday");
//        NotePad notePadDeleted = userService.getNotepad(response.getId(), response.getNotepad());
//        assertEquals(notePadDeleted.getEntries().size(),1);
    }


}
