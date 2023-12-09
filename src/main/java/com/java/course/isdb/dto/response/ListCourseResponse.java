package com.java.course.isdb.dto.response;

import com.java.course.isdb.entity.Course;

import java.util.List;

public record ListCourseResponse(List<CourseResponse> courseResponses) {
    public static ListCourseResponse fromEntity(List<Course> courses){
        return new ListCourseResponse(
                courses.stream().map(CourseResponse::fromEntity).toList()
        );
    }
}
