package com.java.course.isdb.dto.response;

import com.java.course.isdb.entity.Admin;

import java.util.List;
public record ListAdminResponse(List<AdminResponse> adminResponses) {
    public static ListAdminResponse fromEntity(List<Admin> admins){
        return new ListAdminResponse(
                admins.stream().map(AdminResponse::fromEntity).toList()
        );
    }
}
