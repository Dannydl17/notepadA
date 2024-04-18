package notepadApp.dtos.requests;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;
import lombok.*;

import static notepadApp.utils.Constants.*;

@Setter
@Getter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class UserRegisterRequest {
    @NotBlank(message = BLANK_FIELD_MESSAGE)
    private String username;
    @NotBlank(message = BLANK_FIELD_MESSAGE)
    @Pattern(regexp = PASSWORD_PATTERN, message = INVALID_PASSWORD_MESSAGE)
    private String password;
}
