package com.example.demo.application.services.Impl;

import com.example.demo.application.services.CourseServicePort;
import com.example.demo.domain.models.Course;
import com.example.demo.domain.ports.CourseRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@RequiredArgsConstructor
@Service
public class CourseService implements CourseServicePort {

    @Autowired
    private CourseRepository courseRepository;

    @Override
    public Course createCourse(Course course) {
        return courseRepository.createCourse(course);
    }

    @Override
    public void deleteCourse(Long courseId) {
        courseRepository.deleteCourse(courseId);
    }

    @Override
    public Optional<Course> getCourse(Long courseId) {
        return courseRepository.getCourse(courseId);
    }

    @Override
    public List<Course> getAllCourses() {
        return courseRepository.getAllCourses();
    }

    @Override
    public Optional<Course> updateCourse(Long courseId, Course course) {
        return courseRepository.updateCourse(courseId, course);
    }
}
