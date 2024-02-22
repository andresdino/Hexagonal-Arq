package com.example.demo.domain.ports.in.Courses;

import com.example.demo.domain.models.Course;

import java.util.Optional;

public interface UpdateCourseUseCase {

    Optional<Course> updateCourse(Long courseId, Course course);

}
