package com.notepadApp.notepad.data.repository;

import com.notepadApp.notepad.data.models.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {
}
