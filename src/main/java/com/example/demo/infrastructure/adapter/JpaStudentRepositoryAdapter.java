package com.example.demo.infrastructure.adapter;

import com.example.demo.domain.models.Student;
import com.example.demo.domain.ports.out.StudentRepositoryPort;
import com.example.demo.infrastructure.Mapper.StudentEntityMap;
import com.example.demo.infrastructure.entities.StudentEntity;
import com.example.demo.infrastructure.repository.JpaStudentRepository;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Repository
public class JpaStudentRepositoryAdapter implements StudentRepositoryPort {

    private final JpaStudentRepository jpaStudentRepository;

    public JpaStudentRepositoryAdapter(JpaStudentRepository jpaStudentRepository) {
        this.jpaStudentRepository = jpaStudentRepository;
    }


    @Override
    public Student save(Student student) {
        StudentEntity studentEntity = StudentEntityMap.fromDomainModel(student);
        StudentEntity saveStudentEntity = jpaStudentRepository.save(studentEntity);
        return StudentEntityMap.toDomainModel(saveStudentEntity);
    }

    @Override
    public Optional<Student> findById(Long studentId) {
        return jpaStudentRepository.findById(studentId).map(StudentEntityMap::toDomainModel);

    }

    @Override
    public List<Student> findAll() {
        Iterable<StudentEntity> studentEntities = jpaStudentRepository.findAll();
        List<StudentEntity> studentEntityList = new ArrayList<>();
        studentEntities.forEach(studentEntityList::add);
        return studentEntityList.stream().map(StudentEntityMap::toDomainModel).collect(Collectors.toList());
    }

    @Override
    public Optional<Student> update(Student student) {
        if (jpaStudentRepository.existsById(student.getId())) {
            StudentEntity studentEntity = StudentEntityMap.fromDomainModel(student);
            StudentEntity updateStudentEntity = jpaStudentRepository.save(studentEntity);
            return Optional.of(StudentEntityMap.toDomainModel(updateStudentEntity));
        }
        return Optional.empty();
    }

    @Override
    public void deleteById(Long studentId) {
        if (jpaStudentRepository.existsById(studentId)) {
            jpaStudentRepository.deleteById(studentId);
        }
    }
}
