package org.example.studentsapp.mapper;

import lombok.Builder;
import lombok.RequiredArgsConstructor;
import org.example.studentsapp.dao.entity.StudentsEntity;
import org.example.studentsapp.dto.StudentsResponseDto;
import org.example.studentsapp.util.DateUtil;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
@Builder
@RequiredArgsConstructor
public class StudentsMapper {
    public List<StudentsResponseDto> getStudentsRequestDtoList(List<StudentsEntity> entities) {
        List<StudentsResponseDto> dtos = new ArrayList<>();
        for (StudentsEntity e : entities) {
            StudentsResponseDto dto = StudentsResponseDto.builder()
                    .name(e.getName())
                    .surname(e.getSurname())
                    .create_at(DateUtil.getFormatter(e.getCreate_at(), true))
                    .update_at(DateUtil.getFormatter(e.getUpdate_at(), false))
                    .gender(e.getGender())
                    .build();
            dtos.add(dto);
        }
        return dtos;
    }

    public StudentsResponseDto getStudentsId(StudentsEntity entity) {
        StudentsResponseDto dto;
        dto = StudentsResponseDto.builder()
                .name(entity.getName())
                .surname(entity.getSurname())
                .build();

        return dto;
    }
}
