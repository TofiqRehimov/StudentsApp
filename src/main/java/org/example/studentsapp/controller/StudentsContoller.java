package org.example.studentsapp.controller;

import lombok.RequiredArgsConstructor;
import org.example.studentsapp.dto.StudentsRequestDto;
import org.example.studentsapp.dto.StudentsResponseDto;
import org.example.studentsapp.service.StudentsService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("api/v1/StudentsApp")
public class StudentsContoller {
    private final StudentsService studentsService;
    @PostMapping("/post")
    public void AddStudent(@RequestBody StudentsRequestDto Dto) {
        studentsService.addStudents(Dto);
        System.out.println("entity"+ Dto.toString());
    }
    @GetMapping("/get")
    public List<StudentsResponseDto> getStudents (){
       return studentsService.getStudents();
    }
    @GetMapping("/get/{id}")
    public StudentsResponseDto getStudentsById(@PathVariable Long id) {
        return studentsService.getStudentById(id);
    }
    @PostMapping("post/{id}")
    public void UpdateStudent(@RequestBody StudentsRequestDto dto,@PathVariable Long id ) {
        studentsService.updateStudent(dto,id);
    }
    @DeleteMapping("/delete/{id}")
public void DeleteStudent(@PathVariable Long id) throws Exception {
        studentsService.deleteStudent(id);
    }
    @GetMapping("/names")
    public List<StudentsResponseDto> getStudentsByName(@RequestParam String name) {
    return studentsService.getByStudents(name);
    }
}
