package com.example.demo.infrastructure.adapter;

import com.example.demo.domain.models.Student;
import com.example.demo.domain.ports.out.StudentRepositoryPort;
import com.example.demo.infrastructure.mapper.StudentMapper;
import com.example.demo.infrastructure.entities.StudentEntity;
import com.example.demo.infrastructure.repository.JpaStudentRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Repository
public class JpaStudentRepositoryAdapter implements StudentRepositoryPort {

    private final JpaStudentRepository jpaStudentRepository;
    private final Logger logger = LoggerFactory.getLogger(JpaStudentRepositoryAdapter.class);

    public JpaStudentRepositoryAdapter(JpaStudentRepository jpaStudentRepository) {
        this.jpaStudentRepository = jpaStudentRepository;
    }


    @Override
    public Student save(Student student) {
        logger.info("Saving student with id: {}", student.getId());
        StudentEntity studentEntity = StudentMapper.fromDomainModel(student);
        StudentEntity saveStudentEntity = jpaStudentRepository.save(studentEntity);
        logger.info("Student saved successfully with id: {}", saveStudentEntity.getId());
        return StudentMapper.toDomainModel(saveStudentEntity);
    }

    @Override
    public Optional<Student> findById(Long studentId) {
        logger.info("Finding student with id: {}", studentId);
        return jpaStudentRepository.findById(studentId)
                .map(studentEntity -> {
                    logger.info("Student found with id: {}", studentId);
                    return StudentMapper.toDomainModel(studentEntity);
                });
    }

    @Override
    public List<Student> findAll() {
        logger.info("Finding all students");
        Iterable<StudentEntity> studentEntities = jpaStudentRepository.findAll();
        List<StudentEntity> studentEntityList = new ArrayList<>();
        studentEntities.forEach(studentEntityList::add);
        List<Student> students = studentEntityList.stream()
                .map(StudentMapper::toDomainModel)
                .collect(Collectors.toList());
        logger.info("Found {} students", students.size());
        return students;
    }

    @Override
    public Optional<Student> update(Student student) {
        logger.info("Updating student with id: {}", student.getId());
        if (jpaStudentRepository.existsById(student.getId())) {
            StudentEntity studentEntity = StudentMapper.fromDomainModel(student);
            StudentEntity updateStudentEntity = jpaStudentRepository.save(studentEntity);
            logger.info("Student updated successfully with id: {}", updateStudentEntity.getId());
            return Optional.of(StudentMapper.toDomainModel(updateStudentEntity));
        }
        logger.warn("Student with id {} not found for update", student.getId());
        return Optional.empty();
    }

    @Override
    public void deleteById(Long studentId) {
        logger.info("Deleting student with id: {}", studentId);
        if (jpaStudentRepository.existsById(studentId)) {
            jpaStudentRepository.deleteById(studentId);
            logger.info("Student deleted successfully with id: {}", studentId);
        } else {
            logger.warn("Student with id {} not found for delete", studentId);
        }
    }
}
