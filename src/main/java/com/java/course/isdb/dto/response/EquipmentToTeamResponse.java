package com.java.course.isdb.dto.response;

import com.java.course.isdb.entity.Employee;
import com.java.course.isdb.entity.EnterpriseEquipment;
import com.java.course.isdb.entity.EquipmentPossession;

import java.util.Set;
import java.util.stream.Collectors;

public record EquipmentToTeamResponse(int equipmentId, Set<Integer> employeeIds) {
    public static EquipmentToTeamResponse fromEntity(EnterpriseEquipment enterpriseEquipment){
        return new EquipmentToTeamResponse(
                enterpriseEquipment.getId(),
                enterpriseEquipment.getEquipmentPossessions()
                        .stream()
                        .map(EquipmentPossession::getEmployee)
                        .map(Employee::getId)
                        .collect(Collectors.toSet())
        );
    }
}
