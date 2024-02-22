package com.example.demo.application.usecases.Student;

import com.example.demo.domain.models.Student;
import com.example.demo.domain.ports.in.Students.GetStudentsByCourseIdUseCase;
import com.example.demo.domain.ports.out.ExternalServicePort;
import com.example.demo.domain.ports.out.StudentRepositoryPort;

import java.util.List;

public class GetStudentsByCourseIdUseCaseImpl implements GetStudentsByCourseIdUseCase {

    private final ExternalServicePort externalServicePort;

    public GetStudentsByCourseIdUseCaseImpl(ExternalServicePort externalServicePort) {
        this.externalServicePort = externalServicePort;
    }

    @Override
    public List<Student> getStudentsByCourseId(Long courseId) {
        return (List<Student>) externalServicePort.getStudentsByCourseId(courseId);
    }
}
