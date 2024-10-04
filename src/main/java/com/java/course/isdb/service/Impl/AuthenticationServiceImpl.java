package com.java.course.isdb.service.Impl;

import com.java.course.isdb.controller.auth.AuthenticationRequest;
import com.java.course.isdb.controller.auth.AuthenticationResponse;
import com.java.course.isdb.dto.request.AddAdminRequest;
import com.java.course.isdb.dto.request.HireEmployeeRequest;
import com.java.course.isdb.entity.Admin;
import com.java.course.isdb.entity.Employee;
import com.java.course.isdb.entity.Role;
import com.java.course.isdb.entity.User;
import com.java.course.isdb.exception.ResourceNotFoundException;
import com.java.course.isdb.repository.AdminRepository;
import com.java.course.isdb.repository.EmployeeRepository;
import com.java.course.isdb.repository.UserRepository;
import com.java.course.isdb.service.AuthenticationService;
import com.java.course.isdb.service.JwtService;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;


@Service
@RequiredArgsConstructor
public class AuthenticationServiceImpl implements AuthenticationService {

    private final UserRepository userRepository;
    private final AdminRepository adminRepository;
    private final EmployeeRepository employeeRepository;
    private final PasswordEncoder passwordEncoder;
    private final JwtService jwtService;
    private final AuthenticationManager authenticationManager;

    @Override
    public AuthenticationResponse adminRegister(AddAdminRequest request) {
        var user = new User()
                .setEmail(request.email())
                .setPassword(passwordEncoder.encode(request.password()))
                .setRole(Role.ADMIN);

        var admin = new Admin()
                .setName(request.name())
                .setAge(request.age())
                .setDivision(request.division())
                .setEmail(request.email());

        userRepository.save(user);
        admin = adminRepository.save(admin);

        var jwtToken = jwtService.generateToken(user);
        return new AuthenticationResponse(admin.getId(), jwtToken);
    }

    @Override
    public AuthenticationResponse employeeRegister(HireEmployeeRequest request) {
        var user = new User()
                .setEmail(request.email())
                .setPassword(passwordEncoder.encode(request.password()))
                .setRole(Role.EMPLOYEE);

        var admin = adminRepository.findById(request.adminId()).get();
        var employee = new Employee()
                .setName(request.name())
                .setAge(request.age())
                .setDivision(request.division())
                .setEmail(request.email())
                .setAdmin(admin);

        userRepository.save(user);
        employee = employeeRepository.save(employee);

        var jwtToken = jwtService.generateToken(user);
        return new AuthenticationResponse(employee.getId(), jwtToken);
    }

    @Override
    @Transactional
    public AuthenticationResponse authenticate(AuthenticationRequest request) {
        authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(
                        request.email(),
                        request.password()
                )
        );

        var user = userRepository.findByEmail(request.email())
                .orElseThrow();

        var jwtToken = jwtService.generateToken(user);
        Integer id = getIdAfterAuthenticate(user);

        return new AuthenticationResponse(id, jwtToken);
    }

    private Integer getIdAfterAuthenticate(User user){
        switch (user.getRole()){
            case ADMIN -> {
                Admin admin = adminRepository.findByEmail(user.getEmail()).orElseThrow(
                        () -> new ResourceNotFoundException("Can't find admin with this email")
                );
                return admin.getId();
            }
            case EMPLOYEE -> {
                Employee employee = employeeRepository.findByEmail(user.getEmail()).orElseThrow(
                        () -> new ResourceNotFoundException("Can't find employee with this email")
                );
                return employee.getId();
            }
            default -> throw new ResourceNotFoundException("Role doesn't exist");
        }
    }
}
