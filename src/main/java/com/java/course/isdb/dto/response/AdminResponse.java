package com.java.course.isdb.dto.response;

import com.java.course.isdb.entity.Admin;

public record AdminResponse(int id, String name, int age, String division){
    public static AdminResponse fromEntity(Admin admin){
        return new AdminResponse(admin.getId(), admin.getName(), admin.getAge(), admin.getDivision());
    }
}
