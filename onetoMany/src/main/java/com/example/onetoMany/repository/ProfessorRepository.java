package com.example.onetoMany.repository;
import com.example.onetoMany.entities.Professor;
import org.springframework.data.jpa.repository.JpaRepository;
public interface ProfessorRepository extends JpaRepository<Professor, Long> {
}
