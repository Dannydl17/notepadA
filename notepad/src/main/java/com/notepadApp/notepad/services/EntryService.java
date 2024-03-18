package com.notepadApp.notepad.services;

import com.notepadApp.notepad.data.models.Entry;
import com.notepadApp.notepad.dtos.requests.EntryCreateRequest;
import com.notepadApp.notepad.dtos.responses.EntryResponse;

public interface EntryService {
    Entry createEntry(EntryCreateRequest request);

}
