package org.example.studentsapp.exception;

import lombok.AllArgsConstructor;

@AllArgsConstructor

public class StudentNotFoundException extends RuntimeException {
    public StudentNotFoundException(String message) {
        super(message);
    }
}
