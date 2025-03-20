package com.example.Jpa2.entities;

import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.*;

@Entity
@Table(name = "jpa_laptops")
public class Laptop {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int laptopId;
    private String modelNumber;
    private String brand;
    @JsonBackReference
    @OneToOne
    @JoinColumn(name = "student_id", referencedColumnName = "studentId")
    private Student student;

    // Constructors
    public Laptop() {}

    public Laptop(String modelNumber, String brand, Student student) {
        this.modelNumber = modelNumber;
        this.brand = brand;
        this.student = student;
    }

    // Getters and Setters
    public int getLaptopId() {
        return laptopId;
    }

    public void setLaptopId(int laptopId) {
        this.laptopId = laptopId;
    }

    public String getModelNumber() {
        return modelNumber;
    }

    public void setModelNumber(String modelNumber) {
        this.modelNumber = modelNumber;
    }

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public Student getStudent() {
        return student;
    }

    public void setStudent(Student student) {
        this.student = student;
    }
}
