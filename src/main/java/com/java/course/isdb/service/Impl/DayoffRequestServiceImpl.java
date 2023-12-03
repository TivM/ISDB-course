package com.java.course.isdb.service.Impl;

import com.java.course.isdb.entity.DayoffRequest;
import com.java.course.isdb.entity.Employee;
import com.java.course.isdb.exception.ResourceNotFoundException;
import com.java.course.isdb.repository.DayoffRequestRepository;
import com.java.course.isdb.repository.EmployeeRepository;
import com.java.course.isdb.service.DayoffRequestService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDate;

@Service
@RequiredArgsConstructor
public class DayoffRequestServiceImpl implements DayoffRequestService {

    private final DayoffRequestRepository dayoffRequestRepository;
    private final EmployeeRepository employeeRepository;

    @Override
    @Transactional
    public DayoffRequest add(LocalDate startDate, LocalDate endDate, boolean isApproved, int employeeId) {
        Employee employee = employeeRepository.findById(employeeId).orElseThrow(
                () -> new ResourceNotFoundException("employee doesn't exist")
        );

        DayoffRequest dayoffRequest = new DayoffRequest()
                .setStartDate(startDate)
                .setEndDate(endDate)
                .setIsApproved(isApproved);

        employee.addDayoffRequest(dayoffRequest);

        dayoffRequestRepository.save(dayoffRequest);

        return dayoffRequest;
    }
}
