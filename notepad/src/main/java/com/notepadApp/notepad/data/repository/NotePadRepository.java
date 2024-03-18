package com.notepadApp.notepad.data.repository;

import com.notepadApp.notepad.data.models.NotePad;
import org.springframework.data.jpa.repository.JpaRepository;

public interface NotePadRepository extends JpaRepository<NotePad, Long> {

}
