package com.example.demo.domain.ports.out;

import com.example.demo.domain.models.Course;
import org.springframework.data.repository.CrudRepository;

import java.util.Optional;

public interface CourseRepositoryPort extends CrudRepository<Course, Long> {

    Optional<Course> update(Course course);

}
