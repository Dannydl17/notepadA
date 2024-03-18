package com.notepadApp.notepad.services;

import com.notepadApp.notepad.data.models.Entry;
import com.notepadApp.notepad.data.repository.EntryRepository;
import com.notepadApp.notepad.data.repository.UserRepository;
import com.notepadApp.notepad.dtos.requests.EntryCreateRequest;
import com.notepadApp.notepad.dtos.responses.EntryResponse;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

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
    public void testThatNotePadCanBeCreateEntryTest(){
        EntryCreateRequest request = new EntryCreateRequest();
        request.setTitle("My first day at school");
        request.setBody("I was in school on Monday");

        entryService.createEntry(request);


    }

}
