package com.java.course.isdb.dto.request;

import java.time.LocalDateTime;

public record AddWorkTimeRequest(LocalDateTime startTimestamp, LocalDateTime endTimestamp, int employeeId) {
}
