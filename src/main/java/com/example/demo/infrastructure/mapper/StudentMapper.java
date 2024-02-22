package com.example.demo.infrastructure.mapper;

import com.example.demo.infrastructure.dto.request.StudentRequestDto;
import com.example.demo.infrastructure.dto.response.StudentResponseDto;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

@Component
public class StudentMapper {

    private final ModelMapper modelMapper;

    public StudentMapper(ModelMapper modelMapper) {
        this.modelMapper = modelMapper;
    }

    public StudentResponseDto toDto(StudentRequestDto studentRequestDto) {
        return modelMapper.map(studentRequestDto, StudentResponseDto.class);
    }

    public StudentRequestDto toRequestDto(StudentResponseDto studentResponseDto) {
        return modelMapper.map(studentResponseDto, StudentRequestDto.class);
    }
}
