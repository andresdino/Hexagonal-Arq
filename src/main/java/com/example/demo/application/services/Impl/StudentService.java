package com.example.demo.application.services.Impl;


import com.example.demo.application.services.StudentServicePort;
import com.example.demo.domain.models.Student;
import com.example.demo.domain.ports.StudentRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@RequiredArgsConstructor
@Service
public class StudentService implements StudentServicePort {

    @Autowired
    private StudentRepository studentRepository;


    @Override
    public Student createStudent(Student student) {
        return studentRepository.createStudent(student);
    }

    @Override
    public void deleteStudent(Long studentId) {
        studentRepository.deleteStudent(studentId);
    }

    @Override
    public Optional<Student> getStudent(Long studentId) {
        return studentRepository.getStudent(studentId);
    }

    @Override
    public List<Student> getAllStudents() {
        return studentRepository.getAllStudents();
    }

    @Override
    public Optional<Student> updateStudent(Long studentId, Student student) {
        return studentRepository.updateStudent(studentId, student);
    }
}
