package com.java.course.isdb.repository;

import com.java.course.isdb.entity.FoodCompensation;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.query.Procedure;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;

@Repository
public interface FoodCompensationRepository extends JpaRepository<FoodCompensation, Integer> {

    @Procedure(procedureName = "get_compensation_sum")
    int getCompensationSum(LocalDate compensationStartDate, LocalDate compensationEndDate, int employeeId);
}
