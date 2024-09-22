package com.java.course.isdb.controller;

import com.java.course.isdb.dto.request.AddAdminRequest;
import com.java.course.isdb.dto.response.AdminResponse;
import com.java.course.isdb.dto.response.ListAdminResponse;
import com.java.course.isdb.entity.Admin;
import com.java.course.isdb.service.AdminService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@CrossOrigin
@RequestMapping("admins")
public class AdminController {

    private final AdminService adminService;

    @PostMapping()
    public AdminResponse addAmin(@RequestBody AddAdminRequest addAdminRequest){
        return AdminResponse.fromEntity(
                adminService.add(addAdminRequest.name(), addAdminRequest.age(), addAdminRequest.division())
        );
    }

    @GetMapping()
    public ListAdminResponse getAll(){
        return ListAdminResponse.fromEntity(adminService.getAll());
    }

    @GetMapping("/{id}")
    public AdminResponse getById(@PathVariable int id){
        return AdminResponse.fromEntity(adminService.getById(id));
    }

    @DeleteMapping("/{id}")
    public void deleteById(@PathVariable int id){
        adminService.deleteById(id);
    }

    @PutMapping("/{id}")
    public AdminResponse updateById(@PathVariable int id, @RequestBody AddAdminRequest addAdminRequest){
        return AdminResponse.fromEntity(adminService.updateById(id, addAdminRequest.name(), addAdminRequest.age(), addAdminRequest.division()));
    }
}
