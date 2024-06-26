package notepadApp.dtos.requests;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class UserWriteRequest {
    private Long id;
    private Long notepad_id;
    private String title;
    private String body;
}
