package com.java.course.isdb.controller.auth;

public record ClientRegisterRequest(
        String name,
        Integer age,
        String address,
        String email,
        String password
) {}
