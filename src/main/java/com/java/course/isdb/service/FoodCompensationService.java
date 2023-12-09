package com.java.course.isdb.service;

import com.java.course.isdb.entity.FoodCompensation;

import java.time.LocalDate;
import java.util.List;

public interface FoodCompensationService {

    FoodCompensation add(int paymentAmount, LocalDate compensationDate, boolean isBreakfast, int employeeId);

    Integer getCompensationSum(LocalDate compensationStartDate, LocalDate compensationEndDate, int employeeId);

    void cancelFoodCompensationForDeadlineMiss(int employeeId);

    List<FoodCompensation> getAll();
}
