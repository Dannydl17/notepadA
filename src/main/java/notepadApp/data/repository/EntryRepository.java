package notepadApp.data.repository;

import notepadApp.data.models.Entry;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EntryRepository extends JpaRepository<Entry, Long> {
    Entry findEntryByTitleAndBody(String title, String body);

}
