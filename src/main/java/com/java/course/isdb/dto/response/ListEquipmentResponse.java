package com.java.course.isdb.dto.response;

import com.java.course.isdb.entity.EnterpriseEquipment;
import com.java.course.isdb.service.EnterpriseEquipmentService;

import java.util.List;

public record ListEquipmentResponse(List<EquipmentResponse> equipmentResponses) {
    public static ListEquipmentResponse fromEntity(List<EnterpriseEquipment> enterpriseEquipments){
        return new ListEquipmentResponse(
                enterpriseEquipments.stream().map(EquipmentResponse::fromEntity).toList()
        );
    }
}
