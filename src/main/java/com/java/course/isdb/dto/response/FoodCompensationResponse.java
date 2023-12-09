package com.java.course.isdb.dto.response;

import com.java.course.isdb.entity.FoodCompensation;

import java.time.LocalDate;

public record FoodCompensationResponse(int paymentAmount, LocalDate compensationDate, boolean isBreakfast, int employeeId) {
    public static FoodCompensationResponse fromEntity(FoodCompensation foodCompensation){
        return new FoodCompensationResponse(
                foodCompensation.getPaymentAmount(),
                foodCompensation.getCompensationDate(),
                foodCompensation.getIsBreakfast(),
                foodCompensation.getEmployee().getId()
        );
    }
}
