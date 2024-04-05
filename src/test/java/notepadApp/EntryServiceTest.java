package notepadApp;

import notepadApp.data.models.Entry;
import notepadApp.data.repository.EntryRepository;
import notepadApp.dtos.requests.EntryCreateRequest;
import notepadApp.services.EntryService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.assertEquals;

 @SpringBootTest
public class EntryServiceTest {
    @Autowired
    private EntryService entryService;
    @Autowired
    private EntryRepository repository;

    @BeforeEach
    public void deleteAll(){
        repository.deleteAll();
    }

    @Test
    public void testThatEntryCanBeCreatedTest(){
        EntryCreateRequest request = new EntryCreateRequest();
        request.setTitle("Monday a wonderful day");
        request.setBody("Today was a nice day for me");
        Entry entry = entryService.createEntry(request);
        assertEquals("Today was a nice day for me", entry.getBody());
    }
    @Test public void testThatEntryRepositoryAdds(){
        EntryCreateRequest request = new EntryCreateRequest();
        request.setTitle("Monday a wonderful day");
        request.setBody("Today was a nice day for me");
        Entry entry = entryService.createEntry(request);
        EntryCreateRequest request1 = new EntryCreateRequest();
        request1.setTitle("Monday a wonderful day");
        request1.setBody("Today was a nice day for me");
        Entry entry1 = entryService.createEntry(request);
        assertEquals(2,repository.count());

     }

    @Test
    public void testThatEntryCanBeDeleteTest(){
        EntryCreateRequest request = new EntryCreateRequest();
        request.setTitle("Monday a wonderful day");
        request.setBody("Today was a nice day for me");
        Entry entry = entryService.createEntry(request);
        assertEquals("Today was a nice day for me", entry.getBody());
        entryService.delete(request);
        assertEquals(0, repository.count());
    }

    @Test
    public void testThatEntryCanBeUpdatedTest(){
        EntryCreateRequest request = new EntryCreateRequest();
        request.setTitle("My first day at school");
        request.setBody("I was in school on Monday");
        Entry entry = entryService.createEntry(request);
        assertEquals("I was in school on Monday", entry.getBody());
        Entry newEntry = entryService.updateEntry(request, "doing my homework");
        assertEquals("I was in school on Monday doing my homework", newEntry.getBody());
    }

}
