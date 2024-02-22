package com.example.demo.infrastructure.dto.response;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.io.Serializable;
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class StudentResponseDto implements Serializable {
    Long id;
    String name;
    Long courseId;
}