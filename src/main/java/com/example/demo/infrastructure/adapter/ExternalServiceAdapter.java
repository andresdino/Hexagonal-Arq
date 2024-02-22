package com.example.demo.infrastructure.adapter;

import com.example.demo.domain.models.Student;
import com.example.demo.domain.ports.out.ExternalServicePort;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ExternalServiceAdapter  implements ExternalServicePort {

    private final ExternalServicePort externalServicePort;

    public ExternalServiceAdapter(ExternalServicePort externalServicePort) {
        this.externalServicePort = externalServicePort;
    }


    @Override
    public List<Student> getStudentsByCourseId(Long CourseId) {
        return externalServicePort.getStudentsByCourseId(CourseId);
    }
}
