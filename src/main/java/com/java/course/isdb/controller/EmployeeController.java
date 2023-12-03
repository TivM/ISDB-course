package com.java.course.isdb.controller;

import com.java.course.isdb.dto.request.FireEmployeeRequest;
import com.java.course.isdb.dto.request.HireEmployeeRequest;

import com.java.course.isdb.service.EmployeeService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


@RestController
@RequiredArgsConstructor
@Slf4j
@RequestMapping("employee")
public class EmployeeController {
    private final EmployeeService employeeService;


    @PostMapping("/hire")
    public ResponseEntity<?> addEmployee(@RequestBody HireEmployeeRequest hireEmployeeRequest){
        employeeService.hire(hireEmployeeRequest.name(), hireEmployeeRequest.division(),
                hireEmployeeRequest.age(), hireEmployeeRequest.adminId());
        return ResponseEntity.ok(hireEmployeeRequest.name());
    }

    @DeleteMapping("/fire")
    public ResponseEntity<?> fireEmployee(@RequestBody FireEmployeeRequest fireEmployeeRequest){
        log.info("Removing employee with id {}", fireEmployeeRequest.employeeId());
        employeeService.fire(fireEmployeeRequest.employeeId());
        return ResponseEntity.ok(fireEmployeeRequest.employeeId());
    }


}
