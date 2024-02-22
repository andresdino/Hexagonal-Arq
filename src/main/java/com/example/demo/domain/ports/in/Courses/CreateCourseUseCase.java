package com.example.demo.domain.ports.in.Courses;

import com.example.demo.application.dto.request.CourseRequestDto;
import com.example.demo.application.dto.response.CourseResponseDto;
import com.example.demo.domain.models.Course;

public interface CreateCourseUseCase {

    Course createCourse(Course course);

}
