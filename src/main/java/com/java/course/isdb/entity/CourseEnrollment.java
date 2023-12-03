package com.java.course.isdb.entity;

import com.java.course.isdb.entity.compositekey.CourseEnrollmentId;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import lombok.experimental.Accessors;

@Getter
@Setter
@Entity
@Table(name = "course_enrollment")
@Accessors(chain = true)
public class CourseEnrollment {

    @EmbeddedId
    private CourseEnrollmentId courseEnrollmentId;

    @ManyToOne
    @MapsId("employeeId")
    @JoinColumn(name = "employee_id")
    private Employee employee;

    @ManyToOne
    @MapsId("courseId")
    @JoinColumn(name = "course_id")
    private Course course;

    @Column(name = "is_finished", columnDefinition = "boolean default false")
    private Boolean isFinished;

}
