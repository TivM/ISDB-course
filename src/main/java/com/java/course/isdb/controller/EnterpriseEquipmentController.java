package com.java.course.isdb.controller;

import com.java.course.isdb.dto.request.AddEquipmentPossessionRequest;
import com.java.course.isdb.dto.request.AddEquipmentRequest;
import com.java.course.isdb.dto.response.EquipmentResponse;
import com.java.course.isdb.dto.response.EquipmentToTeamResponse;
import com.java.course.isdb.dto.response.ListEquipmentPossessionResponse;
import com.java.course.isdb.dto.response.ListEquipmentResponse;
import com.java.course.isdb.service.EnterpriseEquipmentService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@CrossOrigin
@RequestMapping("equipment")
public class EnterpriseEquipmentController {

    private final EnterpriseEquipmentService enterpriseEquipmentService;

    @PostMapping("/add")
    public EquipmentResponse addEquipment(@RequestBody AddEquipmentRequest addEquipmentRequest){
        return EquipmentResponse.fromEntity(
                enterpriseEquipmentService.add(addEquipmentRequest.type(),
                        addEquipmentRequest.serialNumber(), addEquipmentRequest.description())
        );
    }

    @PostMapping("/toTeam")
    public EquipmentToTeamResponse addEquipmentToTeam(@RequestBody AddEquipmentPossessionRequest addEquipmentPossessionRequest){
        return EquipmentToTeamResponse.fromEntity(
                enterpriseEquipmentService.giveEquipmentToTeam(
                        addEquipmentPossessionRequest.employeeDivision(),
                        addEquipmentPossessionRequest.equipmentId(),
                        addEquipmentPossessionRequest.possessionStart(),
                        addEquipmentPossessionRequest.possessionEnd()
                )
        );
    }

    @GetMapping("/allEquipment")
    public ListEquipmentResponse getAllEquipment(){
        return ListEquipmentResponse.fromEntity(enterpriseEquipmentService.getAllEquipment());
    }

    @GetMapping("/allEquipmentPos")
    public ListEquipmentPossessionResponse getAllEquipmentPossession(){
        return ListEquipmentPossessionResponse.fromEntity(enterpriseEquipmentService.getAllEquipmentPossession());
    }
}
