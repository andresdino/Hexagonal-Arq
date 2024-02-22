package com.example.demo.application.usecases.Course;

import com.example.demo.domain.models.Course;
import com.example.demo.domain.ports.in.Courses.UpdateCourseUseCase;
import com.example.demo.domain.ports.out.CourseRepositoryPort;

import java.util.Optional;

public class UpdateCourseUseCaseImpl implements UpdateCourseUseCase {

    private final CourseRepositoryPort courseRepositoryPort;

    public UpdateCourseUseCaseImpl(CourseRepositoryPort courseRepositoryPort) {
        this.courseRepositoryPort = courseRepositoryPort;
    }


    @Override
    public Optional<Course> updateCourse(Long courseId, Course course) {
        return courseRepositoryPort.update(course);
    }
}
