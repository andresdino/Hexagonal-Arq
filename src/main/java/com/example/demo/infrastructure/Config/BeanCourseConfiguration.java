package com.example.demo.infrastructure.Config;

import com.example.demo.application.services.Impl.CourseService;
import com.example.demo.domain.ports.CourseRepository;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class BeanCourseConfiguration {

    @Bean
    CourseService courseBeanService(final CourseRepository courseRepository){
        return null; // new CourseService();
    }
}
