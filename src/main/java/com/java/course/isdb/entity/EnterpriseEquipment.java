package com.java.course.isdb.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import lombok.experimental.Accessors;

import java.util.HashSet;
import java.util.Set;

@Getter
@Setter
@Entity
@Table(name = "enterprise_equipment")
@Accessors(chain = true)
public class EnterpriseEquipment {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Integer id;

    @Column(name = "type")
    private String type;

    //serialNumber > 0
    @Column(name = "serial_number", nullable = false)
    private Integer serialNumber;

    @Column(name = "description")
    private String description;

    @OneToMany(mappedBy = "enterpriseEquipment")
    private Set<EquipmentPossession> equipmentPossessions = new HashSet<>();

    public void addEquipmentPossession(EquipmentPossession equipmentPossession){
        equipmentPossessions.add(equipmentPossession);
        equipmentPossession.setEnterpriseEquipment(this);
    }

}
