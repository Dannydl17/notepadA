package notepadApp.services;

import lombok.AllArgsConstructor;
import notepadApp.data.models.NotePad;
import notepadApp.data.models.User;
import notepadApp.data.repository.UserRepository;
import notepadApp.dtos.requests.UserRegisterRequest;
import notepadApp.dtos.responses.UserRegistrationResponse;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class AppUserService  implements  UserService{
    private final UserRepository userRepository;
    private final NotePadService notePadService;
    @Override
    public UserRegistrationResponse register(UserRegisterRequest request) {
        User user = new User();

        user.setUsername(request.getUsername());
        user.setPassword(request.getPassword());

        User savedUser = userRepository.save(user);
        NotePad notePad = notePadService.createNotePad(request.getUsername());
        UserRegistrationResponse response = new UserRegistrationResponse();
        response.setId(savedUser.getId());
        response.setNotepad_id(notePad.getId());
        return response;
    }

    @Override
    public NotePad write(String userName, String title, String body) {
        NotePad notePad1 = notePadService.createNotePad(userName);
        return notePadService.write(userName, title, body);
    }

    @Override
    public NotePad getNotepad(Long id, Long notepad_id) {
        User user = findById(id);
        return notePadService.findNotepad_Id(notepad_id);
    }

    private User findById(Long id) {
        return userRepository.findById(id).get();
    }

    @Override
    public void delete(Long id, Long notepad, String title, String body) {
        User user = findById(id);
        notePadService.delete(notepad, title, body);
    }
}
