package com.notepadApp.notepad.data.models;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;
@Entity
@Getter
@Setter
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String userName;
    private String phoneNumber;
    private String email;
    private String passWord;
    private LocalDateTime localDateTime = LocalDateTime.now();
    @OneToOne(fetch = FetchType.EAGER,cascade = CascadeType.ALL)
    private NotePad notePad;
}
