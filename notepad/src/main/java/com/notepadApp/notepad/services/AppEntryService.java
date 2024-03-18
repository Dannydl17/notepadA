package com.notepadApp.notepad.services;

import com.notepadApp.notepad.data.models.Entry;
import com.notepadApp.notepad.data.models.NotePad;
import com.notepadApp.notepad.data.repository.EntryRepository;
import com.notepadApp.notepad.data.repository.UserRepository;
import com.notepadApp.notepad.dtos.requests.EntryCreateRequest;
import com.notepadApp.notepad.dtos.responses.EntryResponse;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class AppEntryService implements EntryService{
    private final EntryRepository entryRepository;

    @Override
    public EntryResponse createEntry(EntryCreateRequest request) {
        Entry entry = new Entry();
        entry.setTitle(request.getTitle());
        entry.setBody(request.getBody());
        Entry savedEntry = entryRepository.save(entry);
        List<Entry> entries =



        return null;
    }
}
