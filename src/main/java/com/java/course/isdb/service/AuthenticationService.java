package com.java.course.isdb.service;


import com.java.course.isdb.controller.auth.AuthenticationRequest;
import com.java.course.isdb.controller.auth.AuthenticationResponse;
import com.java.course.isdb.controller.auth.SellerRegisterRequest;
import com.java.course.isdb.dto.request.AddAdminRequest;
import com.java.course.isdb.dto.request.HireEmployeeRequest;

public interface AuthenticationService {
    AuthenticationResponse adminRegister(AddAdminRequest request);

    AuthenticationResponse employeeRegister(HireEmployeeRequest request);

    AuthenticationResponse authenticate(AuthenticationRequest request);
}
