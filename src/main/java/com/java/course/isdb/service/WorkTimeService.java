package com.java.course.isdb.service;

import com.java.course.isdb.entity.WorkTime;

import java.time.LocalDateTime;
import java.util.List;

public interface WorkTimeService {

    WorkTime add(LocalDateTime startTimestamp, LocalDateTime endTimestamp, int employeeId);

    List<WorkTime> getAll();

    //подумать про добавление поиска по id
}
