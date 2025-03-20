package com.example.CustomSqlQuery.repository;
import com.example.CustomSqlQuery.entities.Employee;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.data.repository.query.Param;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

@Repository
public interface EmployeeRepository extends JpaRepository<Employee, Long> {

    @Query("SELECT e FROM Employee e WHERE e.salary > :salary")
    List<Employee> findEmployeesWithSalaryGreaterThan(@Param("salary") Double salary);


    @Query(value = "SELECT * FROM employee WHERE salary > :salary", nativeQuery = true)
    List<Employee> findEmployeesBySalary(@Param("salary") Double salary);


    List<Employee> findByName(@Param("name") String name);


    @Modifying
    @Transactional
    @Query("UPDATE Employee e SET e.salary = :salary WHERE e.id = :id")
    void updateEmployeeSalary(@Param("id") Long id, @Param("salary") Double salary);


    @Modifying
    @Transactional
    @Query("DELETE FROM Employee e WHERE e.id = :id")
    void deleteEmployee(@Param("id") Long id);


    @Modifying
    @Transactional
    @Query(value = "INSERT INTO employee (name, salary) VALUES (:name, :salary)", nativeQuery = true)
    void insertEmployee(@Param("name") String name, @Param("salary") Double salary);


    @Query("SELECT COUNT(e) FROM Employee e WHERE e.salary > :salary")
    long countEmployeesWithSalaryGreaterThan(@Param("salary") Double salary);


    @Query("SELECT MAX(e.salary) FROM Employee e")
    Double findMaxSalary();

    // 9️⃣ Get the lowest salary in the table
    @Query("SELECT MIN(e.salary) FROM Employee e")
    Double findMinSalary();


    @Query("SELECT e FROM Employee e WHERE LOWER(e.name) LIKE LOWER(CONCAT('%', :keyword, '%'))")
    List<Employee> findByNameContaining(@Param("keyword") String keyword);
}
