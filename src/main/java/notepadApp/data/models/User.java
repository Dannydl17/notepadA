package notepadApp.data.models;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;
@Entity
@Getter
@Setter
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String username;
    private String password;
    private LocalDateTime localDateTime = LocalDateTime.now();
    @OneToOne(fetch = FetchType.EAGER,cascade = CascadeType.ALL)
    private NotePad notePad = new NotePad();
}
