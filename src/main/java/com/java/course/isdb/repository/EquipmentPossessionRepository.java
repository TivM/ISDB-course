package com.java.course.isdb.repository;

import com.java.course.isdb.entity.EquipmentPossession;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.query.Procedure;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;

@Repository
public interface EquipmentPossessionRepository extends JpaRepository<EquipmentPossession, Integer> {

    @Procedure(procedureName = "give_equipment_to_team")
    void giveEquipmentToTeam(String employeeDivision, int equipmentId, LocalDate possessionStart, LocalDate possessionEnd);

}
