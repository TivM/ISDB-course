package com.java.course.isdb.service;

import com.java.course.isdb.entity.DayoffRequest;

import java.time.LocalDate;

public interface DayoffRequestService {

    DayoffRequest add(LocalDate startDate, LocalDate endDate, boolean isApproved, int employeeId);
}
