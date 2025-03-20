package com.example.onetoMany.controller;
import com.example.onetoMany.DTO.CourseDTO;
import com.example.onetoMany.entities.Course;
import com.example.onetoMany.service.CourseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.List;
@RestController
@RequestMapping("/courses")
public class CourseController {
    @Autowired
    private CourseService courseService;

    @PostMapping("/add")
    public Course addCourse(@RequestBody CourseDTO courseDTO) {
        return courseService.saveCourse(courseDTO);
    }
    @GetMapping("/professor/{professorId}")
    public List<CourseDTO> getCoursesByProfessor(@PathVariable Long professorId) {
        return courseService.getCoursesByProfessor(professorId);
    }
}

