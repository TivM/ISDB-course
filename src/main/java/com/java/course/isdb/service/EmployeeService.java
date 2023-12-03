package com.java.course.isdb.service;

import org.springframework.stereotype.Service;


public interface EmployeeService {

    void hire(String employeeName, String employeeDivision, int employeeAge, int employeeAdminId);

    void fire(int employeeId);
}
