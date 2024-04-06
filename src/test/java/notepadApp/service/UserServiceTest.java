package notepadApp.service;

import notepadApp.data.models.NotePad;
import notepadApp.data.repository.UserRepository;
import notepadApp.dtos.requests.EntryCreateRequest;
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
        assertEquals(1,  userService.findByUserName("Danny").getNotePad().getEntries().size());
    }

    @Test
    public void testThatUserCanDeleteTest() {
        UserRegisterRequest request = new UserRegisterRequest();
        request.setUsername("Danny");
        request.setPassword("1234");

        UserRegistrationResponse response = userService.register(request);
        assertNotNull(response);
        assertNotNull(response.getId());


        userService.write("Danny", "My first day at school", "I am in the class-room writing");
        assertEquals(1, userService.findByUserName("Danny").getNotePad().getEntries().size());
        userService.write("Danny", "My second day at school", "I was very late to school");
        assertEquals(2, userService.findByUserName("Danny").getNotePad().getEntries().size());

        userService.delete(response.getId(),1L, "My second day at school", "I was very late to school");
        assertEquals(1, userService.findByUserName("Danny").getNotePad().getEntries().size());


    }
}
