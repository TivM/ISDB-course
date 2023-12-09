package com.java.course.isdb.dto.response;

import com.java.course.isdb.entity.DayoffRequest;

import java.util.List;

public record ListDayoffRequestResponse(List<DayoffRequestResponse> dayoffRequestResponses) {
    public static ListDayoffRequestResponse fromEntity(List<DayoffRequest> dayoffRequests){
        return new ListDayoffRequestResponse(
                dayoffRequests.stream().map(DayoffRequestResponse::fromEntity).toList()
        );
    }
}
