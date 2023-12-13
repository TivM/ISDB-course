package com.java.course.isdb.service.Impl;

import com.java.course.isdb.entity.*;
import com.java.course.isdb.entity.compositekey.CourseEnrollmentId;
import com.java.course.isdb.exception.ResourceNotFoundException;
import com.java.course.isdb.repository.EmployeeRepository;
import com.java.course.isdb.repository.EnterpriseEquipmentRepository;
import com.java.course.isdb.repository.EquipmentPossessionRepository;
import com.java.course.isdb.service.EnterpriseEquipmentService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDate;
import java.util.List;

@Service
@RequiredArgsConstructor
public class EnterpriseEquipmentServiceImpl implements EnterpriseEquipmentService {

    private final EnterpriseEquipmentRepository enterpriseEquipmentRepository;
    private final EquipmentPossessionRepository equipmentPossessionRepository;
    private final EmployeeRepository employeeRepository;

    @Override
    @Transactional
    public EnterpriseEquipment add(String type, int serialNumber, String description) {
        EnterpriseEquipment enterpriseEquipment = new EnterpriseEquipment()
                .setType(type)
                .setSerialNumber(serialNumber)
                .setDescription(description);

        enterpriseEquipmentRepository.save(enterpriseEquipment);

        return enterpriseEquipment;
    }

    @Override
    @Transactional
    public EnterpriseEquipment giveEquipmentToTeam(String employeeDivision, int equipmentId, LocalDate possessionStart, LocalDate possessionEnd) {
        List<Employee> employees = employeeRepository.findByDivision(employeeDivision);
        if (employees.isEmpty()){
            throw new ResourceNotFoundException("0 employees in division");
        }

        EnterpriseEquipment enterpriseEquipment = enterpriseEquipmentRepository.findById(equipmentId).orElseThrow(
                () -> new ResourceNotFoundException("equipment doesn't exist")
        );

        for (Employee employee : employees){
            EquipmentPossession equipmentPossession = new EquipmentPossession()
                    .setStartDate(possessionStart)
                    .setEndDate(possessionEnd);

            employee.addEquipmentPossession(equipmentPossession);
            enterpriseEquipment.addEquipmentPossession(equipmentPossession);
        }

        equipmentPossessionRepository.giveEquipmentToTeam(employeeDivision, equipmentId, possessionStart, possessionEnd);

        return enterpriseEquipment;
    }

    @Override
    public List<EnterpriseEquipment> getAllEquipment() {
        return enterpriseEquipmentRepository.findAll();
    }

    @Override
    public List<EquipmentPossession> getAllEquipmentPossession() {
        return equipmentPossessionRepository.findAll();
    }
}
