package com.java.course.isdb.dto.response;

import com.java.course.isdb.entity.Task;

import java.time.LocalDate;

public record TaskResponse(int id, LocalDate startDate, LocalDate endDate, int complexity, String status, int productivityStatisticsId) {
    public static TaskResponse fromEntity(Task task){
        return new TaskResponse(
                task.getId(),
                task.getStartDate(),
                task.getEndDate(),
                task.getComplexity(),
                task.getStatus(),
                task.getProductivityStatistics().getId());
    }
}
