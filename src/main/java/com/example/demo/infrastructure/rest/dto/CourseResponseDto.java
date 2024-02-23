package com.example.demo.infrastructure.rest.dto;


import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class CourseResponseDto {
    private Long id;
    private String name;
    private String teacher;
    private List<StudentResponseDto> students;
}
