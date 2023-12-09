package com.java.course.isdb.dto.response;

import com.java.course.isdb.entity.EnterpriseEquipment;

public record EquipmentResponse(String type, Integer serialNumber, String description) {
    public static EquipmentResponse fromEntity(EnterpriseEquipment enterpriseEquipment){
        return new EquipmentResponse(enterpriseEquipment.getType(), enterpriseEquipment.getSerialNumber(), enterpriseEquipment.getDescription());
    }
}
