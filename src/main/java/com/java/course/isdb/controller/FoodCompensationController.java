package com.java.course.isdb.controller;

import com.java.course.isdb.dto.request.AddFoodCompensationRequest;
import com.java.course.isdb.dto.response.FoodCompensationResponse;
import com.java.course.isdb.dto.response.ListFoodCompensationResponse;
import com.java.course.isdb.service.FoodCompensationService;
import jakarta.persistence.criteria.CriteriaBuilder;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;

@RestController
@RequiredArgsConstructor
@RequestMapping("food")
public class FoodCompensationController {

    private final FoodCompensationService foodCompensationService;

    @PostMapping("/add")
    public FoodCompensationResponse add(@RequestBody AddFoodCompensationRequest addFoodCompensationRequest){
        return FoodCompensationResponse.fromEntity(
                foodCompensationService.add(
                        addFoodCompensationRequest.paymentAmount(),
                        addFoodCompensationRequest.compensationDate(),
                        addFoodCompensationRequest.isBreakfast(),
                        addFoodCompensationRequest.employeeId())
        );
    }
    //не работает
    @GetMapping("/compsum")
    public Integer getCompensationSum(
            @RequestParam("start")
            @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) LocalDate compensationStartDate,
            @RequestParam("end")
            @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) LocalDate compensationEndDate,
            @RequestParam("id") int employeeId){
        return foodCompensationService.getCompensationSum(compensationStartDate, compensationEndDate, employeeId);
    }

    @PutMapping("/cancel/{employeeId}")
    public int cancelFoodCompensationForDeadlineMiss(@PathVariable int employeeId){
        foodCompensationService.cancelFoodCompensationForDeadlineMiss(employeeId);
        return employeeId;
    }

    @GetMapping("/all")
    public ListFoodCompensationResponse getAll(){
        return ListFoodCompensationResponse.fromEntity(foodCompensationService.getAll());
    }
}
