package com.example.demo.infrastructure.rest.mapper;

import com.example.demo.domain.models.Course;
import com.example.demo.infrastructure.entities.CourseEntity;
import org.modelmapper.ModelMapper;

public class CourseMapper {

    private static final ModelMapper modelMapper = new ModelMapper();

    public static CourseEntity fromDomainModel(Course course) {
        return modelMapper.map(course, CourseEntity.class);
    }

    public static Course toDomainModel(CourseEntity courseEntity) {
        return modelMapper.map(courseEntity, Course.class);
    }

}
