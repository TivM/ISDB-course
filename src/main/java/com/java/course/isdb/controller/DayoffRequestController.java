package com.java.course.isdb.controller;

import com.java.course.isdb.dto.request.AddDayoffRequestRequest;
import com.java.course.isdb.dto.response.DayoffRequestResponse;
import com.java.course.isdb.dto.response.ListDayoffRequestResponse;
import com.java.course.isdb.service.DayoffRequestService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping("dayoff")
public class DayoffRequestController {

    private final DayoffRequestService dayoffRequestService;

    @PostMapping("/add")
    public DayoffRequestResponse add(@RequestBody AddDayoffRequestRequest addDayoffRequestRequest){
        return DayoffRequestResponse.fromEntity(
                dayoffRequestService.add(
                        addDayoffRequestRequest.startDate(),
                        addDayoffRequestRequest.endDate(),
                        addDayoffRequestRequest.isApproved(),
                        addDayoffRequestRequest.employeeId()
                )
        );
    }

    @GetMapping("/all")
    public ListDayoffRequestResponse getAll(){
        return ListDayoffRequestResponse.fromEntity(dayoffRequestService.getAll());
    }
}
