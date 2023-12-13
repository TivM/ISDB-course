package com.java.course.isdb.dto.response;

import com.java.course.isdb.entity.EquipmentPossession;

import java.time.LocalDate;

public record EquipmentPossessionResponse(int id, int equipmentId, int employeeId, LocalDate startDate, LocalDate endDate){
    public static EquipmentPossessionResponse fromEntity(EquipmentPossession equipmentPossession){
        return new EquipmentPossessionResponse(
                equipmentPossession.getId(),
                equipmentPossession.getEnterpriseEquipment().getId(),
                equipmentPossession.getEmployee().getId(),
                equipmentPossession.getStartDate(),
                equipmentPossession.getEndDate()
        );
    }
}
