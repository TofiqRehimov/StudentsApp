package org.example.studentsapp.dao.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.example.studentsapp.util.Enums.Gender;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import java.time.LocalDateTime;

@Entity
@Builder
@Data
@Table(name="StudentsApp")
@AllArgsConstructor
@NoArgsConstructor

public class StudentsEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private String surname;
    private Gender gender;

    @CreationTimestamp
    private LocalDateTime create_at = LocalDateTime.now();

    @UpdateTimestamp
    private LocalDateTime update_at = LocalDateTime.now();

}
