package com.example.demo.application.services;

import com.example.demo.application.usecases.CourseUseCaseImpl;
import com.example.demo.domain.models.Course;
import com.example.demo.domain.ports.in.CourseUseCase;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class CourseService implements CourseUseCase {

    private CourseUseCaseImpl courseUseCaseImpl;

    @Override
    public Course createCourse(Course course) {
        return courseUseCaseImpl.createCourse(course);
    }

    @Override
    public void deleteCourse(Long courseId) {
        courseUseCaseImpl.deleteCourse(courseId);
    }

    @Override
    public Optional<Course> getCourse(Long courseId) {
        return courseUseCaseImpl.getCourse(courseId);
    }

    @Override
    public List<Course> getAllCourses() {
        return courseUseCaseImpl.getAllCourses();
    }

    @Override
    public Optional<Course> updateCourse(Long courseId, Course course) {
        return courseUseCaseImpl.updateCourse(courseId, course);
    }
}
