package com.java.course.isdb.service.Impl;

import com.java.course.isdb.entity.Admin;
import com.java.course.isdb.entity.Employee;
import com.java.course.isdb.entity.ProductivityStatistics;
import com.java.course.isdb.exception.ResourceNotFoundException;
import com.java.course.isdb.repository.AdminRepository;
import com.java.course.isdb.repository.EmployeeRepository;
import com.java.course.isdb.repository.ProductivityStatisticsRepository;
import com.java.course.isdb.service.ProductivityStatisticsService;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;

@Service
@RequiredArgsConstructor
public class ProductivityStatisticsServiceImpl implements ProductivityStatisticsService {

    private final ProductivityStatisticsRepository productivityStatisticsRepository;
    private final EmployeeRepository employeeRepository;
    private final AdminRepository adminRepository;

    @Override
    @Transactional
    public ProductivityStatistics add(LocalDate date, String managerReview, int employeeId, int adminId) {
        Employee employee = employeeRepository.findById(employeeId).orElseThrow(
                () -> new ResourceNotFoundException("employee doesn't exist")
        );

        Admin admin = adminRepository.findById(adminId).orElseThrow(
                () -> new ResourceNotFoundException("admin doesn't exist")
        );

        ProductivityStatistics productivityStatistics = new ProductivityStatistics()
                .setDate(date)
                .setManagerReview(managerReview);

        employee.addProductivityStatistics(productivityStatistics);
        admin.addProductivityStatistics(productivityStatistics);

        productivityStatisticsRepository.save(productivityStatistics);

        return productivityStatistics;
    }

    @Override
    public List<ProductivityStatistics> getAll() {
        return productivityStatisticsRepository.findAll();
    }
}
