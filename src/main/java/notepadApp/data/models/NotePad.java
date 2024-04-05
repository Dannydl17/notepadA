package notepadApp.data.models;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

import static jakarta.persistence.GenerationType.IDENTITY;
@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class NotePad {
    @Id
    @GeneratedValue(strategy = IDENTITY)
    private Long id;
    private String userName;
    private boolean isLocked;
    @OneToMany(fetch = FetchType.EAGER,cascade = {CascadeType.MERGE, CascadeType.REMOVE})
    private List<Entry> entries = new ArrayList<>();

    @Override
    public String toString() {
        return "NotePad{" +
                "id=" + id +
                ", isLocked=" + isLocked +
                ", entries=" + entries +
                '}';
    }
}
