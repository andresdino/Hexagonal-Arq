package com.example.demo.application.usecases.Course;

import com.example.demo.domain.models.Course;
import com.example.demo.domain.ports.in.Courses.RetrieveCoursesUseCase;
import com.example.demo.domain.ports.out.CourseRepositoryPort;

import java.util.List;
import java.util.Optional;

public class RetrieveCoursesUseCaseImpl implements RetrieveCoursesUseCase {

    private final CourseRepositoryPort courseRepositoryPort;

    public RetrieveCoursesUseCaseImpl(CourseRepositoryPort courseRepositoryPort) {
        this.courseRepositoryPort = courseRepositoryPort;
    }

    @Override
    public Optional<Course> getCourse(Long courseId) {
        return courseRepositoryPort.findById(courseId);
    }

    @Override
    public List<Course> getAllCourses() {
        return (List<Course>) courseRepositoryPort.findAll();
    }
}
