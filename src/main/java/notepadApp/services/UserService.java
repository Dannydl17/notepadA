package notepadApp.services;

import notepadApp.data.models.Entry;
import notepadApp.data.models.NotePad;
import notepadApp.data.models.User;
import notepadApp.dtos.requests.UserRegisterRequest;
import notepadApp.dtos.responses.UserRegistrationResponse;
import notepadApp.exception.RegistrationFailedException;

public interface UserService {
    UserRegistrationResponse register(UserRegisterRequest request) throws RegistrationFailedException;
    User findByUserName(String userName);
    NotePad write(String userName, String title, String body);
    void delete(Long id, Long notepad, String title, String body);

    void deleteAll();

}
