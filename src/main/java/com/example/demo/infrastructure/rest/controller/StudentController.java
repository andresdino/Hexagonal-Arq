package com.example.demo.infrastructure.rest.controller;

import com.example.demo.application.services.Impl.StudentService;
import com.example.demo.domain.models.Student;
import com.example.demo.infrastructure.rest.dto.StudentRequestDto;
import com.example.demo.infrastructure.rest.dto.StudentResponseDto;
import com.example.demo.infrastructure.rest.mapper.CourseMapper;
import com.example.demo.infrastructure.rest.mapper.StudentMapper;
import org.springframework.beans.factory.annotation.Autowired;
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

    @GetMapping("/{id}")
    public ResponseEntity<StudentResponseDto> getStudentById(@PathVariable("id") Long id) {
        Optional<Student> student = studentService.getStudent(id);
        return student.map(s -> ResponseEntity.ok(StudentMapper.toDto(s)))
                .orElseGet(() -> ResponseEntity.notFound().build());    }

    @GetMapping
    public ResponseEntity<List<StudentResponseDto>> getAllStudents() {
        List<Student> students = studentService.getAllStudents();
        return ResponseEntity.ok(students.stream()
                .map(StudentMapper::toDto)
                .collect(Collectors.toList()));
    }

    @PostMapping
    public ResponseEntity<StudentResponseDto> createStudent(@RequestBody StudentRequestDto studentRequestDto) {
        Student student = StudentMapper.toEntity(studentRequestDto);
        Student createdStudent = studentService.createStudent(student);
        return ResponseEntity.status(HttpStatus.CREATED).body(StudentMapper.toDto(createdStudent));
    }

    @PutMapping("/{id}")
    public ResponseEntity<StudentResponseDto> updateStudent(@PathVariable("id") Long id, @RequestBody StudentRequestDto studentRequestDto) {
        Optional<Student> existingStudent = studentService.getStudent(id);
        if (existingStudent.isPresent()) {
            Student student = StudentMapper.toEntity(studentRequestDto);
            student.setId(id);
            Student updatedStudent = studentService.updateStudent(id,student).orElseThrow();
            return ResponseEntity.ok(StudentMapper.toDto(updatedStudent));
        }
        return ResponseEntity.notFound().build();
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteStudent(@PathVariable("id") Long id) {
        studentService.deleteStudent(id);
        return ResponseEntity.noContent().build();
    }
}
