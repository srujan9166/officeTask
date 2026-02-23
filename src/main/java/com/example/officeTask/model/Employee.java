package com.example.officeTask.model;

import java.time.LocalDate;

import com.example.officeTask.enums.EmployeeStatus;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.EnumeratedValue;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;
import jakarta.validation.constraints.Min;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "employees")

public class Employee {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long employee_id;

    @Column(nullable = false)
    private String name;

    @Column(nullable = false, unique = true)
    private String email;

    @ManyToOne
    @JoinColumn(name = "department_id")
    private Department department;

    private String designation;

    private LocalDate joiningDate;

    @Min(value = 1, message = "Salary must be greater than 0")
    @Column(nullable = false)
    private Double salary;
    @Enumerated(EnumType.STRING)
    private EmployeeStatus status;

    @OneToOne
    @JoinColumn(name = "manager_id")
    private Employee manager;

   

    




}
