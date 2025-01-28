package org.example.studentsapp.service;

import org.example.studentsapp.dto.StudentsRequestDto;
import org.example.studentsapp.dto.StudentsResponseDto;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public interface StudentsService {
    void addStudents(StudentsRequestDto dto);

    List<StudentsResponseDto> getStudents();

    StudentsResponseDto getStudentById(Long id);

    void updateStudent(StudentsRequestDto dto, Long id);

    void deleteStudent(Long id) throws Exception;
    List<StudentsResponseDto> getByStudents(String surname);
}
