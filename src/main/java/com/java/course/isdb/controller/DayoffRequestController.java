package com.java.course.isdb.controller;

import com.java.course.isdb.dto.request.AddAdminRequest;
import com.java.course.isdb.dto.request.AddDayoffRequestRequest;
import com.java.course.isdb.dto.response.AdminResponse;
import com.java.course.isdb.dto.response.DayoffRequestResponse;
import com.java.course.isdb.dto.response.ListDayoffRequestResponse;
import com.java.course.isdb.entity.Admin;
import com.java.course.isdb.entity.DayoffRequest;
import com.java.course.isdb.service.DayoffRequestService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@CrossOrigin
@RequestMapping("dayoff-requests")
public class DayoffRequestController {

    private final DayoffRequestService dayoffRequestService;

    @PostMapping()
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

    @GetMapping()
    public ListDayoffRequestResponse getAll(){
        return ListDayoffRequestResponse.fromEntity(dayoffRequestService.getAll());
    }

    @GetMapping("/{id}")
    public DayoffRequestResponse getById(@PathVariable int id){
        return DayoffRequestResponse.fromEntity(dayoffRequestService.getById(id));
    }

    @DeleteMapping("/{id}")
    public void deleteById(@PathVariable int id){
        dayoffRequestService.deleteById(id);
    }

    @PutMapping("/{id}")
    public DayoffRequestResponse updateById(@PathVariable int id, @RequestBody AddDayoffRequestRequest addDayoffRequestRequest){
        return DayoffRequestResponse.fromEntity(dayoffRequestService.updateById(id,
                addDayoffRequestRequest.startDate(),
                addDayoffRequestRequest.endDate(),
                addDayoffRequestRequest.isApproved(),
                addDayoffRequestRequest.employeeId()));
    }
}
