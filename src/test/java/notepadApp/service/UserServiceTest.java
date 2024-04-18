package notepadApp.service;

import lombok.SneakyThrows;
import notepadApp.data.models.NotePad;
import notepadApp.data.repository.UserRepository;
import notepadApp.dtos.requests.EntryCreateRequest;
import notepadApp.dtos.requests.UserRegisterRequest;
import notepadApp.dtos.responses.UserRegistrationResponse;
import notepadApp.exception.RegistrationFailedException;
import notepadApp.services.AppNotePadService;
import notepadApp.services.AppUserService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static notepadApp.utils.Constants.*;
import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.assertj.core.api.AssertionsForClassTypes.assertThatThrownBy;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

@SpringBootTest
public class UserServiceTest {
    @Autowired
    private AppUserService userService;
    @Autowired
    private AppNotePadService notePadService;

    @BeforeEach
    public void deleteAll(){
        userService.deleteAll();
    }

    @Test
    public void testThatUserTryToRegisterWithIncompleteDetails_RegistrationFailedExceptionIsThrown(){
        assertThatThrownBy(() -> userService.register(buildUserWithIncompleteDetails()),"Throw for Invalidity")
                .isInstanceOf(RegistrationFailedException.class)
                .hasMessageContaining(BLANK_FIELD_MESSAGE)
                .hasMessage("password: " + BLANK_FIELD_MESSAGE)
                .cause();
    }

    @Test
    @SneakyThrows
    public void testThatUserTryToRegisterWithInvalidFormat_RegistrationFailedExceptionIsThrown(){
        assertThatThrownBy(()-> userService.register(buildUserWithInvalidPassword()), "Throw for Invalid password")
                .hasMessageContaining(INVALID_PASSWORD_MESSAGE)
                .isInstanceOf(RegistrationFailedException.class)
                .cause();
    }

    @Test
    @SneakyThrows
    public void testThatUserTryToRegisterMoreThanOnce_DuplicateModeExceptionIsThrown() {
        userService.register(buildValidUser());
        assertThatThrownBy(() -> userService.register(buildValidUser()), "Duplicate User Test")
                .isInstanceOf(Exception.class)
                .isExactlyInstanceOf(RegistrationFailedException.class)
                .hasMessageContaining(DUPLICATE_USER_MESSAGE)
                .cause();
    }

    @Test
    @SneakyThrows
    public void testThatUserCanRegisterSuccessfully_IfAllCheckedArePassed(){
        UserRegistrationResponse response = userService.register(buildValidUser());
        assertThat(userService.existsByEmail(response.ge))
    }





    private UserRegisterRequest buildValidUser() {
        return UserRegisterRequest.builder()
                .username("Danny Dan")
                .password("Dan01@Big_Dawg")
                .build();
    }

    private UserRegisterRequest buildUserWithInvalidPassword() {
        return UserRegisterRequest.builder()
                .username("Danny Dan")
                .password("Hello")
                .build();
    }

    private UserRegisterRequest buildUserWithIncompleteDetails() {
        return UserRegisterRequest.builder()
                .username("Daniel Dan")
                .build();
    }

    @Test
    @SneakyThrows
    public void testThatUserCanRegisterTest(){
        UserRegisterRequest request = new UserRegisterRequest();
        request.setUsername("Danny");
        request.setPassword("1234");

        UserRegistrationResponse response = userService.register(request);
        assertNotNull(response);
        assertNotNull(response.getId());
    }

    @Test
    @SneakyThrows
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
    @SneakyThrows
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
