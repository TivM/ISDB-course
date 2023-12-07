package com.java.course.isdb.service;

import com.java.course.isdb.entity.ProductivityStatistics;

import java.time.LocalDate;
import java.util.List;

public interface ProductivityStatisticsService {

    ProductivityStatistics add(LocalDate date, String managerReview, int employeeId, int adminId);

    List<ProductivityStatistics> getAll();
}
