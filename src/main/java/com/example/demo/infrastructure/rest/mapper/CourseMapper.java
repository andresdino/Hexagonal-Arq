package com.example.demo.infrastructure.rest.mapper;

import com.example.demo.domain.models.Course;
import com.example.demo.infrastructure.entities.CourseEntity;
import com.example.demo.infrastructure.rest.dto.CourseRequestDto;
import com.example.demo.infrastructure.rest.dto.CourseResponseDto;
import org.modelmapper.ModelMapper;

import java.util.stream.Collectors;

public class CourseMapper {

    private static final ModelMapper modelMapper = new ModelMapper();

    public static CourseEntity modelToEntity(Course course) {
        return modelMapper.map(course, CourseEntity.class);
    }

    public static Course entityToModel(CourseEntity courseEntity) {
        return modelMapper.map(courseEntity, Course.class);
    }

    public static Course requestDtoToModel(CourseRequestDto courseRequestDto){
        Course course = new Course();
        course.setName(courseRequestDto.getName());
        course.setTeacher(courseRequestDto.getTeacher());
        return course;
    }

    public static CourseResponseDto courseToResponseDto(Course course){
        CourseResponseDto courseResponseDto = new CourseResponseDto();
        courseResponseDto.setId(course.getId());
        courseResponseDto.setName(course.getName());
        courseResponseDto.setTeacher(course.getTeacher());
        if (course.getStudents() != null){
            courseResponseDto.setStudents(
                    course.getStudents()
                            .stream()
                            .map(StudentMapper::studentToResponseDto)
                            .collect(Collectors.toList()));
        }
        return courseResponseDto;
    }



}
