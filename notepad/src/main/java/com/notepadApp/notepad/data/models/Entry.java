package com.notepadApp.notepad.data.models;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import static jakarta.persistence.GenerationType.IDENTITY;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Entry {
    @Id
    @GeneratedValue(strategy = IDENTITY)
    private Long id;
    private String title;
    private String body;


}
