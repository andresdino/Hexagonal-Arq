package com.example.demo.infrastructure.mapper;

import com.example.demo.domain.models.Student;
import com.example.demo.infrastructure.entities.StudentEntity;
import lombok.Getter;
import lombok.Setter;
import org.modelmapper.ModelMapper;

@Getter
@Setter
public class StudentEntityMap {

    private static final ModelMapper modelMapper = new ModelMapper();

    public static StudentEntity fromDomainModel(Student student){
        return modelMapper.map(student, StudentEntity.class);
    }

    public static Student toDomainModel(StudentEntity studentEntity){
        return modelMapper.map(studentEntity, Student.class);
    }

}
