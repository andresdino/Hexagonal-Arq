package com.example.demo.infrastructure.adapter;

import com.example.demo.domain.models.Course;
import com.example.demo.domain.ports.out.CourseRepositoryPort;
import com.example.demo.infrastructure.mapper.CourseEntityMap;
import com.example.demo.infrastructure.entities.CourseEntity;
import com.example.demo.infrastructure.repository.JpaCourseRepository;
import lombok.RequiredArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Repository
@RequiredArgsConstructor
public class JpaCourseRepositoryAdapter implements CourseRepositoryPort {

    private final JpaCourseRepository jpaCourseRepository;
    private final Logger logger = LoggerFactory.getLogger(JpaCourseRepositoryAdapter.class);

    @Override
    public Course save(Course course) {
        logger.info("Saving course with id: {}", course.getId());
        CourseEntity courseEntity = CourseEntityMap.fromDomainModel(course);
        CourseEntity saveCourseEntity = jpaCourseRepository.save(courseEntity);
        logger.info("Course saved successfully with id: {}", saveCourseEntity.getId());
        return CourseEntityMap.toDomainModel(saveCourseEntity);
    }

    @Override
    public Optional<Course> findById(Long courseId) {
        logger.info("Finding course with id: {}", courseId);
        return jpaCourseRepository.findById(courseId).map(courseEntity -> {
            logger.info("Course found with id: {}", courseId);
            return CourseEntityMap.toDomainModel(courseEntity);
        });
    }

    @Override
    public List<Course> findAll() {
        logger.info("Finding all courses");
        Iterable<CourseEntity> courseEntities = jpaCourseRepository.findAll();
        List<CourseEntity> courseEntityList = new ArrayList<>();
        courseEntities.forEach(courseEntityList::add);
        List<Course> courses = courseEntityList.stream().map(CourseEntityMap::toDomainModel).collect(Collectors.toList());
        logger.info("Found {} courses", courses.size());
        return courses;
    }

    @Override
    public Optional<Course> update(Course course) {
        logger.info("Updating course with id: {}", course.getId());
        if (jpaCourseRepository.existsById(course.getId())) {
            CourseEntity courseEntity = CourseEntityMap.fromDomainModel(course);
            CourseEntity updateCourseEntity = jpaCourseRepository.save(courseEntity);
            logger.info("Course updated successfully with id: {}", updateCourseEntity.getId());
            return Optional.of(CourseEntityMap.toDomainModel(updateCourseEntity));
        }
        logger.warn("Course with id {} not found for update", course.getId());
        return Optional.empty();
    }

    @Override
    public void deleteById(Long courseId) {
        logger.info("Deleting course with id: {}", courseId);
        if (jpaCourseRepository.existsById(courseId)) {
            jpaCourseRepository.deleteById(courseId);
            logger.info("Course deleted successfully with id: {}", courseId);
        } else {
            logger.warn("Course with id {} not found for delete", courseId);
        }
    }
}
