package com.java.course.isdb.dto.request;

import java.time.LocalDate;

public record AddTaskRequest(LocalDate startDate, LocalDate endDate, int complexity, String status, int productivityStatisticsId) {
}
