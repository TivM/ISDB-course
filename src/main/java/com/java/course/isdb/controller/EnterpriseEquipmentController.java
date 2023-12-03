package com.java.course.isdb.controller;

import com.java.course.isdb.dto.request.AddEquipmentPossessionRequest;
import com.java.course.isdb.dto.request.AddEquipmentRequest;
import com.java.course.isdb.service.EnterpriseEquipmentService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping("equipment")
public class EnterpriseEquipmentController {

    private final EnterpriseEquipmentService enterpriseEquipmentService;

    @PostMapping("/add")
    public ResponseEntity<?> addEquipment(@RequestBody AddEquipmentRequest addEquipmentRequest){
       enterpriseEquipmentService.add(addEquipmentRequest.type(),
               addEquipmentRequest.serialNumber(), addEquipmentRequest.description());
        return ResponseEntity.ok(addEquipmentRequest.serialNumber());
    }

    @PostMapping("/possession")
    public ResponseEntity<?> addEquipmentPossession(@RequestBody AddEquipmentPossessionRequest addEquipmentPossessionRequest){
        enterpriseEquipmentService.giveEquipmentToTeam(
                addEquipmentPossessionRequest.employeeDivision(),
                addEquipmentPossessionRequest.equipmentId(),
                addEquipmentPossessionRequest.possessionStart(),
                addEquipmentPossessionRequest.possessionEnd()
        );

        return ResponseEntity.ok(addEquipmentPossessionRequest.equipmentId());
    }
}
