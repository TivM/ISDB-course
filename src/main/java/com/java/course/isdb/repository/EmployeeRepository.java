package com.java.course.isdb.repository;

import com.java.course.isdb.entity.Employee;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.query.Procedure;
import org.springframework.stereotype.Repository;

import java.util.List;


@Repository
public interface EmployeeRepository extends JpaRepository<Employee, Integer> {

    @Procedure(procedureName = "hire_employee")
    void hireEmployee(String employeeName, String employeeDivision, int employeeAge, int employeeAdminId);

    @Procedure(procedureName = "fire_employee")
    void fireEmployee(int employeeId);

    List<Employee> findByDivision(String division);
}
