package com.example.demo.infrastructure.repository;

import com.example.demo.infrastructure.entities.StudentEntity;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface JpaStudentRepository extends CrudRepository<StudentEntity, Long> {

}
