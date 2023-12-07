package com.java.course.isdb.service;

import com.java.course.isdb.entity.Employee;
import org.springframework.stereotype.Service;

import java.util.List;


public interface EmployeeService {

    Employee hire(String employeeName, String employeeDivision, int employeeAge, int employeeAdminId);

    Employee fire(int employeeId);

    List<Employee> getAll();
}
