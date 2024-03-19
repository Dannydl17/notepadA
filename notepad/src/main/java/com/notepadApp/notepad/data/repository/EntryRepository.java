package com.notepadApp.notepad.data.repository;

import com.notepadApp.notepad.data.models.Entry;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EntryRepository extends JpaRepository<Entry, Long> {
    Entry findEntryByTitleAndBody(String title, String body);

}
