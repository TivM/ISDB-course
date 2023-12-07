package com.java.course.isdb.dto.response;

import com.java.course.isdb.entity.Admin;

public record AdminResponse(String name, int age, String division){
    public static AdminResponse fromEntity(Admin admin){
        return new AdminResponse(admin.getName(), admin.getAge(), admin.getDivision());
    }
}
