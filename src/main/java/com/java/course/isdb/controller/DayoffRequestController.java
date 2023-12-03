package com.java.course.isdb.controller;

import com.java.course.isdb.dto.request.AddDayoffRequestRequest;
import com.java.course.isdb.service.DayoffRequestService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping("dayoff")
public class DayoffRequestController {

    private final DayoffRequestService dayoffRequestService;

    @PostMapping("add")
    ResponseEntity<?> add(@RequestBody AddDayoffRequestRequest addDayoffRequestRequest){
        dayoffRequestService.add(
                addDayoffRequestRequest.startDate(),
                addDayoffRequestRequest.endDate(),
                addDayoffRequestRequest.isApproved(),
                addDayoffRequestRequest.employeeId()
        );

        return ResponseEntity.ok(addDayoffRequestRequest.startDate());
    }
}
