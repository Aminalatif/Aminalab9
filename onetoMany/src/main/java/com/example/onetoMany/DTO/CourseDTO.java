package com.example.onetoMany.DTO;
import lombok.Getter;
import lombok.Setter;
@Setter
@Getter
public class CourseDTO {
    private Long id;
    private String title;
    private String description;
    private Long professorId;
    public CourseDTO() {}
    public CourseDTO(Long id,String title,String description,Long professorId) {
        this.id = id;
        this.title = title;
        this.description = description;
        this.professorId = professorId;
    }}
