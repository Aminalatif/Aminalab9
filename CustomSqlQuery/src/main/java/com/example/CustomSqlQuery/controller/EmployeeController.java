package com.example.CustomSqlQuery.controller;
import com.example.CustomSqlQuery.entities.Employee;
import com.example.CustomSqlQuery.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/employees")
public class EmployeeController {

    @Autowired
    private EmployeeService employeeService;
    @PostMapping("/add")
    public ResponseEntity<Employee> addEmployee(@RequestBody Employee employee) {
        Employee savedEmployee = employeeService.saveEmployee(employee);
        return ResponseEntity.ok(savedEmployee);
    }

    @GetMapping("/all")
    public ResponseEntity<List<Employee>> getAllEmployees() {
        return ResponseEntity.ok(employeeService.getAllEmployees());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Optional<Employee>> getEmployeeById(@PathVariable Long id) {
        return ResponseEntity.ok(employeeService.getEmployeeById(id));
    }
    @GetMapping("/salaryGreaterThan/{salary}")
    public ResponseEntity<List<Employee>> getEmployeesBySalary(@PathVariable Double salary) {
        return ResponseEntity.ok(employeeService.getEmployeesBySalary(salary));
    }
    @PutMapping("/updateSalary/{id}")
    public ResponseEntity<String> updateSalary(@PathVariable Long id, @RequestParam Double salary) {
        employeeService.updateEmployeeSalary(id, salary);
        return ResponseEntity.ok("Employee salary updated successfully");
    }
    @DeleteMapping("/delete/{id}")
    public ResponseEntity<String> deleteEmployee(@PathVariable Long id) {
        employeeService.deleteEmployee(id);
        return ResponseEntity.ok("Employee deleted successfully");
    }
    @PostMapping("/insert")
    public ResponseEntity<String> insertEmployee(@RequestParam String name, @RequestParam Double salary) {
        employeeService.insertEmployee(name, salary);
        return ResponseEntity.ok("Employee inserted successfully");
    }
    @GetMapping("/countAboveSalary/{salary}")
    public ResponseEntity<Long> countEmployeesWithSalaryGreaterThan(@PathVariable Double salary) {
        return ResponseEntity.ok(employeeService.countEmployeesWithSalaryGreaterThan(salary));
    }

    @GetMapping("/highestSalary")
    public ResponseEntity<Double> getMaxSalary() {
        return ResponseEntity.ok(employeeService.findMaxSalary());
    }

    @GetMapping("/lowestSalary")
    public ResponseEntity<Double> getMinSalary() {
        return ResponseEntity.ok(employeeService.findMinSalary());
    }
    @GetMapping("/searchByName/{keyword}")
    public ResponseEntity<List<Employee>> findEmployeesByName(@PathVariable String keyword) {
        return ResponseEntity.ok(employeeService.findEmployeesByName(keyword));
    }
}
