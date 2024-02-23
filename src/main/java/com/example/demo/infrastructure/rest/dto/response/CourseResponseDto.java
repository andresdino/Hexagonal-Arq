package com.example.demo.infrastructure.rest.dto.response;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.io.Serializable;
import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class CourseResponseDto implements Serializable {
    Long id;
    String name;
    String teacher;
    List<StudentResponseDto> students;
}