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
@Table(name = "course")
@Accessors(chain = true)
public class Course {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Integer id;

    @Column(name = "name", nullable = false)
    private String name;

    @Column(name = "description")
    private String description;

    @Column(name = "category")
    private String category;

    @OneToMany(mappedBy = "course")
    private Set<CourseEnrollment> courseEnrollments = new HashSet<>();

    public void addCourseEnrollment(CourseEnrollment courseEnrollment) {
        courseEnrollments.add(courseEnrollment);
        courseEnrollment.setCourse(this);
    }
}
