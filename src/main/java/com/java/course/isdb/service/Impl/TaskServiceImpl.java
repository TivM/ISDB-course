package com.java.course.isdb.service.Impl;

import com.java.course.isdb.entity.ProductivityStatistics;
import com.java.course.isdb.entity.Task;
import com.java.course.isdb.exception.ResourceNotFoundException;
import com.java.course.isdb.repository.ProductivityStatisticsRepository;
import com.java.course.isdb.repository.TaskRepository;
import com.java.course.isdb.service.TaskService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;

@Service
@RequiredArgsConstructor
public class TaskServiceImpl implements TaskService {

    private final TaskRepository taskRepository;
    private final ProductivityStatisticsRepository productivityStatisticsRepository;

    @Override
    public Task add(LocalDate startDate, LocalDate endDate, int complexity, String status, int productivityStatisticsId) {
        ProductivityStatistics productivityStatistics = productivityStatisticsRepository.findById(productivityStatisticsId).orElseThrow(
                () -> new ResourceNotFoundException("productivity statistics not found")
        );

        Task task = new Task()
                .setStartDate(startDate)
                .setEndDate(endDate)
                .setComplexity(complexity)
                .setStatus(status);

        productivityStatistics.addTask(task);

        taskRepository.save(task);

        return task;
    }

    @Override
    public List<Task> getAll() {
        return taskRepository.findAll();
    }
}
