package com.java.course.isdb.dto.response;

import com.java.course.isdb.entity.Task;

import java.util.List;

public record ListTaskResponse(List<TaskResponse> taskResponses) {
    public static ListTaskResponse fromEntity(List<Task> tasks){
        return new ListTaskResponse(tasks.stream().map(TaskResponse::fromEntity).toList());
    }
}
