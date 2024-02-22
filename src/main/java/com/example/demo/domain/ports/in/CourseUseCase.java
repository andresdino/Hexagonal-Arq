package com.example.demo.domain.ports.in;

import com.example.demo.domain.models.Course;

import java.util.List;
import java.util.Optional;

public interface CourseUseCase {

    Course createCourse(Course course);
    void deleteCourse(Long courseId);
    Optional<Course> getCourse(Long courseId);
    List<Course> getAllCourses();

    Optional<Course> updateCourse(Long courseId, Course course);


}
