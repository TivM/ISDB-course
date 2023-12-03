package com.java.course.isdb.repository;

import com.java.course.isdb.entity.EnterpriseEquipment;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EnterpriseEquipmentRepository extends JpaRepository<EnterpriseEquipment, Integer> {
}
