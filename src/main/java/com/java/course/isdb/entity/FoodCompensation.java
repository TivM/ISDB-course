package com.java.course.isdb.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import lombok.experimental.Accessors;

import java.time.LocalDate;

@Getter
@Setter
@Entity
@Table(name = "food_compensation")
@Accessors(chain = true)
public class FoodCompensation {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Integer id;

    //payment_amount >= 0
    @Column(name = "payment_amount", nullable = false)
    private Integer paymentAmount;

    @Column(name = "compensation_date", nullable = false)
    private LocalDate compensationDate;

    @Column(name = "is_breakfast")
    private Boolean isBreakfast;

    @ManyToOne
    @JoinColumn(name = "employee_id")
    private Employee employee;

}
