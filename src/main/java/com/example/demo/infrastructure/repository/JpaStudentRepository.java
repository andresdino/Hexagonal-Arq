package com.example.demo.infrastructure.repository;

import com.example.demo.domain.models.Student;
import org.springframework.data.repository.CrudRepository;

import java.util.Optional;

public interface JpaStudentRepository extends CrudRepository<Student, Long> {

    Optional<Student> update(Student student);

}
