package com.example.demo.infrastructure.rest.mapper;

import com.example.demo.domain.models.Student;
import com.example.demo.infrastructure.entities.StudentEntity;
import com.example.demo.infrastructure.rest.dto.StudentRequestDto;
import com.example.demo.infrastructure.rest.dto.StudentResponseDto;
import org.modelmapper.ModelMapper;
import org.modelmapper.PropertyMap;

public class StudentMapper {

    private static final ModelMapper modelMapper = new ModelMapper();

    public static StudentEntity modelToEntity(Student student){
        return modelMapper.map(student, StudentEntity.class);
    }

    public static Student entityToModel(StudentEntity studentEntity){
        return modelMapper.map(studentEntity, Student.class);
    }

    public static Student requestDtoToModel(StudentRequestDto studentRequestDto) {
        Student student = new Student();
        student.setName(studentRequestDto.getName());
        student.setCourseId(studentRequestDto.getCourseId());
        return student;
    }

    public static StudentResponseDto studentToResponseDto(Student student) {
        StudentResponseDto studentResponseDto = new StudentResponseDto();
        studentResponseDto.setId(student.getId());
        studentResponseDto.setName(student.getName());
        studentResponseDto.setCourseId(student.getCourseId());
        return studentResponseDto;
    }

}
