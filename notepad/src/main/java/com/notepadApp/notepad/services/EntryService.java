package com.notepadApp.notepad.services;

import com.notepadApp.notepad.data.models.Entry;
import com.notepadApp.notepad.dtos.requests.EntryCreateRequest;

public interface EntryService {
    Entry createEntry(EntryCreateRequest request);

    Entry delete(EntryCreateRequest request);

    Entry findEntry(String title, String body);

}
