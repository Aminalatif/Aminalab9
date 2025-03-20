package com.example.ManyToMany.DTO;

import java.util.Set;

public class StudentDTO {
    private Long id;
    private String name;
    private Set<String> courses;

    // Getters and Setters
    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }

    public String getName() { return name; }
    public void setName(String name) { this.name = name; }

    public Set<String> getCourses() { return courses; }
    public void setCourses(Set<String> courses) { this.courses = courses; }
}
