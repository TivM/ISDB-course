package com.java.course.isdb.dto.request;

import java.time.LocalDate;

public record AddDayoffRequestRequest(LocalDate startDate, LocalDate endDate, boolean isApproved, int employeeId) {
}
