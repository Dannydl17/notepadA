package notepadApp.services;

import notepadApp.data.models.Entry;
import notepadApp.dtos.requests.EntryCreateRequest;

public interface EntryService {
    Entry createEntry(EntryCreateRequest request);

    Entry delete(EntryCreateRequest request);

    Entry findEntry(String title, String body);

    Entry updateEntry(EntryCreateRequest request, String message);
}
