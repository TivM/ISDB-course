package com.java.course.isdb.dto.request;

import java.time.LocalDate;

public record AddProductivityStatisticsRequest(LocalDate date, String managerReview, int employeeId, int adminId) {
}
