package com.notepadApp.notepad.services;

import com.notepadApp.notepad.data.models.Entry;
import com.notepadApp.notepad.data.models.NotePad;
import com.notepadApp.notepad.data.repository.NotePadRepository;
import com.notepadApp.notepad.dtos.requests.EntryCreateRequest;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

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

    @Override
    public NotePad findNotepad(Long findNotePadId) {
        return findById(findNotePadId);
    }

    @Override
    public void delete(Long notepad, String title, String body) {
        NotePad notePad = findNotepad(notepad);
        EntryCreateRequest request = new EntryCreateRequest();
        request.setTitle(title);
        request.setBody(body);
        Entry entry = entryService.findEntry(title, body);
        System.out.println(notePad.getEntries());
        List<Entry>entries = notePad.getEntries()
                .stream()
                .filter((entry1) -> !(entry1.getBody().equals(entry.getBody()) &&
                        entry1.getTitle().equals(entry.getTitle())))
                .toList();
        notePad.setEntries(entries);
        notePadRepository.save(notePad);
        System.out.println(entries);
        entryService.delete(request);
        notePadRepository.save(notePad);
    }

    private NotePad findById(Long notepad) {
        return notePadRepository.findById(notepad).get();
    }
}
