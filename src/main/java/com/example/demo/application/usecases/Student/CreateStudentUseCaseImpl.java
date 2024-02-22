package com.example.demo.application.usecases.Student;

import com.example.demo.domain.models.Student;
import com.example.demo.domain.ports.in.Students.CreateStudentUseCase;
import com.example.demo.domain.ports.out.StudentRepositoryPort;

public class CreateStudentUseCaseImpl implements CreateStudentUseCase {

    private final StudentRepositoryPort studentRepositoryPort;

    public CreateStudentUseCaseImpl(StudentRepositoryPort studentRepositoryPort) {
        this.studentRepositoryPort = studentRepositoryPort;
    }

    @Override
    public Student createStudent(Student student) {
        return studentRepositoryPort.save(student);
    }
}
