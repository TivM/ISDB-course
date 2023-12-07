package com.java.course.isdb.dto.response;

import com.java.course.isdb.entity.Course;

public record CourseResponse(String name, String description, String category) {
    public static CourseResponse fromEntity(Course course){
        return new CourseResponse(course.getName(), course.getDescription(), course.getCategory());
    }
}
