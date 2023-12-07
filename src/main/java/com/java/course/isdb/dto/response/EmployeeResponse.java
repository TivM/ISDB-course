package com.java.course.isdb.dto.response;

import com.java.course.isdb.dto.request.HireEmployeeRequest;
import com.java.course.isdb.entity.Employee;

public record EmployeeResponse(String name, int age, String division, int adminId) {
    public static EmployeeResponse fromEntity(Employee employee){
        return new EmployeeResponse(employee.getName(), employee.getAge(), employee.getDivision(), employee.getAdmin().getId());
    }
}
