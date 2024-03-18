package com.notepadApp.notepad.services;

import com.notepadApp.notepad.data.models.NotePad;
import com.notepadApp.notepad.data.repository.EntryRepository;
import com.notepadApp.notepad.data.repository.NotePadRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class AppNotePadService implements NotePadService{
    private final NotePadRepository notePadRepository;
    @Override
    public NotePad createNotePad() {
        NotePad notePad = new NotePad();
        notePadRepository.save(notePad);
        return notePad;
    }
}
