package com.example.demo.infrastructure.adapter;

import com.example.demo.domain.models.Course;
import com.example.demo.domain.ports.CourseRepository;
import com.example.demo.infrastructure.adapter.repository.JpaCourseRepository;
import com.example.demo.infrastructure.entities.CourseEntity;
import com.example.demo.infrastructure.rest.mapper.CourseMapper;
import lombok.RequiredArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Repository
@RequiredArgsConstructor
public class JpaCourseRepositoryAdapter implements CourseRepository {

    private final JpaCourseRepository jpaCourseRepository;
    private final Logger logger = LoggerFactory.getLogger(JpaCourseRepositoryAdapter.class);

    @Override
    public Course createCourse(Course course) {
        CourseEntity courseEntity = CourseMapper.modelToEntity(course);
        CourseEntity savedCourseEntity = jpaCourseRepository.save(courseEntity);
        logger.info("Creating course with id: {}", savedCourseEntity.toString());
        return CourseMapper.entityToModel(savedCourseEntity);
    }

    @Override
    public Optional<Course> getCourse(Long courseId) {
        logger.info("Getting course with id: {}", courseId);
        return jpaCourseRepository.findById(courseId).map(CourseMapper::entityToModel);
    }

    @Override
    public List<Course> getAllCourses() {
        logger.info("Getting all courses");
        Iterable<CourseEntity> courseEntities = jpaCourseRepository.findAll();
        List<Course> courses = new ArrayList<>();
        courseEntities.forEach(courseEntity -> courses.add(CourseMapper.entityToModel(courseEntity)));
        logger.info("Found {} courses", courses.size());
        return courses;
    }

    @Override
    public Optional<Course> updateCourse(Long courseId, Course course) {
        logger.info("Updating course with id: {}", courseId);
        if (jpaCourseRepository.existsById(courseId)) {
            CourseEntity courseEntity = CourseMapper.modelToEntity(course);
            courseEntity.setId(courseId);
            CourseEntity updatedCourseEntity = jpaCourseRepository.save(courseEntity);
            logger.info("Course updated successfully with id: {}", updatedCourseEntity.getId());
            return Optional.of(CourseMapper.entityToModel(updatedCourseEntity));
        }
        logger.warn("Course with id {} not found for update", courseId);
        return Optional.empty();
    }

    @Override
    public void deleteCourse(Long courseId) {
        logger.info("Deleting course with id: {}", courseId);
        if (jpaCourseRepository.existsById(courseId)) {
            jpaCourseRepository.deleteById(courseId);
            logger.info("Course deleted successfully with id: {}", courseId);
        } else {
            logger.warn("Course with id {} not found for delete", courseId);
        }
    }
}