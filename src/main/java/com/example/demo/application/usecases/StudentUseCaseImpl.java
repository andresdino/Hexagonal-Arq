package com.example.demo.application.usecases;

import com.example.demo.domain.models.Student;
import com.example.demo.domain.ports.in.StudentUseCase;
import com.example.demo.domain.ports.out.StudentRepositoryPort;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;
import java.util.Optional;

public class StudentUseCaseImpl implements StudentUseCase  {

    @Autowired
    private StudentRepositoryPort studentRepositoryPort;

    @Override
    public Student createStudent(Student student) {
        return studentRepositoryPort.save(student);
    }


    @Override
    public void deleteStudent(Long studentId) {
        studentRepositoryPort.deleteById(studentId);
    }

    @Override
    public Optional<Student> getStudent(Long studentId) {
        return studentRepositoryPort.findById(studentId);
    }


    @Override
    public List<Student> getAllStudents() {
        return (List<Student>) studentRepositoryPort.findAll();
    }


    @Override
    public Optional<Student> updateStudent(Long studentId, Student student) {
        return studentRepositoryPort.update(student);
    }
}
