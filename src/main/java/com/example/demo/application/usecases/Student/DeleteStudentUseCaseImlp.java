package com.example.demo.application.usecases.Student;

import com.example.demo.domain.ports.in.Courses.DeleteCourseUseCase;
import com.example.demo.domain.ports.out.StudentRepositoryPort;

public class DeleteStudentUseCaseImlp implements DeleteCourseUseCase {

    private final StudentRepositoryPort studentRepositoryPort;

    public DeleteStudentUseCaseImlp(StudentRepositoryPort studentRepositoryPort) {
        this.studentRepositoryPort = studentRepositoryPort;
    }

    @Override
    public void deleteCourse(Long courseId) {
        studentRepositoryPort.deleteById(courseId);
    }
}
