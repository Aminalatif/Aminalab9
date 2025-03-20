package com.example.ManyToMany.repository;
import com.example.ManyToMany.entities.Course;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CourseRepository extends JpaRepository<Course, Long> {
}



