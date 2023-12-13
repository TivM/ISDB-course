package com.java.course.isdb.dto.response;

import com.java.course.isdb.entity.Course;

public record CourseResponse(int id, String name, String description, String category) {
    public static CourseResponse fromEntity(Course course){
        return new CourseResponse(course.getId(), course.getName(), course.getDescription(), course.getCategory());
    }
}
