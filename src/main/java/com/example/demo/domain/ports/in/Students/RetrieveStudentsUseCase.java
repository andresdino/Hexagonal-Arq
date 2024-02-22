package com.example.demo.domain.ports.in.Students;

import com.example.demo.domain.models.Student;

import java.util.List;
import java.util.Optional;

public interface RetrieveStudentsUseCase {

    Optional<Student> getStudent (Long studentId);
    List<Student> getAllStudents();

}
