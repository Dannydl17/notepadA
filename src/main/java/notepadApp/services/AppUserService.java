package notepadApp.services;

import lombok.AllArgsConstructor;
import notepadApp.data.models.Entry;
import notepadApp.data.models.NotePad;
import notepadApp.data.models.User;
import notepadApp.data.repository.UserRepository;
import notepadApp.dtos.requests.EntryCreateRequest;
import notepadApp.dtos.requests.UserRegisterRequest;
import notepadApp.dtos.responses.UserRegistrationResponse;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class AppUserService  implements  UserService{
    private final UserRepository userRepository;
    private final NotePadService notePadService;
    private final EntryService entryService;

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
    public User findByUserName(String userName) {
        User user = userRepository.findByUsername(userName);
        return user;
    }

    @Override
    public NotePad write(String userName, String title, String body) {
        User user = userRepository.findByUsername(userName);
        NotePad notePad = user.getNotePad();
        EntryCreateRequest request = new EntryCreateRequest();
        request.setTitle(title);
        request.setBody(body);
        Entry entry = entryService.createEntry(request);
        List<Entry> entries = notePad.getEntries();
        entries.add(entry);
        notePad.setUserName(userName);
        notePad.setEntries(entries);
        userRepository.save(user);
        return notePad;
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
