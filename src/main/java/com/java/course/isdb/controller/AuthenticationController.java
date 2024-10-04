package com.java.course.isdb.controller;

import com.java.course.isdb.controller.auth.AuthenticationRequest;
import com.java.course.isdb.controller.auth.AuthenticationResponse;
import com.java.course.isdb.dto.request.AddAdminRequest;
import com.java.course.isdb.dto.request.HireEmployeeRequest;
import com.java.course.isdb.service.AuthenticationService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/auth")
@RequiredArgsConstructor
public class AuthenticationController {

    private final AuthenticationService service;

    @PostMapping("/admin")
    public ResponseEntity<AuthenticationResponse> adminRegister(
            @RequestBody AddAdminRequest request
    ) {
        return ResponseEntity.ok(service.adminRegister(request));
    }

    @PostMapping("/employee")
    public ResponseEntity<AuthenticationResponse> employeeRegister(
            @RequestBody HireEmployeeRequest request
    ) {
        return ResponseEntity.ok(service.employeeRegister(request));
    }

    @PostMapping("/authenticate")
    public ResponseEntity<AuthenticationResponse> authenticate(
            @RequestBody AuthenticationRequest request
    ) {
        return ResponseEntity.ok(service.authenticate(request));
    }
}
