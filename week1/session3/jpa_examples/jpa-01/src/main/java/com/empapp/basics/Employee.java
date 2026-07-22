package com.empapp.basics;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.util.Date;
// Student			Laptop
@Data
@NoArgsConstructor
@AllArgsConstructor

@Entity
@Table(name = "employee_table0")
public class Employee {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name = "emp_name", nullable = false, length = 100)
    private String name;
    @Column(name = "emp_salary", nullable = false)
    private double salary;
    @Column(name = "emp_dept", nullable = false, length = 100)
    private String dept;


    public Employee(String name, double salary, String dept) {
        this.name = name;
        this.salary = salary;
        this.dept = dept;
    }


}
