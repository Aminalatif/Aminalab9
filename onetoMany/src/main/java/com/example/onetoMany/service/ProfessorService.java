package com.example.onetoMany.service;
import com.example.onetoMany.DTO.ProfessorDTO;
import com.example.onetoMany.DTO.CourseDTO;
import com.example.onetoMany.entities.Professor;
import com.example.onetoMany.entities.Course;
import com.example.onetoMany.repository.ProfessorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
@Service
public class ProfessorService {
    @Autowired
    private ProfessorRepository professorRepository;
    public ProfessorDTO getProfessorById(Long id) {
        Optional<Professor> professor = professorRepository.findById(id);
        if (professor.isPresent()) {
            return new ProfessorDTO(professor.get().getId(), professor.get().getName());} else {
            throw new RuntimeException("Professor not found with id: " + id);}}
    public ProfessorDTO saveProfessor(Professor professor) {
        Professor savedProfessor = professorRepository.save(professor);
        return new ProfessorDTO(savedProfessor.getId(), savedProfessor.getName());}
    public List<ProfessorDTO> getAllProfessors() {
        List<Professor> professors = professorRepository.findAll();
        return professors.stream()
                .map(prof -> new ProfessorDTO(prof.getId(), prof.getName()))
                .collect(Collectors.toList());}
    public List<CourseDTO> getCoursesByProfessor(Long id) {
        Professor professor = professorRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Professor not found with id: " + id));
        return professor.getCourses().stream()
                .map(course -> new CourseDTO())
                .collect(Collectors.toList());}}
