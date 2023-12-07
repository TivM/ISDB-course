package com.java.course.isdb.service.Impl;

import com.java.course.isdb.entity.Employee;
import com.java.course.isdb.entity.FoodCompensation;
import com.java.course.isdb.exception.ResourceNotFoundException;
import com.java.course.isdb.repository.EmployeeRepository;
import com.java.course.isdb.repository.FoodCompensationRepository;
import com.java.course.isdb.service.FoodCompensationService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDate;

@Service
@RequiredArgsConstructor
public class FoodCompensationServiceImpl implements FoodCompensationService {

    private final FoodCompensationRepository foodCompensationRepository;
    private final EmployeeRepository employeeRepository;

    @Override
    @Transactional
    public FoodCompensation add(int paymentAmount, LocalDate compensationDate, boolean isBreakfast, int employeeId) {
        Employee employee = employeeRepository.findById(employeeId).orElseThrow(
                () -> new ResourceNotFoundException("employee doesn't exist")
        );

        FoodCompensation foodCompensation = new FoodCompensation()
                .setPaymentAmount(paymentAmount)
                .setCompensationDate(compensationDate)
                .setIsBreakfast(isBreakfast);

        employee.addFoodCompensation(foodCompensation);

        foodCompensationRepository.save(foodCompensation);

        return foodCompensation;
    }

    @Override
    public int getCompensationSum(LocalDate compensationStartDate, LocalDate compensationEndDate, int employeeId) {
        return foodCompensationRepository.getCompensationSum(compensationStartDate, compensationEndDate, employeeId);
    }

    @Override
    public void cancelFoodCompensationForDeadlineMiss(int employeeId) {
        foodCompensationRepository.cancelFoodCompensationForDeadlineMiss(employeeId);
    }
}
