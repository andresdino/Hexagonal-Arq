package com.example.demo.application.services;


import com.example.demo.domain.models.Student;
import com.example.demo.domain.ports.in.Students.CreateStudentUseCase;
import com.example.demo.domain.ports.in.Students.DeleteStudentUseCase;
import com.example.demo.domain.ports.in.Students.RetrieveStudentsUseCase;
import com.example.demo.domain.ports.in.Students.UpdateStudentUseCase;

import java.util.List;
import java.util.Optional;

public class StudentService implements CreateStudentUseCase, DeleteStudentUseCase, RetrieveStudentsUseCase, UpdateStudentUseCase {

    private final CreateStudentUseCase createStudentUseCase;
    private final DeleteStudentUseCase deleteStudentUseCase;
    private final RetrieveStudentsUseCase retrieveStudentsUseCase;
    private final UpdateStudentUseCase updateStudentUseCase;


    public StudentService(CreateStudentUseCase createStudentUseCase, DeleteStudentUseCase deleteStudentUseCase, RetrieveStudentsUseCase retrieveStudentsUseCase, UpdateStudentUseCase updateStudentUseCase) {
        this.createStudentUseCase = createStudentUseCase;
        this.deleteStudentUseCase = deleteStudentUseCase;
        this.retrieveStudentsUseCase = retrieveStudentsUseCase;
        this.updateStudentUseCase = updateStudentUseCase;
    }


    @Override
    public Student createStudent(Student student) {
        return createStudentUseCase.createStudent(student);
    }

    @Override
    public void deleteStudent(Long studentId) {
        deleteStudentUseCase.deleteStudent(studentId);
    }

    @Override
    public Optional<Student> getStudent(Long studentId) {
        return retrieveStudentsUseCase.getStudent(studentId);
    }

    @Override
    public List<Student> getAllStudents() {
        return retrieveStudentsUseCase.getAllStudents();
    }

    @Override
    public Optional<Student> updateStudent(Long studentId, Student student) {
        return updateStudentUseCase.updateStudent(studentId, student);
    }
}
