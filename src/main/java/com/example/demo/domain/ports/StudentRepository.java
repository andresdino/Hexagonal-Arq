package com.example.demo.domain.ports;

import com.example.demo.domain.models.Student;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface StudentRepository {
    Student createStudent (Student student);
    Optional<Student> getStudent(Long studentId);
    List<Student> getAllStudents();
    Optional<Student> updateStudent(Long studentId, Student student);
    void deleteStudent(Long studentId);

}
