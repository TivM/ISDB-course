package com.java.course.isdb.service;

import com.java.course.isdb.entity.EnterpriseEquipment;

import java.time.LocalDate;

public interface EnterpriseEquipmentService {

    EnterpriseEquipment add(String type, int serialNumber, String description);

    void giveEquipmentToTeam(String employeeDivision, int equipmentId, LocalDate possessionStart, LocalDate possessionEnd);
}
