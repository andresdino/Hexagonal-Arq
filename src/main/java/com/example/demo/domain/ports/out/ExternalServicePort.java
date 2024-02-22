package com.example.demo.domain.ports.out;


import com.example.demo.domain.models.Student;

import java.util.List;

public interface ExternalServicePort {

    List<Student> getStudentsByCourseId(Long CourseId);

}
