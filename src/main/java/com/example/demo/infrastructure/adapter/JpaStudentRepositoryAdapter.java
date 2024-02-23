package com.example.demo.infrastructure.adapter;

import com.example.demo.domain.models.Student;
import com.example.demo.domain.ports.StudentRepository;
import com.example.demo.infrastructure.adapter.repository.JpaStudentRepository;
import com.example.demo.infrastructure.entities.StudentEntity;
import com.example.demo.infrastructure.rest.mapper.StudentMapper;
import lombok.RequiredArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Repository
@RequiredArgsConstructor
public class JpaStudentRepositoryAdapter implements StudentRepository {

    private final JpaStudentRepository jpaStudentRepository;
    private final Logger logger = LoggerFactory.getLogger(JpaStudentRepositoryAdapter.class);

    @Override
    public Student createStudent(Student student) {
        StudentEntity studentEntity = StudentMapper.modelToEntity(student);
        StudentEntity savedStudentEntity = jpaStudentRepository.save(studentEntity);
        logger.info("Created student: {}", savedStudentEntity.getName());
        return StudentMapper.entityToModel(savedStudentEntity);
    }

    @Override
    public Optional<Student> getStudent(Long studentId) {
        logger.info("Getting student with ID: {}", studentId);
        return jpaStudentRepository.findById(studentId)
                .map(studentEntity -> {
                    logger.info("Student found: {}", studentEntity.getName());
                    return StudentMapper.entityToModel(studentEntity);
                });
    }

    @Override
    public List<Student> getAllStudents() {
        logger.info("Getting all students");
        Iterable<StudentEntity> studentEntities = jpaStudentRepository.findAll();
        List<StudentEntity> studentEntityList = new ArrayList<>();
        studentEntities.forEach(studentEntityList::add);
        List<Student> students = studentEntityList.stream()
                .map(StudentMapper::entityToModel)
                .collect(Collectors.toList());
        logger.info("Found {} students", students.size());
        return students;
    }

    @Override
    public Optional<Student> updateStudent(Long studentId, Student student) {
        logger.info("Updating course with id: {}", studentId);
        if (jpaStudentRepository.existsById(studentId)) {
            StudentEntity studentEntity = StudentMapper.modelToEntity(student);
            StudentEntity updatedStudentEntity = jpaStudentRepository.save(studentEntity);
            logger.info("Student updated successfully with id: {}", updatedStudentEntity.getId());
            return Optional.of(StudentMapper.entityToModel(updatedStudentEntity));
        }
        logger.warn("Student with id {} not found for update", studentId);
        return Optional.empty();
    }

    @Override
    public void deleteStudent(Long studentId) {
        logger.info("Deleting student with ID: {}", studentId);
        jpaStudentRepository.deleteById(studentId);
        logger.info("Student deleted successfully");
    }

}
