package notepadApp.data.repository;

import notepadApp.data.models.NotePad;
import org.springframework.data.jpa.repository.JpaRepository;

public interface NotePadRepository extends JpaRepository<NotePad, Long> {

    NotePad findByUserName(String userName);
}
