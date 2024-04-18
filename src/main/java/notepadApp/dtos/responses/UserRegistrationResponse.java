package notepadApp.dtos.responses;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class UserRegistrationResponse {
//    private String message;
    private Long id;
    private Long notepad_id;
    private String data;
}
