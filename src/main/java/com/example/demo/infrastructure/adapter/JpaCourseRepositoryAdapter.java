package com.example.demo.infrastructure.adapter;

import com.example.demo.domain.models.Course;
import com.example.demo.domain.ports.out.CourseRepositoryPort;
import com.example.demo.infrastructure.Mapper.CourseEntityMap;
import com.example.demo.infrastructure.entities.CourseEntity;
import com.example.demo.infrastructure.repository.JpaCourseRepository;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;


@Repository
public class JpaCourseRepositoryAdapter implements CourseRepositoryPort {

    private final JpaCourseRepository jpaCourseRepository;

    public JpaCourseRepositoryAdapter(JpaCourseRepository jpaCourseRepository) {
        this.jpaCourseRepository = jpaCourseRepository;
    }

    @Override
    public Course save(Course course) {
        CourseEntity courseEntity = CourseEntityMap.fromDomainModel(course);
        CourseEntity saveCourseEntity = jpaCourseRepository.save(courseEntity);
        return CourseEntityMap.toDomainModel(saveCourseEntity);
    }

    @Override
    public Optional<Course> findById(Long courseId) {
        return jpaCourseRepository.findById(courseId).map(CourseEntityMap::toDomainModel);
    }

    @Override
    public List<Course> findAll() {
        Iterable<CourseEntity> courseEntities = jpaCourseRepository.findAll();
        List<CourseEntity> courseEntityList = new ArrayList<>();
        courseEntities.forEach(courseEntityList::add);
        return courseEntityList.stream().map(CourseEntityMap::toDomainModel).collect(Collectors.toList());
    }

    @Override
    public Optional<Course> update(Course course) {
        if (jpaCourseRepository.existsById(course.getId())){
            CourseEntity courseEntity = CourseEntityMap.fromDomainModel(course);
            CourseEntity updateCourseEntity = jpaCourseRepository.save(courseEntity);
            return Optional.of(CourseEntityMap.toDomainModel(courseEntity));
        }
        return Optional.empty();
    }

    @Override
    public void deleteById(Long courseId) {
        if (jpaCourseRepository.existsById(courseId)){
            jpaCourseRepository.deleteById(courseId);
        }
    }
}
