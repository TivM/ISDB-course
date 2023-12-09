package com.java.course.isdb.dto.response;

import com.java.course.isdb.entity.CourseEnrollment;

public record CourseEnrollmentResponse(int employeeId, int courseId, boolean isFinished){
    public static CourseEnrollmentResponse fromEntity(CourseEnrollment courseEnrollment){
        return new CourseEnrollmentResponse(
                courseEnrollment.getEmployee().getId(),
                courseEnrollment.getCourse().getId(),
                courseEnrollment.getIsFinished()
        );
    }
}
