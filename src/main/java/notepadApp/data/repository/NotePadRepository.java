package notepadApp.data.repository;

import notepadApp.data.models.NotePad;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface NotePadRepository extends JpaRepository<NotePad, Long> {

    NotePad findByUserName(String userName);
}
