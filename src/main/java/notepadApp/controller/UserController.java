package notepadApp.controller;

import lombok.AllArgsConstructor;
import notepadApp.dtos.requests.EntryCreateRequest;
import notepadApp.dtos.requests.UserRegisterRequest;
import notepadApp.dtos.responses.UserRegistrationResponse;
import notepadApp.services.UserService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/userController")
@AllArgsConstructor
public class UserController {
    private final UserService userService;

    @PostMapping("/register")
    public ResponseEntity<?> registerUser(@RequestBody UserRegisterRequest userRegisterRequest){
        try {
           UserRegistrationResponse response = userService.register(userRegisterRequest);
           response.setData("Okay");
            return ResponseEntity.ok().body(response);
        }catch (Exception e){
            UserRegistrationResponse response = new UserRegistrationResponse();
            response.setData("Okay "+e.getMessage());
            return ResponseEntity.badRequest().body(response);

        }

    }

    @PostMapping("/writeEntry")
    public ResponseEntity<String> writeEntry(@RequestBody EntryCreateRequest entryCreateRequest){
        try {
            userService.write("",entryCreateRequest.getTitle(),
                    entryCreateRequest.getBody());
            return ResponseEntity.ok().body("Entry Written Successful ");
        }catch (Exception e){
            return ResponseEntity.ok().body("Entry Written Failed"+e.getMessage());
        }

    }


}
