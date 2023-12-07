package com.java.course.isdb.controller;

import com.java.course.isdb.dto.request.AddAdminRequest;
import com.java.course.isdb.dto.response.AdminResponse;
import com.java.course.isdb.service.AdminService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping("admin")
public class AdminController {

    private final AdminService adminService;

    //need test
    @PostMapping("/add")
    public AdminResponse addAmin(@RequestBody AddAdminRequest addAdminRequest){
        adminService.add(addAdminRequest.name(), addAdminRequest.age(), addAdminRequest.division());
        return AdminResponse.fromEntity(
                adminService.add(addAdminRequest.name(), addAdminRequest.age(), addAdminRequest.division())
        );
    }
}
