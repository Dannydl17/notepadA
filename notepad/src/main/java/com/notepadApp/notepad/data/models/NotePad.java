package com.notepadApp.notepad.data.models;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

import static jakarta.persistence.GenerationType.IDENTITY;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class NotePad {
    @Id
    @GeneratedValue(strategy = IDENTITY)
    private Long id;
    private boolean isLocked;
    @OneToMany(fetch = FetchType.EAGER,cascade = {CascadeType.MERGE, CascadeType.REMOVE})
    private List<Entry> entries;
}
