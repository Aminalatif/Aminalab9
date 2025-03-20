package com.example.Jpa2.controller;

import com.example.Jpa2.entities.Laptop;
import com.example.Jpa2.entities.Student;
import com.example.Jpa2.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/students")
public class StudentController {
    @Autowired
    private StudentService studentService;

    // Create a student with a laptop
    @PostMapping
    public Student createStudent(@RequestBody Student student) {
        if (student.getLaptop() != null) {
            student.getLaptop().setStudent(student); // Set bidirectional mapping
        }
        return studentService.saveStudent(student);
    }

    // Get all students
    @GetMapping
    public List<Student> getAllStudents() {
        return studentService.getAllStudents();
    }

    // Get student by ID
    @GetMapping("/{id}")
    public Optional<Student> getStudentById(@PathVariable int id) {
        return studentService.getStudentById(id);
    }
}
