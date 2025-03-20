package com.example.onetoMany.DTO;
public class ProfessorDTO {
    private Long id;
    private String name;
    public ProfessorDTO() {}
    public ProfessorDTO(Long id, String name) {
        this.id = id;
        this.name = name;
    }
    public Long getId() {
        return id;
    }
    public String getName() {
        return name;
    }
    public void setId(Long id) {
        this.id = id;
    }
    public void setName(String name) {
        this.name = name;
    }}
