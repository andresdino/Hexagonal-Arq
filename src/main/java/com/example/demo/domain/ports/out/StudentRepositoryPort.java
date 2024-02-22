package com.example.demo.domain.ports.out;

import com.example.demo.domain.models.Student;
import org.springframework.data.repository.CrudRepository;

import java.util.Optional;

public interface StudentRepositoryPort extends CrudRepository<Student, Long> {
    Optional<Student> update(Student student);
}
