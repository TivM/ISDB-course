package com.java.course.isdb.service.Impl;

import com.java.course.isdb.entity.Employee;
import com.java.course.isdb.entity.WorkTime;
import com.java.course.isdb.exception.ResourceNotFoundException;
import com.java.course.isdb.repository.EmployeeRepository;
import com.java.course.isdb.repository.WorkTimeRepository;
import com.java.course.isdb.service.WorkTimeService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
@RequiredArgsConstructor
public class WorkTimeServiceImpl implements WorkTimeService {

    private final WorkTimeRepository workTimeRepository;
    private final EmployeeRepository employeeRepository;

    @Override
    public WorkTime add(LocalDateTime startTimestamp, LocalDateTime endTimestamp, int employeeId) {
        Employee employee = employeeRepository.findById(employeeId).orElseThrow(
                () -> new ResourceNotFoundException("employee doesn't exist")
        );

        WorkTime workTime = new WorkTime()
                .setStartTimestamp(startTimestamp)
                .setEndTimestamp(endTimestamp);

        employee.addWorkTime(workTime);

        workTimeRepository.save(workTime);

        return workTime;
    }

    @Override
    public List<WorkTime> getAll() {
        return workTimeRepository.findAll();
    }
}
