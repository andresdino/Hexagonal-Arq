package com.example.demo.domain.ports.in.Students;

import com.example.demo.domain.models.Student;

import java.util.Optional;

public interface UpdateStudentUseCase {

    Optional<Student> updateStudent(Long studentId, Student student);

}
