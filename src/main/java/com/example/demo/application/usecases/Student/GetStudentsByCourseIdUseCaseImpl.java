package com.example.demo.application.usecases.Student;

import com.example.demo.domain.models.Student;
import com.example.demo.domain.ports.in.Students.GetStudentsByCourseIdUseCase;
import com.example.demo.domain.ports.out.StudentRepositoryPort;

import java.util.List;

public class GetStudentsByCourseIdUseCaseImpl implements GetStudentsByCourseIdUseCase {

    private final StudentRepositoryPort studentRepositoryPort;

    public GetStudentsByCourseIdUseCaseImpl(StudentRepositoryPort studentRepositoryPort) {
        this.studentRepositoryPort = studentRepositoryPort;
    }

    @Override
    public List<Student> getStudentsByCourseId(Long courseId) {
        return (List<Student>) studentRepositoryPort.findById(courseId).orElse(null);
    }
}
