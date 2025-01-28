package org.example.studentsapp.dao.repository;

import org.example.studentsapp.dao.entity.StudentsEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface StudentsRepository  extends JpaRepository<StudentsEntity,Long> {
    @Query (value = " SELECT * FROM students_app WHERE  name =:name",nativeQuery = true)
    List<StudentsEntity> findByName(@Param("name") String name);
}
