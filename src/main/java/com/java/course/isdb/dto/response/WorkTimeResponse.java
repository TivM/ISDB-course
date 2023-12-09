package com.java.course.isdb.dto.response;

import com.java.course.isdb.entity.WorkTime;

import java.time.LocalDateTime;

public record WorkTimeResponse(LocalDateTime startTimestamp, LocalDateTime endTimestamp, int employeeId) {
    public static WorkTimeResponse fromEntity(WorkTime workTime){
        return new WorkTimeResponse(workTime.getStartTimestamp(), workTime.getEndTimestamp(), workTime.getEmployee().getId());
    }
}
