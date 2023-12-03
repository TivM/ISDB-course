package com.java.course.isdb.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import lombok.experimental.Accessors;
import org.hibernate.annotations.SecondaryRow;

import java.time.LocalDate;

@Getter
@Setter
@Entity
@Table(name = "task")
@Accessors(chain = true)
public class Task {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Integer id;

    @Column(name = "start_date")
    private LocalDate startDate;

    @Column(name = "end_date")
    private LocalDate endDate;

    //complexity>=0
    @Column(name = "complexity", nullable = false)
    private Integer complexity;

    @Column(name = "status", columnDefinition = "varchar default 'New'")
    private String status;

    @ManyToOne
    @JoinColumn(name = "productivity_statistics_id")
    private ProductivityStatistics productivityStatistics;
}
