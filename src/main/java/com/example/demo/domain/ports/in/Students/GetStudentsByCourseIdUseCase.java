package com.example.demo.domain.ports.in.Students;

import com.example.demo.domain.models.Student;

import java.util.List;

public interface GetStudentsByCourseIdUseCase {

    List<Student> getStudentsByCourseId(Long courseId);
}
