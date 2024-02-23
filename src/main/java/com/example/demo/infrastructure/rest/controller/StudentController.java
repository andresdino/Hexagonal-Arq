package com.example.demo.infrastructure.rest.controller;

import com.example.demo.application.services.Impl.StudentService;
import com.example.demo.domain.models.Student;
import com.example.demo.infrastructure.rest.dto.StudentRequestDto;
import com.example.demo.infrastructure.rest.dto.StudentResponseDto;
import com.example.demo.infrastructure.rest.mapper.StudentMapper;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/api/students")
public class StudentController {

    private final StudentService studentService;

    public StudentController(StudentService studentService) {
        this.studentService = studentService;
    }

    @GetMapping("/find/{id}")
    public ResponseEntity<StudentResponseDto> getStudentById(@PathVariable("id") Long id) {
        Optional<Student> student = studentService.getStudent(id);
        return student.map(s -> ResponseEntity.ok(StudentMapper.studentToResponseDto(s)))
                .orElseGet(() -> ResponseEntity.notFound().build());    }

    @GetMapping("/all")
    public ResponseEntity<List<StudentResponseDto>> getAllStudents() {
        List<Student> students = studentService.getAllStudents();
        return ResponseEntity.ok(students.stream()
                .map(StudentMapper::studentToResponseDto)
                .collect(Collectors.toList()));
    }

    @PostMapping("/create")
    public ResponseEntity<StudentResponseDto> createStudent(@RequestBody StudentRequestDto studentRequestDto) {
        Student student = StudentMapper.requestDtoToModel(studentRequestDto);
        Student createdStudent = studentService.createStudent(student);
        return ResponseEntity.status(HttpStatus.CREATED).body(StudentMapper.studentToResponseDto(createdStudent));
    }

    @PutMapping("/update/{id}")
    public ResponseEntity<StudentResponseDto> updateStudent(@PathVariable("id") Long id, @RequestBody StudentRequestDto studentRequestDto) {
        Optional<Student> existingStudent = studentService.getStudent(id);
        if (existingStudent.isPresent()) {
            Student student = StudentMapper.requestDtoToModel(studentRequestDto);
            student.setId(id);
            Student updatedStudent = studentService.updateStudent(id,student).orElseThrow();
            return ResponseEntity.ok(StudentMapper.studentToResponseDto(updatedStudent));
        }
        return ResponseEntity.notFound().build();
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<Void> deleteStudent(@PathVariable("id") Long id) {
        studentService.deleteStudent(id);
        return ResponseEntity.noContent().build();
    }
}
