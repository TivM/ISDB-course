package com.java.course.isdb.controller;

import com.java.course.isdb.dto.request.AddAdminRequest;
import com.java.course.isdb.dto.request.AddTaskRequest;
import com.java.course.isdb.dto.response.AdminResponse;
import com.java.course.isdb.dto.response.ListTaskResponse;
import com.java.course.isdb.dto.response.TaskResponse;
import com.java.course.isdb.service.TaskService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@CrossOrigin
@RequestMapping("tasks")
public class TaskController {

    private final TaskService taskService;

    @PostMapping()
    public TaskResponse add(@RequestBody AddTaskRequest addTaskRequest){
        return TaskResponse.fromEntity(
                taskService.add(addTaskRequest.startDate(), addTaskRequest.endDate(),
                        addTaskRequest.complexity(), addTaskRequest.status(), addTaskRequest.productivityStatisticsId())
        );
    }

    @GetMapping()
    public ListTaskResponse getAll(){
        return ListTaskResponse.fromEntity(taskService.getAll());
    }

    @PutMapping("/{id}/{status}")
    public TaskResponse updateById(@PathVariable int id, @PathVariable String status){
        return TaskResponse.fromEntity(
                taskService.updateById(id, status));
    }
}
