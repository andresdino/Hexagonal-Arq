package com.example.demo.application.dto.request;

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
public class CourseRequestDto implements Serializable {
    Long id;
    String name;
    String teacher;
    List<StudentRequestDto> students;
}