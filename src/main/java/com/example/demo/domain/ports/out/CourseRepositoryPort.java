package com.example.demo.domain.ports.out;

import com.example.demo.domain.models.Course;
import org.springframework.data.repository.CrudRepository;

import java.util.List;
import java.util.Optional;

public interface CourseRepositoryPort {

    Course save (Course course);
    Optional<Course> findById(Long courseId);
    List<Course> findAll();
    Optional<Course> update(Course course);
    void deleteById(Long courseId);

}
