package com.java.course.isdb.service.Impl;

import com.java.course.isdb.entity.Employee;
import com.java.course.isdb.entity.FoodCompensation;
import com.java.course.isdb.exception.ResourceNotFoundException;
import com.java.course.isdb.repository.EmployeeRepository;
import com.java.course.isdb.repository.FoodCompensationRepository;
import com.java.course.isdb.service.FoodCompensationService;
import jakarta.persistence.criteria.CriteriaBuilder;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDate;
import java.util.List;

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
    public Integer getCompensationSum(LocalDate compensationStartDate, LocalDate compensationEndDate, int employeeId) {
        return foodCompensationRepository.getCompensationSum(compensationStartDate, compensationEndDate, employeeId);
    }

    @Override
    public void cancelFoodCompensationForDeadlineMiss(int employeeId) {
        Employee employee = employeeRepository.findById(employeeId).orElseThrow(
                () -> new ResourceNotFoundException("employee doesn't exist")
        );
        foodCompensationRepository.cancelFoodCompensationForDeadlineMiss(employee.getId());
    }

    @Override
    public List<FoodCompensation> getAll() {
        return foodCompensationRepository.findAll();
    }
}
