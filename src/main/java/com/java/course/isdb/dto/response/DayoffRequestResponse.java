package com.java.course.isdb.dto.response;

import com.java.course.isdb.entity.DayoffRequest;

import java.time.LocalDate;

public record DayoffRequestResponse(int id, LocalDate startDate, LocalDate endDate, boolean isApproved, int employeeId) {
    public static DayoffRequestResponse fromEntity(DayoffRequest dayoffRequest){
        return new DayoffRequestResponse(
                dayoffRequest.getId(),
                dayoffRequest.getStartDate(),
                dayoffRequest.getEndDate(),
                dayoffRequest.getIsApproved(),
                dayoffRequest.getEmployee().getId()
        );
    }
}
