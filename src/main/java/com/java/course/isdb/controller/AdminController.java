package com.java.course.isdb.controller;

import com.java.course.isdb.dto.request.AddAdminRequest;
import com.java.course.isdb.dto.response.AdminResponse;
import com.java.course.isdb.dto.response.ListAdminResponse;
import com.java.course.isdb.service.AdminService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@CrossOrigin
@RequestMapping("admin")
public class AdminController {

    private final AdminService adminService;

    @PostMapping("/add")
    public AdminResponse addAmin(@RequestBody AddAdminRequest addAdminRequest){
        return AdminResponse.fromEntity(
                adminService.add(addAdminRequest.name(), addAdminRequest.age(), addAdminRequest.division())
        );
    }

    @GetMapping("/all")
    public ListAdminResponse getAll(){
        return ListAdminResponse.fromEntity(adminService.getAll());
    }
}
