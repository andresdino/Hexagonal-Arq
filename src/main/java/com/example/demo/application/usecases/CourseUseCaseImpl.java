package com.example.demo.application.usecases;

import com.example.demo.domain.models.Course;
import com.example.demo.domain.ports.in.CourseUseCase;
import com.example.demo.domain.ports.out.CourseRepositoryPort;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;
import java.util.Optional;

public class CourseUseCaseImpl implements CourseUseCase {

    @Autowired
    private CourseRepositoryPort courseRepositoryPort;


    @Override
    public Course createCourse(Course course) {
        return courseRepositoryPort.save(course);
    }


    @Override
    public void deleteCourse(Long courseId) {
        courseRepositoryPort.deleteById(courseId);
    }


    @Override
    public Optional<Course> getCourse(Long courseId) {
        return courseRepositoryPort.findById(courseId);
    }

    @Override
    public List<Course> getAllCourses() {
        return (List<Course>) courseRepositoryPort.findAll();
    }

    @Override
    public Optional<Course> updateCourse(Long courseId, Course course) {
        return courseRepositoryPort.update(course);
    }

}
