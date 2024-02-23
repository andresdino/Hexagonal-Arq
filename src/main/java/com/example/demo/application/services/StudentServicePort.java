package com.example.demo.application.services;

import com.example.demo.domain.models.Student;

import java.util.List;
import java.util.Optional;

public interface StudentServicePort {

    Student createStudent(Student student);
    void deleteStudent(Long studentId);
    Optional<Student> getStudent (Long studentId);
    List<Student> getAllStudents();
    Optional<Student> updateStudent(Long studentId, Student student);


}
