package com.example.demo.infrastructure.rest.mapper;

import com.example.demo.domain.models.Student;
import com.example.demo.infrastructure.entities.StudentEntity;
import com.example.demo.infrastructure.rest.dto.StudentRequestDto;
import com.example.demo.infrastructure.rest.dto.StudentResponseDto;
import org.modelmapper.ModelMapper;

public class StudentMapper {

    private static final ModelMapper modelMapper = new ModelMapper();

    public static StudentEntity fromDomainModel(Student student){
        return modelMapper.map(student, StudentEntity.class);
    }

    public static Student toDomainModel(StudentEntity studentEntity){
        return modelMapper.map(studentEntity, Student.class);
    }

    public static Student toEntity(StudentRequestDto studentRequestDto) {
        Student student = new Student();
        student.setName(studentRequestDto.getName());
        student.setCourse(studentRequestDto.getCourse());
        return student;
    }

    public static StudentResponseDto toDto(Student student) {
        StudentResponseDto studentResponseDto = new StudentResponseDto();
        studentResponseDto.setId(student.getId());
        studentResponseDto.setName(student.getName());
        studentResponseDto.setCourse(student.getCourse());
        return studentResponseDto;
    }

}
