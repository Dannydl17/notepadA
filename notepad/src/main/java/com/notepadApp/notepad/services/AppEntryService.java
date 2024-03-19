package com.notepadApp.notepad.services;

import com.notepadApp.notepad.data.models.Entry;
import com.notepadApp.notepad.data.repository.EntryRepository;
import com.notepadApp.notepad.dtos.requests.EntryCreateRequest;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class AppEntryService implements EntryService{
    private final EntryRepository entryRepository;

    @Override
    public Entry createEntry(EntryCreateRequest request) {
        Entry entry = new Entry();
        entry.setTitle(request.getTitle());
        entry.setBody(request.getBody());
        Entry savedEntry = entryRepository.save(entry);
        return savedEntry;
    }

    @Override
    public Entry delete(EntryCreateRequest request) {
        Entry entry = findEntry(request.getTitle(), request.getBody());
        entryRepository.delete(entry);
        return entry;
    }
    @Override
    public Entry findEntry(String title, String body) {
        return entryRepository.findEntryByTitleAndBody(title, body);
    }
}
