package com.java.course.isdb.entity;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import lombok.experimental.Accessors;

import java.util.HashSet;
import java.util.Set;

@Getter
@Setter
@Entity
@Table(name = "employee")
@Accessors(chain = true)
public class Employee {

    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "name", nullable = false)
    private String name;

    @Column(name = "age", nullable = false)
    private Integer age;

    @Column(name = "division")
    private String division;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "admin_id")
    private Admin admin;

    @OneToMany(mappedBy = "employee")
    private Set<WorkTime> workTimes = new HashSet<>();

    @OneToMany(mappedBy = "employee")
    private Set<FoodCompensation> foodCompensations = new HashSet<>();

    @OneToMany(mappedBy = "employee")
    private Set<DayoffRequest> dayoffRequests = new HashSet<>();

    @OneToMany(mappedBy = "employee")
    private Set<ProductivityStatistics> productivityStatisticsSet = new HashSet<>();

    @OneToMany(mappedBy = "employee")
    private Set<EquipmentPossession> equipmentPossessions = new HashSet<>();

    @OneToMany(mappedBy = "employee")
    private Set<CourseEnrollment> courseEnrollments = new HashSet<>();

    public void addCourseEnrollment(CourseEnrollment courseEnrollment) {
        courseEnrollments.add(courseEnrollment);
        courseEnrollment.setEmployee(this);
    }

    public void addEquipmentPossession(EquipmentPossession equipmentPossession){
        equipmentPossessions.add(equipmentPossession);
        equipmentPossession.setEmployee(this);
    }

    public void addFoodCompensation(FoodCompensation foodCompensation){
        foodCompensations.add(foodCompensation);
        foodCompensation.setEmployee(this);
    }

    public void addDayoffRequest(DayoffRequest dayoffRequest){
        dayoffRequests.add(dayoffRequest);
        dayoffRequest.setEmployee(this);
    }

    public void addProductivityStatistics(ProductivityStatistics productivityStatistics) {
        productivityStatisticsSet.add(productivityStatistics);
        productivityStatistics.setEmployee(this);
    }
}
