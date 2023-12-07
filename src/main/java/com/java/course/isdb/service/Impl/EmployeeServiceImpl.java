package com.java.course.isdb.service.Impl;

import com.java.course.isdb.entity.Admin;
import com.java.course.isdb.entity.Employee;
import com.java.course.isdb.exception.ResourceNotFoundException;
import com.java.course.isdb.repository.AdminRepository;
import com.java.course.isdb.repository.EmployeeRepository;
import com.java.course.isdb.service.EmployeeService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@RequiredArgsConstructor
public class EmployeeServiceImpl implements EmployeeService {

    private final EmployeeRepository employeeRepository;
    private final AdminRepository adminRepository;

    @Override
    @Transactional
    public Employee hire(String employeeName, String employeeDivision, int employeeAge, int employeeAdminId) {
        Employee employee = new Employee()
                .setName(employeeName)
                .setDivision(employeeDivision)
                .setAge(employeeAge);
        Admin admin = adminRepository.findById(employeeAdminId).orElseThrow(
                () -> new ResourceNotFoundException("admin doesn't exist")
        );
        admin.addEmployee(employee);
        employeeRepository.hireEmployee(employeeName,
                employeeDivision, employeeAge, employeeAdminId);

        return employee;
    }

    @Override
    @Transactional
    public Employee fire(int employeeId) {
        Employee employee = employeeRepository.findById(employeeId).orElseThrow(
                () -> new ResourceNotFoundException("employee doesn't exist")
        );

        employeeRepository.fireEmployee(employee.getId());

        return employee;
    }

    @Override
    public List<Employee> getAll() {
        return employeeRepository.findAll();
    }
}
