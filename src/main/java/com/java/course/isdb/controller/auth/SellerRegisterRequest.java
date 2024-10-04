package com.java.course.isdb.controller.auth;

public record SellerRegisterRequest(
        String name,
        Integer passport,
        String email,
        String password
) {}
