package com.java.course.isdb.service;

import com.java.course.isdb.entity.Admin;
import com.java.course.isdb.entity.ProductivityStatistics;

import java.time.LocalDate;
import java.util.List;

public interface ProductivityStatisticsService {

    ProductivityStatistics add(LocalDate date, String managerReview, int employeeId, int adminId);

    List<ProductivityStatistics> getAll();

    ProductivityStatistics getById(int id);

    void deleteById(int id);

    ProductivityStatistics updateById(int id, LocalDate date, String managerReview, int employeeId, int adminId);

}
