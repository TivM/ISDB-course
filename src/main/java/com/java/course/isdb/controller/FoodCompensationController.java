package com.java.course.isdb.controller;

import com.java.course.isdb.dto.request.AddFoodCompensationRequest;
import com.java.course.isdb.service.FoodCompensationService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;

@RestController
@RequiredArgsConstructor
@RequestMapping("food")
public class FoodCompensationController {

    private final FoodCompensationService foodCompensationService;

    @PostMapping("/add")
    ResponseEntity<?> add(@RequestBody AddFoodCompensationRequest addFoodCompensationRequest){
        foodCompensationService.add(
                addFoodCompensationRequest.paymentAmount(),
                addFoodCompensationRequest.compensationDate(),
                addFoodCompensationRequest.isBreakfast(),
                addFoodCompensationRequest.employeeId());
        return ResponseEntity.ok(addFoodCompensationRequest.compensationDate());
    }

    @GetMapping("/compsum")
    int getCompensationSum(@RequestParam("start") LocalDate compensationStartDate,
                           @RequestParam("end") LocalDate compensationEndDate,
                           @RequestParam("id") int employeeId){

        return foodCompensationService.getCompensationSum(compensationStartDate, compensationEndDate, employeeId);
    }
}
