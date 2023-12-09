package com.java.course.isdb.service;

import com.java.course.isdb.entity.EnterpriseEquipment;
import com.java.course.isdb.entity.EquipmentPossession;

import java.time.LocalDate;
import java.util.List;

public interface EnterpriseEquipmentService {

    EnterpriseEquipment add(String type, int serialNumber, String description);

    EnterpriseEquipment giveEquipmentToTeam(String employeeDivision, int equipmentId, LocalDate possessionStart, LocalDate possessionEnd);

    List<EnterpriseEquipment> getAllEquipment();

    List<EquipmentPossession> getAllEquipmentPossession();
}
