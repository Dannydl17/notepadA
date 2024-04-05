package notepadApp.services;

import lombok.AllArgsConstructor;
import notepadApp.data.models.Entry;
import notepadApp.data.repository.EntryRepository;
import notepadApp.dtos.requests.EntryCreateRequest;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class AppEntryService implements EntryService {
    private final EntryRepository entryRepository;
    @Override
    public Entry createEntry(EntryCreateRequest request) {
        Entry entry = new Entry();
        entry.setTitle(request.getTitle());
        entry.setBody(request.getBody());
        return entryRepository.save(entry);
    }

    @Override
    public Entry delete(EntryCreateRequest request) {
        Entry entry = findEntry(request.getTitle(), request.getBody());
         entryRepository.delete(entry);
         return entry;
    }

    @Override
    public Entry updateEntry(EntryCreateRequest request, String message) {
        Entry entry = findEntry(request.getTitle(),request.getBody());
        entry.setBody(entry.getBody() + " " + message);
        Entry savedEntry = entryRepository.save(entry);
        return  savedEntry;
    }

    @Override
    public Entry findEntry(String title, String body) {
        return entryRepository.findEntryByTitleAndBody(title, body);
    }




}
