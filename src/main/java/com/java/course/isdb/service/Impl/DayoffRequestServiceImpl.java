package com.java.course.isdb.service.Impl;

import com.java.course.isdb.entity.Admin;
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
import java.util.List;

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

    @Override
    public List<DayoffRequest> getAll() {
        return dayoffRequestRepository.findAll();
    }

    @Override
    public DayoffRequest getById(int id) {
        var request = dayoffRequestRepository.findById(id);
        return request.orElse(null);
    }

    @Override
    public void deleteById(int id) {
        dayoffRequestRepository.deleteById(id);
    }

    @Override
    public DayoffRequest updateById(int id, LocalDate startDate, LocalDate endDate, boolean isApproved, int employeeId) {
        var dayOffOptional = dayoffRequestRepository.findById(id);
        DayoffRequest dayOff;
        if (dayOffOptional.isPresent()) {
            dayOff = dayOffOptional.get();
        } else {
            return null;
        }

        dayOff.setStartDate(startDate);
        dayOff.setEndDate(endDate);
        dayOff.setIsApproved(isApproved);

        return dayoffRequestRepository.save(dayOff);
    }
}
