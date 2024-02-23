package com.example.demo.application.services;

import com.example.demo.domain.models.Course;

import java.util.List;
import java.util.Optional;

public interface CourseServicePort {

    Course createCourse(Course course);
    void deleteCourse(Long courseId);
    Optional<Course> getCourse(Long courseId);
    List<Course> getAllCourses();
    Optional<Course> updateCourse(Long courseId, Course course);


}
