package com.example.demo.application.mappers;

import com.example.demo.application.dto.request.CourseRequestDto;
import com.example.demo.application.dto.response.CourseResponseDto;
import com.example.demo.application.dto.response.StudentResponseDto;
import com.example.demo.domain.models.Course;
import com.example.demo.domain.models.Student;
import org.modelmapper.ModelMapper;
import org.modelmapper.TypeToken;

import java.lang.reflect.Type;
import java.util.List;
import java.util.stream.Collectors;

public class CourseMapper {

    private static final ModelMapper modelMapper = new ModelMapper();

    public static Course mapToCourse(CourseRequestDto courseRequestDto) {
        return modelMapper.map(courseRequestDto, Course.class);
    }

    public static CourseResponseDto mapToCourseResponseDto(Course course) {
        return modelMapper.map(course, CourseResponseDto.class);
    }

    public static List<CourseResponseDto> mapToCourseResponseDtoList(List<Course> courses) {
        Type listType = new TypeToken<List<CourseResponseDto>>(){}.getType();
        return modelMapper.map(courses, listType);
    }

    public static List<StudentResponseDto> mapToStudentResponseDtoList(List<Student> students) {
        Type listType = new TypeToken<List<StudentResponseDto>>(){}.getType();
        return modelMapper.map(students, listType);
    }
}
