package com.java.course.isdb.repository;

import com.java.course.isdb.entity.DayoffRequest;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DayoffRequestRepository extends JpaRepository<DayoffRequest, Integer> {
}
