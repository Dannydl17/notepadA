package com.notepadApp.notepad.exceptions;

public class InvalidUserEmailException extends RuntimeException {
    public InvalidUserEmailException(String message){
        super(message);
    }
}
