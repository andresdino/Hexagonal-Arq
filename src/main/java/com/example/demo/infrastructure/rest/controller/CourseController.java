package com.example.demo.infrastructure.rest.controller;

import com.example.demo.application.services.Impl.CourseService;
import com.example.demo.domain.models.Course;
import com.example.demo.infrastructure.rest.dto.CourseRequestDto;
import com.example.demo.infrastructure.rest.dto.CourseResponseDto;
import com.example.demo.infrastructure.rest.mapper.CourseMapper;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/api/courses")
public class CourseController {

    private final CourseService courseService;

    public CourseController(CourseService courseService) {
        this.courseService = courseService;
    }


    @GetMapping("/{id}")
    public ResponseEntity<CourseResponseDto> getCourseById(@PathVariable("id") Long id) {
        Optional<Course> course = courseService.getCourse(id);
        return course.map(c -> ResponseEntity.ok(CourseMapper.courseToResponseDto(c)))
                .orElseGet(() -> ResponseEntity.notFound().build());
    }

    @GetMapping
    public ResponseEntity<List<CourseResponseDto>> getAllCourses() {
        List<Course> courses = courseService.getAllCourses();
        return ResponseEntity.ok(courses.stream()
                .map(CourseMapper::courseToResponseDto)
                .collect(Collectors.toList()));
    }

    @PostMapping
    public ResponseEntity<CourseResponseDto> createCourse(@RequestBody CourseRequestDto courseRequestDto) {
        Course course = CourseMapper.requestDtoToModel(courseRequestDto);
        Course createdCourse = courseService.createCourse(course);
        return ResponseEntity.status(HttpStatus.CREATED).body(CourseMapper.courseToResponseDto(createdCourse));
    }

    @PutMapping("/{id}")
    public ResponseEntity<CourseResponseDto> updateCourse(@PathVariable("id") Long id, @RequestBody CourseRequestDto courseRequestDto) {
        Optional<Course> existingCourse = courseService.getCourse(id);
        if (existingCourse.isPresent()) {
            Course course = CourseMapper.requestDtoToModel(courseRequestDto);
            course.setId(id);
            Course updatedCourse = courseService.updateCourse(id,course).orElseThrow();
            return ResponseEntity.ok(CourseMapper.courseToResponseDto(updatedCourse));
        }
        return ResponseEntity.notFound().build();
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteCourse(@PathVariable("id") Long id) {
        courseService.deleteCourse(id);
        return ResponseEntity.noContent().build();
    }
}

