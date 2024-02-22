package com.example.demo.infrastructure.adapter;

import com.example.demo.domain.models.Student;
import com.example.demo.domain.ports.out.StudentRepositoryPort;
import com.example.demo.infrastructure.repository.JpaStudentRepository;

import java.util.List;
import java.util.Optional;

public class JpaStudentRepositoryAdapter implements StudentRepositoryPort {

    private final JpaStudentRepository jpaStudentRepository;

    public JpaStudentRepositoryAdapter(JpaStudentRepository jpaStudentRepository) {
        this.jpaStudentRepository = jpaStudentRepository;
    }


    @Override
    public Student save(Student student) {
        return null;
    }

    @Override
    public Optional<Student> findById(Long studentId) {
        return Optional.empty();
    }

    @Override
    public List<Student> findAll() {
        return null;
    }

    @Override
    public Optional<Student> update(Student student) {
        return Optional.empty();
    }

    @Override
    public void deleteById(Long studentId) {

    }
}
