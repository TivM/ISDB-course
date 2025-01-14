package com.java.course.isdb.controller;

import com.java.course.isdb.dto.request.AddFoodCompensationRequest;
import com.java.course.isdb.dto.response.CompensationSumResponse;
import com.java.course.isdb.dto.response.FoodCompensationResponse;
import com.java.course.isdb.dto.response.ListFoodCompensationResponse;
import com.java.course.isdb.service.FoodCompensationService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;

@RestController
@RequiredArgsConstructor
@CrossOrigin
@Slf4j
@RequestMapping("food-compensation")
public class FoodCompensationController {

    private final FoodCompensationService foodCompensationService;

    @PostMapping()
    public FoodCompensationResponse add(@RequestBody AddFoodCompensationRequest addFoodCompensationRequest){
        return FoodCompensationResponse.fromEntity(
                foodCompensationService.add(
                        addFoodCompensationRequest.paymentAmount(),
                        addFoodCompensationRequest.compensationDate(),
                        addFoodCompensationRequest.isBreakfast(),
                        addFoodCompensationRequest.employeeId())
        );
    }

    @GetMapping("/count-sum")
    public CompensationSumResponse getCompensationSum(
            @RequestParam("start") LocalDate compensationStartDate,
            @RequestParam("end") LocalDate compensationEndDate,
            @RequestParam("id") int employeeId){
        return CompensationSumResponse.fromEntity(
                foodCompensationService.getCompensationSum(compensationStartDate, compensationEndDate, employeeId)
        );
    }

    @PostMapping("/{employee-id}/cancellation")
    public int cancelFoodCompensationForDeadlineMiss(@PathVariable("employee-id") int employeeId){
        foodCompensationService.cancelFoodCompensationForDeadlineMiss(employeeId);
        return employeeId;
    }

    @GetMapping()
    public ListFoodCompensationResponse getAll(){
        return ListFoodCompensationResponse.fromEntity(foodCompensationService.getAll());
    }
}
