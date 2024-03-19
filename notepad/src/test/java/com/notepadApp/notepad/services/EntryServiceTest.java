package com.notepadApp.notepad.services;

import com.notepadApp.notepad.data.models.Entry;
import com.notepadApp.notepad.data.repository.EntryRepository;
import com.notepadApp.notepad.dtos.requests.EntryCreateRequest;
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
    public void testThatEntryCanBeCreateEntryTest(){
        EntryCreateRequest request = new EntryCreateRequest();
        request.setTitle("My first day at school");
        request.setBody("I was in school on Monday");
        Entry entry = entryService.createEntry(request);
        assertEquals("I was in school on Monday", entry.getBody());
    }
    @Test
    public void testThatEntryCanBeDeletedEntryTest(){
        EntryCreateRequest request = new EntryCreateRequest();
        request.setTitle("My first day at school");
        request.setBody("I was in school on Monday");
        Entry entry = entryService.createEntry(request);
        assertEquals("I was in school on Monday", entry.getBody());
        entryService.delete(request);
        assertEquals(0, repository.count());

    }

}
