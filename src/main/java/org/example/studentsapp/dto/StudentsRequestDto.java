package org.example.studentsapp.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.example.studentsapp.util.Enums.Gender;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;
import org.springframework.stereotype.Component;

import java.time.LocalDate;
import java.time.LocalDateTime;

@Component
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class StudentsRequestDto {

    private String name;
    private String surname;
    private Gender gender;

    @CreationTimestamp
    private LocalDate create_at;

    @UpdateTimestamp
    private LocalDate update_at;
}
