package com.example.demo.domain.ports;

import com.example.demo.domain.models.Course;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface CourseRepository {
    Course createCourse (Course course);
    Optional<Course> getCourse(Long courseId);
    List<Course> getAllCourses();
    Optional<Course> updateCourse(Long courseId, Course course);
    void deleteCourse(Long courseId);
}
