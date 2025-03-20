package com.example.onetoMany.service;
import com.example.onetoMany.DTO.CourseDTO;
import com.example.onetoMany.entities.Course;
import com.example.onetoMany.entities.Professor;
import com.example.onetoMany.repository.CourseRepository;
import com.example.onetoMany.repository.ProfessorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.stream.Collectors;
@Service
public class CourseService {
    @Autowired
    private CourseRepository courseRepository;
    @Autowired
    private ProfessorRepository professorRepository;
    public Course saveCourse(CourseDTO courseDTO) {
        Course course = new Course();
        course.setTitle(courseDTO.getTitle());
        course.setDescription(courseDTO.getDescription());
        Professor professor = professorRepository.findById(courseDTO.getProfessorId())
                .orElseThrow(() -> new RuntimeException("Professor not found"));
        course.setProfessor(professor);
        return courseRepository.save(course);}
    public List<CourseDTO> getCoursesByProfessor(Long professorId) {
        List<Course> courses = courseRepository.findByProfessorId(professorId);
        return courses.stream().map(course -> new CourseDTO(
                course.getId(),
                course.getTitle(),
                course.getDescription(),
                course.getProfessor().getId()
        )).collect(Collectors.toList());}}
