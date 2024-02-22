package com.example.demo.application.services;


import com.example.demo.application.usecases.StudentUseCaseImpl;
import com.example.demo.domain.models.Student;
import com.example.demo.domain.ports.in.StudentUseCase;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class StudentService implements StudentUseCase {

    private final StudentUseCaseImpl studentUseCaseImpl;

    @Override
    public Student createStudent(Student student) {
        return studentUseCaseImpl.createStudent(student);
    }

    @Override
    public void deleteStudent(Long studentId) {
        studentUseCaseImpl.deleteStudent(studentId);
    }

    @Override
    public Optional<Student> getStudent(Long studentId) {
        return studentUseCaseImpl.getStudent(studentId);
    }

    @Override
    public List<Student> getAllStudents() {
        return studentUseCaseImpl.getAllStudents();
    }

    @Override
    public Optional<Student> updateStudent(Long studentId, Student student) {
        return studentUseCaseImpl.updateStudent(studentId, student);
    }
}
