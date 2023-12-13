package com.java.course.isdb.dto.response;

import com.java.course.isdb.entity.EnterpriseEquipment;

public record EquipmentResponse(int id, String type, Integer serialNumber, String description) {
    public static EquipmentResponse fromEntity(EnterpriseEquipment enterpriseEquipment){
        return new EquipmentResponse(
                enterpriseEquipment.getId(),
                enterpriseEquipment.getType(),
                enterpriseEquipment.getSerialNumber(),
                enterpriseEquipment.getDescription());
    }
}
