package com.example.ManyToMany.Service;

import com.example.ManyToMany.DTO.StudentDTO;
import com.example.ManyToMany.entities.Student;
import com.example.ManyToMany.repository.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class StudentService {
    @Autowired
    private StudentRepository studentRepository;

    private StudentDTO convertToDTO(Student student) {
        StudentDTO dto = new StudentDTO();
        dto.setId(student.getId());
        dto.setName(student.getName());
        dto.setCourses(student.getCourses().stream().map(course -> course.getTitle()).collect(Collectors.toSet()));
        return dto;
    }

    public StudentDTO createStudent(Student student) {
        Student savedStudent = studentRepository.save(student);
        return convertToDTO(savedStudent);
    }

    public List<StudentDTO> getAllStudents() {
        return studentRepository.findAll().stream().map(this::convertToDTO).collect(Collectors.toList());
    }

    public StudentDTO getStudentById(Long id) {
        return studentRepository.findById(id).map(this::convertToDTO).orElse(null);
    }
}
