package com.example.ManyToMany.Service;

import com.example.ManyToMany.DTO.CourseDTO;
import com.example.ManyToMany.entities.Course;
import com.example.ManyToMany.repository.CourseRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class CourseService {
    @Autowired
    private CourseRepository courseRepository;

    private CourseDTO convertToDTO(Course course) {
        CourseDTO dto = new CourseDTO();
        dto.setId(course.getId());
        dto.setTitle(course.getTitle());
        dto.setStudents(course.getStudents().stream().map(student -> student.getName()).collect(Collectors.toSet()));
        return dto;
    }

    public CourseDTO createCourse(Course course) {
        Course savedCourse = courseRepository.save(course);
        return convertToDTO(savedCourse);
    }

    public List<CourseDTO> getAllCourses() {
        return courseRepository.findAll().stream().map(this::convertToDTO).collect(Collectors.toList());
    }

    public CourseDTO getCourseById(Long id) {
        return courseRepository.findById(id).map(this::convertToDTO).orElse(null);
    }
}
