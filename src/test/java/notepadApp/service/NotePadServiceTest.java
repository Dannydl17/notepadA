package notepadApp.service;

import notepadApp.data.models.Entry;
import notepadApp.data.models.NotePad;
import notepadApp.data.repository.NotePadRepository;
import notepadApp.dtos.requests.EntryCreateRequest;
import notepadApp.services.EntryService;
import notepadApp.services.NotePadService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

@SpringBootTest
public class NotePadServiceTest {
    @Autowired
    private NotePadService notePadService;
    @Autowired
    private NotePadRepository repository;

    @BeforeEach
    public void deleteAll(){
        repository.deleteAll();
    }

    @Test
    public void testThatNotePadCanBeCreatedTest(){
        NotePad notePad =  notePadService.createNotePad("daniel");
        assertNotNull(notePad);
    }

    @Test
    public void testThatNotePadCanBeWrittenOnTest(){
        NotePad notePad =  notePadService.createNotePad("daniel");
        assertNotNull(notePad);

        EntryCreateRequest request = new EntryCreateRequest();
        request.setTitle("On Tuesday i will start my exam");
        request.setBody("I am prepared for Tuesday");
        notePadService.write(request.getTitle(), request.getBody(),"daniel");
        //System.out.println(notePad.getId()+1);
        assertEquals(1, notePadService.findByUserName("daniel").getEntries().size());

        EntryCreateRequest request1 = new EntryCreateRequest();
        request1.setTitle("On Wednesday i will start my exam");
        request1.setBody("I am prepared for Wednesday");
        notePadService.write(request1.getTitle(), request1.getBody(), "daniel");
        assertEquals(2, notePadService.findByUserName("daniel").getEntries().size());
    }

    @Test
    public void testThatNotePadCanDeleteAnEntryTest(){
        NotePad notePad =  notePadService.createNotePad("daniel");
        assertNotNull(notePad);

        EntryCreateRequest request = new EntryCreateRequest();
        request.setTitle("On Tuesday i will start my exam");
        request.setBody("I am prepared for Tuesday");
        notePadService.write(request.getTitle(), request.getBody(),"daniel");
        //System.out.println(notePad.getId()+1);
        assertEquals(1, notePadService.findByUserName("daniel").getEntries().size());

        EntryCreateRequest request1 = new EntryCreateRequest();
        request1.setTitle("On Wednesday i will start my exam");
        request1.setBody("I am prepared for Wednesday");
        notePadService.write(request1.getTitle(), request1.getBody(), "daniel");
        assertEquals(2, notePadService.findByUserName("daniel").getEntries().size());

        notePadService.delete(1L, request1.getTitle(), request1.getBody());
        assertEquals(1, notePadService.findByUserName("daniel").getEntries().size());
    }

}
