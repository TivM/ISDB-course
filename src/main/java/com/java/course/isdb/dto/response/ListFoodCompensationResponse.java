package com.java.course.isdb.dto.response;

import com.java.course.isdb.entity.FoodCompensation;

import java.util.List;

public record ListFoodCompensationResponse(List<FoodCompensationResponse> foodCompensationResponses) {
    public static ListFoodCompensationResponse fromEntity(List<FoodCompensation> foodCompensations){
        return new ListFoodCompensationResponse(
                foodCompensations.stream().map(FoodCompensationResponse::fromEntity).toList()
        );
    }
}
