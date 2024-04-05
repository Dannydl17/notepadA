package notepadApp.services;

import lombok.AllArgsConstructor;
import notepadApp.data.models.Entry;
import notepadApp.data.models.NotePad;
import notepadApp.data.repository.NotePadRepository;
import notepadApp.dtos.requests.EntryCreateRequest;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
@AllArgsConstructor
public class AppNotePadService implements NotePadService{
    private final NotePadRepository notePadRepository;
    private final EntryService entryService;
    @Override
    public NotePad createNotePad(String userName) {
        NotePad notePad = new NotePad();
        notePad.setUserName(userName);
        notePadRepository.save(notePad);
        return notePad;

    }

    @Override
    public NotePad findByUserName(String userName) {
        return notePadRepository.findByUserName(userName);
    }

    @Override
    public NotePad write(String title, String body,String userName) {
        NotePad notePad = notePadRepository.findByUserName(userName);
        List<Entry> entries = notePad.getEntries();
        EntryCreateRequest request = new EntryCreateRequest();
        request.setTitle(title);
        request.setBody(body);
        Entry entry = entryService.createEntry(request);
        entries.add(entry);
        notePad.setEntries(entries);
        notePadRepository.save(notePad);
        return notePad;
    }

    @Override
    public NotePad findNotepad_Id(Long notePad_Id) {
        Optional<NotePad> notePad = notePadRepository.findById(notePad_Id);
        return notePad.get();
    }

    @Override
    public void delete(Long notepad_Id, String title, String body) {
        NotePad notePad = findNotepad_Id(notepad_Id);
        EntryCreateRequest request = new EntryCreateRequest();
        request.setTitle(title);
        request.setBody(body);
        Entry entry = entryService.findEntry(title, body);
        List<Entry> entries = getEntries(notePad, entry);
        entryService.delete(request);
        notePadRepository.save(notePad);
    }



    private List<Entry> getEntries(NotePad notePad, Entry entry) {
        List<Entry>entries = notePad.getEntries()
                .stream()
                .filter((entry1) -> !(entry1.getBody().equals(entry.getBody()) &&
                        entry1.getTitle().equals(entry.getTitle())))
                .toList();
//        System.out.println(entries);
        notePad.setEntries(entries);
        notePadRepository.save(notePad);
        return entries;
    }
}
