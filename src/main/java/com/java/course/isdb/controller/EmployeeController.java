package com.java.course.isdb.controller;

import com.java.course.isdb.dto.request.FireEmployeeRequest;
import com.java.course.isdb.dto.request.HireEmployeeRequest;

import com.java.course.isdb.dto.response.EmployeeResponse;
import com.java.course.isdb.dto.response.ListEmployeeResponse;
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
    public EmployeeResponse addEmployee(@RequestBody HireEmployeeRequest hireEmployeeRequest){
        return EmployeeResponse.fromEntity(
                employeeService.hire(hireEmployeeRequest.name(), hireEmployeeRequest.division(),
                        hireEmployeeRequest.age(), hireEmployeeRequest.adminId())
        );
    }

    @GetMapping("/all")
    public ListEmployeeResponse getAll(){
        log.info("List all employees");
        return ListEmployeeResponse.fromEntity(employeeService.getAll());
    }

    //need test
    @DeleteMapping("/fire")
    public EmployeeResponse fireEmployee(@RequestBody FireEmployeeRequest fireEmployeeRequest){
        log.info("Removing employee with id {}", fireEmployeeRequest.employeeId());
        return EmployeeResponse.fromEntity(
                employeeService.fire(fireEmployeeRequest.employeeId())
        );
    }


}
