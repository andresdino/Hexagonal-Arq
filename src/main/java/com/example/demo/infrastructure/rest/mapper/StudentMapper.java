package com.example.demo.infrastructure.rest.mapper;

import com.example.demo.domain.models.Student;
import com.example.demo.infrastructure.entities.StudentEntity;
import org.modelmapper.ModelMapper;

public class StudentMapper {

    private static final ModelMapper modelMapper = new ModelMapper();

    public static StudentEntity fromDomainModel(Student student){
        return modelMapper.map(student, StudentEntity.class);
    }

    public static Student toDomainModel(StudentEntity studentEntity){
        return modelMapper.map(studentEntity, Student.class);
    }

}
