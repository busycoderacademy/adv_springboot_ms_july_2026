package com.empapp.basics;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

//how hib come to know about this class
//actually hibernate manage the life cycle of object
//entity -> pojo with @Enitity @Id
@Data
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode
//What is entity : object whose life cycle mangage by hibernate
@Entity
@Table(name="employee_table")
public class Employee {

    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private int id;


    @Column(name="emp_name", nullable = false)
    private String name;

    @Column(name="emp_salary", nullable = false)
    private double salary;

    @Column(name="emp_dept", nullable = false)
    private String dept;

    public Employee(String name, double salary, String dept) {
        this.name = name;
        this.salary = salary;
        this.dept = dept;
    }
}
