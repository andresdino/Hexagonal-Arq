package com.example.demo.application.usecases.Course;

import com.example.demo.domain.models.Course;
import com.example.demo.domain.ports.in.Courses.CreateCourseUseCase;
import com.example.demo.domain.ports.out.CourseRepositoryPort;

public class CreateCourseUseCaseImpl implements CreateCourseUseCase {

    private final CourseRepositoryPort courseRepositoryPort;

    public CreateCourseUseCaseImpl(CourseRepositoryPort courseRepositoryPort){
        this.courseRepositoryPort = courseRepositoryPort;
    }

    @Override
    public Course createCourse(Course course) {
        return courseRepositoryPort.save(course);
    }
}
