package com.notepadApp.notepad.services;

import com.notepadApp.notepad.data.models.NotePad;

public interface NotePadService {
    NotePad createNotePad();

    void write(Long notepad, String title, String body);

    NotePad findNotepad(Long findNotePadId);

    void delete(Long notepad, String title, String body);

}
