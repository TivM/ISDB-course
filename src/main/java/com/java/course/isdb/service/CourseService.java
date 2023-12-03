package com.java.course.isdb.service;

import com.java.course.isdb.entity.Course;

public interface CourseService {

    Course add(String name, String description, String category);

    void assignCourseToTeam(String employeeDivision, int courseId);
}
