package com.example.demo.application.mappers;

import com.example.demo.application.dto.request.CourseRequestDto;
import com.example.demo.application.dto.response.CourseResponseDto;
import com.example.demo.application.dto.response.StudentResponseDto;
import com.example.demo.domain.models.Course;
import com.example.demo.domain.models.Student;

import java.util.List;
import java.util.stream.Collectors;

public class CourseMapper {

    public static Course CourseDtoToCourse(CourseRequestDto courseRequestDto) {
        Course course = new Course();
        course.setId(courseRequestDto.getId());
        course.setName(courseRequestDto.getName());
        course.setTeacher(courseRequestDto.getTeacher());

        List<Student> students = courseRequestDto.getStudents().stream()
                .map(studentDto -> {
                    Student student = new Student();
                    student.setId(studentDto.getId());
                    student.setName(studentDto.getName());
                    student.setCourseId(studentDto.getCourseId());
                    return student;
                })
                .collect(Collectors.toList());

        course.setStudents(students);
        return course;
    }

    public static CourseResponseDto CourseToCourseDto(Course course) {
        CourseResponseDto courseResponseDto = new CourseResponseDto();
        courseResponseDto.setId(course.getId());
        courseResponseDto.setName(course.getName());
        courseResponseDto.setTeacher(course.getTeacher());

        List<StudentResponseDto> studentResponseDtos = course.getStudents().stream()
                .map(student -> {
                    StudentResponseDto studentResponseDto = new StudentResponseDto();
                    studentResponseDto.setId(student.getId());
                    studentResponseDto.setName(student.getName());
                    studentResponseDto.setCourseId(student.getCourseId());
                    return studentResponseDto;
                })
                .collect(Collectors.toList());

        courseResponseDto.setStudents(studentResponseDtos);
        return courseResponseDto;
    }
}