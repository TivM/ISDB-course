package com.java.course.isdb.dto.response;

import com.java.course.isdb.entity.CourseEnrollment;

import java.util.List;

public record ListCourseEnrollmentResponse(List<CourseEnrollmentResponse> courseEnrollmentResponses){
    public static ListCourseEnrollmentResponse fromEntity(List<CourseEnrollment> courseEnrollments){
        return new ListCourseEnrollmentResponse(
                courseEnrollments.stream().map(CourseEnrollmentResponse::fromEntity).toList()
        );
    }
}
