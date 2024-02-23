package com.example.demo.domain.models;

import java.util.List;


public class Course {

    private Long id;
    private String name;
    private String teacher;
    private List<Student> students;

    public Course(Long id, String name, String teacher, List<Student> students) {
        this.id = id;
        this.teacher = teacher;
        this.name = name;
        this.students = students;
    }

    public Course() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getTeacher() {
        return teacher;
    }

    public void setTeacher(String teacher) {
        this.teacher = teacher;
    }

    public List<Student> getStudents() {
        return students;
    }

    public void setStudents(List<Student> students) {
        this.students = students;
    }
}