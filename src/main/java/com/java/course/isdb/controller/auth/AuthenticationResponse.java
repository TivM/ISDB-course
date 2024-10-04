package com.java.course.isdb.controller.auth;

import com.fasterxml.jackson.annotation.JsonProperty;

public record AuthenticationResponse(
        @JsonProperty("user_id") Integer userId,
        @JsonProperty("access_token") String accessToken
) {}
