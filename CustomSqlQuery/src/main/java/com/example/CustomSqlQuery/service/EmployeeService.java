package com.example.CustomSqlQuery.service;

import com.example.CustomSqlQuery.entities.Employee;
import com.example.CustomSqlQuery.repository.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import java.util.List;
import java.util.Optional;

@Service
public class EmployeeService {

    @Autowired
    private EmployeeRepository employeeRepository;

    public Employee saveEmployee(Employee employee) {
        return employeeRepository.save(employee);
    }

    public List<Employee> getAllEmployees() {
        return employeeRepository.findAll();
    }

    public Optional<Employee> getEmployeeById(Long id) {
        return employeeRepository.findById(id);
    }

    public List<Employee> getEmployeesBySalary(Double salary) {
        return employeeRepository.findEmployeesBySalary(salary);
    }

    @Transactional
    public void updateEmployeeSalary(Long id, Double salary) {
        employeeRepository.updateEmployeeSalary(id, salary);
    }

    @Transactional
    public void deleteEmployee(Long id) {
        employeeRepository.deleteEmployee(id);
    }

    @Transactional
    public void insertEmployee(String name, Double salary) {
        employeeRepository.insertEmployee(name, salary);
    }

    public long countEmployeesWithSalaryGreaterThan(Double salary) {
        return employeeRepository.countEmployeesWithSalaryGreaterThan(salary);
    }

    public Double findMaxSalary() {
        return employeeRepository.findMaxSalary();
    }

    public Double findMinSalary() {
        return employeeRepository.findMinSalary();
    }

    public List<Employee> findEmployeesByName(String keyword) {
        return employeeRepository.findByNameContaining(keyword);
    }
}
