package com.example.onetoMany.entities;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
@Setter
@Getter
@Entity
@Table(name = "course")
public class Course { @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "course_id")
    private Long id;
    @Column(name = "title")
    private String title;
    @Column(name = "description")
    private String description;
    @ManyToOne
    @JoinColumn(name = "professor_id")
    private Professor professor;
    public Course() {}
    public Course(String title, String description, Professor professor) {
        this.title = title;
        this.description = description;
        this.professor = professor;}}
