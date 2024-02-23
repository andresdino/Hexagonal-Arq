package com.example.demo.infrastructure.rest.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class StudentRequestDto {
    private String name;
    private Long course;
}
