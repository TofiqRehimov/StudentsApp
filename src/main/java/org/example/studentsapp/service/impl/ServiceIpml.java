package org.example.studentsapp.service.impl;

import lombok.Builder;
import lombok.Data;
import lombok.RequiredArgsConstructor;
import org.example.studentsapp.dao.entity.StudentsEntity;
import org.example.studentsapp.dao.repository.StudentsRepository;
import org.example.studentsapp.dto.StudentsRequestDto;
import org.example.studentsapp.dto.StudentsResponseDto;
import org.example.studentsapp.mapper.StudentsMapper;
import org.example.studentsapp.service.StudentsService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@RequiredArgsConstructor
@Data
@Builder
@Service
public class ServiceIpml implements StudentsService {
private final StudentsRepository studentsRepository;
private final StudentsMapper studentsMapper;
    @Override
    public void addStudents(StudentsRequestDto dto) {
        StudentsEntity entity =StudentsEntity.builder()
                .name(dto.getName())
                .surname(dto.getSurname())
                .gender(dto.getGender())
                .build();
        studentsRepository.save(entity);
    }

    @Override
    public List<StudentsResponseDto> getStudents() {
    List<StudentsEntity> studentsEntities = studentsRepository.findAll();
    return studentsMapper.getStudentsRequestDtoList(studentsEntities);
    }

    @Override
    public StudentsResponseDto getStudentById(Long id) {
    Optional<StudentsEntity> studentsEntity = studentsRepository.findById(id);
        StudentsEntity e = studentsEntity.get();
        return studentsMapper.getStudentsId(e);
    }

    @Override
    public void updateStudent(StudentsRequestDto dto, Long id) {
        Optional<StudentsEntity> studentsEntity = studentsRepository.findById(id);
        if(studentsEntity.isPresent()) {
            studentsEntity.get().setName(dto.getName());
            studentsEntity.get().setSurname(dto.getSurname());
            studentsEntity.get().setGender(dto.getGender());
            studentsRepository.save(studentsEntity.get());
        }
        StudentsRequestDto.builder().name(dto.getName()).gender(dto.getGender()).build();
    }

    @Override
    public void deleteStudent(Long id) throws Exception {
        Optional <StudentsEntity> entity = studentsRepository.findById(id);
        if(entity.isPresent()) {
            studentsRepository.delete(entity.get());
            return;
        }
        throw new Exception("Student not found");
    }


    @Override
    public List<StudentsResponseDto> getByStudents(String name) {
            return studentsMapper.getStudentsRequestDtoList(studentsRepository.findByName(name));
    }
}
