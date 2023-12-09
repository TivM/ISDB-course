package com.java.course.isdb.dto.response;

import com.java.course.isdb.entity.WorkTime;

import java.util.List;

public record ListWorkTimeResponse(List<WorkTimeResponse> workTimeResponses) {
    public static ListWorkTimeResponse fromEntity(List<WorkTime> workTimes){
        return new ListWorkTimeResponse(
                workTimes.stream().map(WorkTimeResponse::fromEntity).toList()
        );
    }
}
