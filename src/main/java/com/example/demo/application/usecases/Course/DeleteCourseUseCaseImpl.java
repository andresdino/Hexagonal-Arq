package com.example.demo.application.usecases.Course;

import com.example.demo.domain.ports.in.Courses.DeleteCourseUseCase;
import com.example.demo.domain.ports.out.CourseRepositoryPort;

public class DeleteCourseUseCaseImpl implements DeleteCourseUseCase {

    private final CourseRepositoryPort courseRepositoryPort;

    public DeleteCourseUseCaseImpl(CourseRepositoryPort courseRepositoryPort) {
        this.courseRepositoryPort = courseRepositoryPort;
    }


    @Override
    public void deleteCourse(Long courseId) {
        courseRepositoryPort.deleteById(courseId);
    }
}
