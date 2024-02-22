package com.example.demo.infrastructure.adapter;

import com.example.demo.domain.models.Course;
import com.example.demo.domain.ports.out.CourseRepositoryPort;
import com.example.demo.infrastructure.repository.JpaCourseRepository;

import java.util.List;
import java.util.Optional;

public class JpaCourseRepositoryAdapter implements CourseRepositoryPort {

    private final JpaCourseRepository jpaCourseRepository;

    public JpaCourseRepositoryAdapter(JpaCourseRepository jpaCourseRepository) {
        this.jpaCourseRepository = jpaCourseRepository;
    }

    @Override
    public Course save(Course course) {
        return null;
    }

    @Override
    public Optional<Course> findById(Long courseId) {
        return Optional.empty();
    }

    @Override
    public List<Course> findAll() {
        return null;
    }

    @Override
    public Optional<Course> update(Course course) {
        return Optional.empty();
    }

    @Override
    public void deleteById(Long courseId) {

    }
}
