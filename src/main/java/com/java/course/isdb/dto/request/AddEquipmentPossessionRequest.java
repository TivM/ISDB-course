package com.java.course.isdb.dto.request;

import java.time.LocalDate;

public record AddEquipmentPossessionRequest(String employeeDivision, int equipmentId, LocalDate possessionStart, LocalDate possessionEnd) {
}
