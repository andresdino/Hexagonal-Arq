package com.example.demo.infrastructure.repository;

import com.example.demo.domain.models.Course;
import org.springframework.data.repository.CrudRepository;

import java.util.Optional;

public interface JpaCourseRepository extends CrudRepository<Course, Long> {

    Optional<Course> update(Course course);

}
