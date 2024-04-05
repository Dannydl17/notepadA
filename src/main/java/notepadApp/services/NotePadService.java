package notepadApp.services;

import notepadApp.data.models.NotePad;

public interface NotePadService {
    NotePad createNotePad(String userName);
    NotePad findByUserName(String userName);

    NotePad write(String title, String body,String userName);

    NotePad findNotepad_Id(Long findNotePadId);

    void delete(Long notepad, String title, String body);
}
