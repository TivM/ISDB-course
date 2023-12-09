package com.java.course.isdb.controller;

import com.java.course.isdb.dto.request.AddWorkTimeRequest;
import com.java.course.isdb.dto.response.ListWorkTimeResponse;
import com.java.course.isdb.dto.response.WorkTimeResponse;
import com.java.course.isdb.service.WorkTimeService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping("work")
public class WorkTimeController {

    private final WorkTimeService workTimeService;

    @PostMapping("/add")
    public WorkTimeResponse add(@RequestBody AddWorkTimeRequest addWorkTimeRequest){
        return WorkTimeResponse.fromEntity(
                workTimeService.add(
                        addWorkTimeRequest.startTimestamp(),
                        addWorkTimeRequest.endTimestamp(),
                        addWorkTimeRequest.employeeId()
                )
        );
    }

    @GetMapping("/all")
    public ListWorkTimeResponse getAll(){
        return ListWorkTimeResponse.fromEntity(workTimeService.getAll());
    }
}
