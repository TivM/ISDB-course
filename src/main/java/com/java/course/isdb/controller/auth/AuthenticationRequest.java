package com.java.course.isdb.controller.auth;

public record AuthenticationRequest(
    String email,
    String password
){}

