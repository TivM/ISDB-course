package com.java.course.isdb.dto.response;

import com.java.course.isdb.entity.EquipmentPossession;

import java.util.List;

public record ListEquipmentPossessionResponse(List<EquipmentPossessionResponse> equipmentPossessionResponses){
    public static ListEquipmentPossessionResponse fromEntity(List<EquipmentPossession> equipmentPossessions){
        return new ListEquipmentPossessionResponse(
                equipmentPossessions.stream().map(EquipmentPossessionResponse::fromEntity).toList()
        );
    }
}
