package com.example.demo.application.mappers;

import com.example.demo.application.dto.request.StudentRequestDto;
import com.example.demo.application.dto.response.StudentResponseDto;
import com.example.demo.domain.models.Student;

public class StudentMapper {

    public static Student mapToStudent(StudentRequestDto studentRequestDto) {
        Student student = new Student();
        student.setId(studentRequestDto.getId());
        student.setName(studentRequestDto.getName());
        student.setCourseId(studentRequestDto.getCourseId());

        return student;
    }

    public static StudentResponseDto mapToStudentResponseDto(Student student) {
        StudentResponseDto studentResponseDto = new StudentResponseDto();
        studentResponseDto.setId(student.getId());
        studentResponseDto.setName(student.getName());
        studentResponseDto.setCourseId(student.getCourseId());

        return studentResponseDto;
    }
}
