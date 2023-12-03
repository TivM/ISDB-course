package com.java.course.isdb.repository;

import com.java.course.isdb.entity.ProductivityStatistics;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProductivityStatisticsRepository extends JpaRepository<ProductivityStatistics, Integer> {
}
