package com.example.demo.domain.ports.in.Courses;

import com.example.demo.domain.models.Course;

import java.util.List;
import java.util.Optional;

public interface RetrieveCoursesUseCase {

    Optional<Course> getCourse(Long courseId);
    List<Course> getAllCourses();
}
