package com.java.course.isdb.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import lombok.experimental.Accessors;

import java.time.LocalDate;

@Getter
@Setter
@Entity
@Table(name = "dayoff_request")
@Accessors(chain = true)
public class DayoffRequest {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Integer id;

    @Column(name = "start_date")
    private LocalDate startDate;

    @Column(name = "end_date")
    private LocalDate endDate;

    @Column(name = "is_approved", columnDefinition = "boolean default false")
    private Boolean isApproved;

    @ManyToOne
    @JoinColumn(name = "employee_id")
    private Employee employee;
}
