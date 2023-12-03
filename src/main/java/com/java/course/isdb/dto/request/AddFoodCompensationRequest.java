package com.java.course.isdb.dto.request;

import java.time.LocalDate;

public record AddFoodCompensationRequest(int paymentAmount, LocalDate compensationDate, boolean isBreakfast, int employeeId) {
}
