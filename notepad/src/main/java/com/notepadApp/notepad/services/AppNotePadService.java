package com.notepadApp.notepad.services;

import com.notepadApp.notepad.data.models.Entry;
import com.notepadApp.notepad.data.models.NotePad;
import com.notepadApp.notepad.data.repository.NotePadRepository;
import com.notepadApp.notepad.dtos.requests.EntryCreateRequest;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class AppNotePadService implements NotePadService{
    private final NotePadRepository notePadRepository;
    private EntryService entryService;

    @Override
    public NotePad createNotePad() {
        NotePad notePad = new NotePad();
        notePadRepository.save(notePad);
        return notePad;
    }

    @Override
    public void write(Long notepad, String title, String body) {
        NotePad notePad = findById(notepad);
        EntryCreateRequest request = new EntryCreateRequest();
        request.setBody(body);
        request.setTitle(title);
        Entry newEntry = entryService.createEntry(request);
        notePad.getEntries().add(newEntry);
        notePadRepository.save(notePad);
    }

    private NotePad findById(Long notepad) {
        return notePadRepository.findById(notepad).get();
    }
}
