package com.java.course.isdb.repository;

import com.java.course.isdb.entity.CourseEnrollment;
import com.java.course.isdb.entity.compositekey.CourseEnrollmentId;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.query.Procedure;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CourseEnrollmentRepository extends JpaRepository<CourseEnrollment, CourseEnrollmentId> {

    List<CourseEnrollment> findByCourseId(int courseId);

    List<CourseEnrollment> findByEmployeeId(int employeeId);

    @Procedure(procedureName = "assign_course_to_team")
    void assignCourseToTeam(String employeeDivision, int courseId);
}
