package com.java.course.isdb.controller;

import com.java.course.isdb.dto.request.AddTaskRequest;
import com.java.course.isdb.dto.response.ListTaskResponse;
import com.java.course.isdb.dto.response.TaskResponse;
import com.java.course.isdb.service.TaskService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping("task")
public class TaskController {

    private final TaskService taskService;

    @PostMapping("/add")
    public TaskResponse add(@RequestBody AddTaskRequest addTaskRequest){
        return TaskResponse.fromEntity(
                taskService.add(addTaskRequest.startDate(), addTaskRequest.endDate(),
                        addTaskRequest.complexity(), addTaskRequest.status(), addTaskRequest.productivityStatisticsId())
        );
    }

    @GetMapping("/all")
    public ListTaskResponse getAll(){
        return ListTaskResponse.fromEntity(taskService.getAll());
    }
}
