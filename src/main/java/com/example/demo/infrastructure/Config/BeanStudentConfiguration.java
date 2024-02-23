package com.example.demo.infrastructure.Config;

import com.example.demo.application.services.Impl.StudentService;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class BeanStudentConfiguration {

    @Bean
    StudentService studentBeanService(final StudentService studentService){
        return null; //new StudentService();
    }
}
