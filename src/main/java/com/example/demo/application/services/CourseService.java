package com.example.demo.application.services;

import com.example.demo.domain.models.Course;
import com.example.demo.domain.ports.in.Courses.CreateCourseUseCase;
import com.example.demo.domain.ports.in.Courses.DeleteCourseUseCase;
import com.example.demo.domain.ports.in.Courses.RetrieveCoursesUseCase;
import com.example.demo.domain.ports.in.Courses.UpdateCourseUseCase;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CourseService implements CreateCourseUseCase, DeleteCourseUseCase, RetrieveCoursesUseCase, UpdateCourseUseCase {

    private final CreateCourseUseCase createCourseUseCase;
    private final DeleteCourseUseCase deleteCourseUseCase;
    private final RetrieveCoursesUseCase retrieveCoursesUseCase;
    private final UpdateCourseUseCase updateCourseUseCase;

    public CourseService(CreateCourseUseCase createCourseUseCase, DeleteCourseUseCase deleteCourseUseCase, RetrieveCoursesUseCase retrieveCoursesUseCase, UpdateCourseUseCase updateCourseUseCase) {
        this.createCourseUseCase = createCourseUseCase;
        this.deleteCourseUseCase = deleteCourseUseCase;
        this.retrieveCoursesUseCase = retrieveCoursesUseCase;
        this.updateCourseUseCase = updateCourseUseCase;
    }

    @Override
    public Course createCourse(Course course) {
        return createCourseUseCase.createCourse(course);
    }

    @Override
    public void deleteCourse(Long courseId) {
        deleteCourseUseCase.deleteCourse(courseId);
    }

    @Override
    public Optional<Course> getCourse(Long courseId) {
        return retrieveCoursesUseCase.getCourse(courseId);
    }

    @Override
    public List<Course> getAllCourses() {
        return retrieveCoursesUseCase.getAllCourses();
    }

    @Override
    public Optional<Course> updateCourse(Long courseId, Course course) {
        return updateCourseUseCase.updateCourse(courseId, course);
    }
}
