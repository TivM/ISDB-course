package com.java.course.isdb.dto.response;

import com.java.course.isdb.entity.Employee;

import java.util.List;

public record ListEmployeeResponse(List<EmployeeResponse> employees) {
    public static ListEmployeeResponse fromEntity(List<Employee> employees) {
        return new ListEmployeeResponse(employees.stream().map(EmployeeResponse::fromEntity).toList());
    }
}
