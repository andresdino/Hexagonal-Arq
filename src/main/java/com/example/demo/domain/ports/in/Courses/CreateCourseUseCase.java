package com.example.demo.domain.ports.in.Courses;

import com.example.demo.domain.models.Course;

public interface CreateCourseUseCase {

    Course createCourse(Course course);

}
