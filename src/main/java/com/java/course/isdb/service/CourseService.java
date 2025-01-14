package com.java.course.isdb.service;

import com.java.course.isdb.entity.Course;
import com.java.course.isdb.entity.CourseEnrollment;

import java.util.List;

public interface CourseService {

    Course add(String name, String description, String category);

    Course assignCourseToTeam(String employeeDivision, int courseId);

    List<Course> getAllCourses();

    List<CourseEnrollment> getAllCourseEnrollments();

    void deleteById(int id);

    void deleteEnrollment(int courseId, int employeeId);
}
