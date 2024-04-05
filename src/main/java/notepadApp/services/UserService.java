package notepadApp.services;

import notepadApp.data.models.NotePad;
import notepadApp.dtos.requests.UserRegisterRequest;
import notepadApp.dtos.responses.UserRegistrationResponse;

public interface UserService {
    UserRegistrationResponse register(UserRegisterRequest request);

//    NotePad write(String title, String body);

    NotePad write(String userName, String title, String body);

    NotePad getNotepad(Long id, Long findNotePadId);

    void delete(Long id, Long notepad, String title, String body);
}
