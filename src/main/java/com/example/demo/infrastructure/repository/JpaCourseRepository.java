package com.example.demo.infrastructure.repository;

import com.example.demo.infrastructure.entities.CourseEntity;
import org.springframework.data.repository.CrudRepository;

public interface JpaCourseRepository extends CrudRepository<CourseEntity, Long> {

}
