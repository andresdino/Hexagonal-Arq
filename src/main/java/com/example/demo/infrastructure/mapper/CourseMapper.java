package com.example.demo.infrastructure.mapper;

import com.example.demo.infrastructure.dto.request.CourseRequestDto;
import com.example.demo.infrastructure.dto.response.CourseResponseDto;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

@Component
public class CourseMapper {

    private final ModelMapper modelMapper;

    public CourseMapper(ModelMapper modelMapper) {
        this.modelMapper = modelMapper;
    }

    public CourseResponseDto toDto(CourseRequestDto courseRequestDto) {
        return modelMapper.map(courseRequestDto, CourseResponseDto.class);
    }

    public CourseRequestDto toRequestDto(CourseResponseDto courseResponseDto) {
        return modelMapper.map(courseResponseDto, CourseRequestDto.class);
    }
}
