package com.example.ManyToMany.DTO;

import java.util.Set;

public class CourseDTO {
    private Long id;
    private String title;
    private Set<String> students;

    // Getters and Setters
    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }

    public String getTitle() { return title; }
    public void setTitle(String title) { this.title = title; }

    public Set<String> getStudents() { return students; }
    public void setStudents(Set<String> students) { this.students = students; }
}
