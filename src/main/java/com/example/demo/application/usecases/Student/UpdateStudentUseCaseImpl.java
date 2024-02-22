package com.example.demo.application.usecases.Student;

import com.example.demo.domain.models.Student;
import com.example.demo.domain.ports.in.Students.UpdateStudentUseCase;
import com.example.demo.domain.ports.out.StudentRepositoryPort;

import java.util.Optional;

public class UpdateStudentUseCaseImpl implements UpdateStudentUseCase {

    private final StudentRepositoryPort studentRepositoryPort;

    public UpdateStudentUseCaseImpl(StudentRepositoryPort studentRepositoryPort) {
        this.studentRepositoryPort = studentRepositoryPort;
    }

    @Override
    public Optional<Student> updateStudent(Long studentId, Student student) {
        return studentRepositoryPort.update(student);
    }
}
