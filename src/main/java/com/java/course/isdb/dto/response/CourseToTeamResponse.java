package com.java.course.isdb.dto.response;

import com.java.course.isdb.entity.Course;
import com.java.course.isdb.entity.CourseEnrollment;
import com.java.course.isdb.entity.Employee;

import java.util.List;

public record CourseToTeamResponse(int courseId, String courseName, List<Integer> employeeIds) {
    public static CourseToTeamResponse fromEntity(Course course){
        return new CourseToTeamResponse(
                course.getId(),
                course.getName(),
                course.getCourseEnrollments()
                        .stream()
                        .map(CourseEnrollment::getEmployee)
                        .map(Employee::getId)
                        .toList()
        );
    }
}
