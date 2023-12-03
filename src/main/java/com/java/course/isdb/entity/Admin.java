package com.java.course.isdb.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import lombok.experimental.Accessors;

import java.util.HashSet;
import java.util.Set;

@Getter
@Setter
@Entity
@Table(name = "admin")
@Accessors(chain = true)
public class Admin {

    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "name", nullable = false)
    private String name;

    @Column(name = "age", nullable = false)
    private Integer age;

    @Column(name = "division")
    private String division;

    @OneToMany(mappedBy = "admin")
    private Set<Employee> employees = new HashSet<>();

    @OneToMany(mappedBy = "admin")
    private Set<ProductivityStatistics> productivityStatisticsSet = new HashSet<>();

    public void addEmployee(Employee employee) {
        employees.add(employee);
        employee.setAdmin(this);
    }
}
