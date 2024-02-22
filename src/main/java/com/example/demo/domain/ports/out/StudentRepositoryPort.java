package com.example.demo.domain.ports.out;

import com.example.demo.domain.models.Student;

import java.util.List;
import java.util.Optional;

public interface StudentRepositoryPort {
    Student save (Student student);
    Optional<Student> findById(Long studentId);
    List<Student> findAll();
    Optional<Student> update(Student student);
    void deleteById(Long studentId);

}
