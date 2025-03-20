package com.example.onetoMany.controller;
import com.example.onetoMany.DTO.ProfessorDTO;
import com.example.onetoMany.DTO.CourseDTO;
import com.example.onetoMany.entities.Professor;
import com.example.onetoMany.service.ProfessorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.List;
@RestController
@RequestMapping("/professors")
public class ProfessorController {
    @Autowired
    private ProfessorService professorService;
    @GetMapping
    public List<ProfessorDTO> getAllProfessors() {
        return professorService.getAllProfessors();}
    @GetMapping("/{id}")
    public ProfessorDTO getProfessorById(@PathVariable Long id) {
        return professorService.getProfessorById(id);}
    @PostMapping
    public ProfessorDTO saveProfessor(@RequestBody Professor professor) {
        return professorService.saveProfessor(professor);}
    @GetMapping("/{id}/courses")
    public List<CourseDTO> getCoursesByProfessor(@PathVariable Long id) {
        return professorService.getCoursesByProfessor(id);}}
