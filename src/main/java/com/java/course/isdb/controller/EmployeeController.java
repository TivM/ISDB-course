package com.java.course.isdb.controller;

import com.java.course.isdb.dto.request.FireEmployeeRequest;
import com.java.course.isdb.dto.request.HireEmployeeRequest;

import com.java.course.isdb.dto.response.EmployeeResponse;
import com.java.course.isdb.dto.response.ListEmployeeResponse;
import com.java.course.isdb.service.EmployeeService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;


@RestController
@RequiredArgsConstructor
@CrossOrigin
@Slf4j
@RequestMapping("employees")
public class EmployeeController {

    private final EmployeeService employeeService;

    @GetMapping()
    public ListEmployeeResponse getAll(){
        log.info("List all employees");
        return ListEmployeeResponse.fromEntity(employeeService.getAll());
    }

    @DeleteMapping("/{id}")
    public EmployeeResponse fireEmployee(@PathVariable int id){
        log.info("Removing employee with id {}", id);
        return EmployeeResponse.fromEntity(
                employeeService.fire(id)
        );
    }
}
