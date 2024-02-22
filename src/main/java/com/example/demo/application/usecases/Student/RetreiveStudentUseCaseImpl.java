package com.example.demo.application.usecases.Student;

import com.example.demo.domain.models.Student;
import com.example.demo.domain.ports.in.Students.RetrieveStudentsUseCase;
import com.example.demo.domain.ports.out.StudentRepositoryPort;

import java.util.List;
import java.util.Optional;

public class RetreiveStudentUseCaseImpl implements RetrieveStudentsUseCase {
    private final StudentRepositoryPort studentRepositoryPort;

    public RetreiveStudentUseCaseImpl(StudentRepositoryPort studentRepositoryPort) {
        this.studentRepositoryPort = studentRepositoryPort;
    }

    @Override
    public Optional<Student> getStudent(Long studentId) {
        return studentRepositoryPort.findById(studentId);
    }

    @Override
    public List<Student> getAllStudents() {
        return (List<Student>) studentRepositoryPort.findAll();
    }
}
