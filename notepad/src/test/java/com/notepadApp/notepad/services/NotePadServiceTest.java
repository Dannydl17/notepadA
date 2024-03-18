package com.notepadApp.notepad.services;

import com.notepadApp.notepad.data.models.NotePad;
import com.notepadApp.notepad.data.repository.NotePadRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

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
      NotePad notePad =  notePadService.createNotePad();
    }

}
