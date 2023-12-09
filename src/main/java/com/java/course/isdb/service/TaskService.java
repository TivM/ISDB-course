package com.java.course.isdb.service;

import com.java.course.isdb.entity.Task;

import java.time.LocalDate;
import java.util.List;

public interface TaskService {

    Task add(LocalDate startDate, LocalDate endDate, int complexity, String status, int productivityStatisticsId);

    List<Task> getAll();
}
