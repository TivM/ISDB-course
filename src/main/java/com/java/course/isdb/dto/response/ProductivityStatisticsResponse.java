package com.java.course.isdb.dto.response;

import com.java.course.isdb.entity.Employee;
import com.java.course.isdb.entity.ProductivityStatistics;
import com.java.course.isdb.repository.ProductivityStatisticsRepository;

import java.time.LocalDate;

public record ProductivityStatisticsResponse(LocalDate date, String managerReview, int employeeId, int adminId) {
    public static ProductivityStatisticsResponse fromEntity(ProductivityStatistics productivityStatistics){
        return new ProductivityStatisticsResponse(productivityStatistics.getDate(), productivityStatistics.getManagerReview(),
                productivityStatistics.getEmployee().getId(), productivityStatistics.getAdmin().getId());
    }
}
