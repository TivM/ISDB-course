package com.java.course.isdb.controller;

import com.java.course.isdb.dto.request.AddCourseRequest;
import com.java.course.isdb.dto.request.AddCourseToTeamRequest;
import com.java.course.isdb.dto.request.DeleteCourseEnrollmentRequest;
import com.java.course.isdb.dto.response.CourseToTeamResponse;
import com.java.course.isdb.dto.response.CourseResponse;
import com.java.course.isdb.dto.response.ListCourseEnrollmentResponse;
import com.java.course.isdb.dto.response.ListCourseResponse;
import com.java.course.isdb.service.CourseService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@CrossOrigin
@RequestMapping("courses")
public class CourseController {

    private final CourseService courseService;

    @PostMapping()
    public CourseResponse addCourse(@RequestBody AddCourseRequest addCourseRequest){
        return CourseResponse.fromEntity(
                courseService.add(addCourseRequest.name(), addCourseRequest.description(), addCourseRequest.category())
        );
    }

    @PostMapping("/enrollments")
    public CourseToTeamResponse addToTeam(@RequestBody AddCourseToTeamRequest addCourseToTeamRequest){
        return CourseToTeamResponse.fromEntity(
                courseService.assignCourseToTeam(addCourseToTeamRequest.employeeDivision(), addCourseToTeamRequest.courseId())
        );
    }

    @GetMapping()
    public ListCourseResponse getAllCourses(){
        return ListCourseResponse.fromEntity(courseService.getAllCourses());
    }

    @GetMapping("/enrollments")
    public ListCourseEnrollmentResponse getAllCourseEnrollments(){
        return ListCourseEnrollmentResponse.fromEntity(courseService.getAllCourseEnrollments());
    }

    @DeleteMapping("/{id}")
    public void deleteCourseById(@PathVariable int id){
        courseService.deleteById(id);
    }

    @DeleteMapping("/enrollments")
    public void deleteCourseEnrollmentById(@RequestBody DeleteCourseEnrollmentRequest deleteCourseEnrollmentRequest){
        courseService.deleteEnrollment(deleteCourseEnrollmentRequest.courseId(), deleteCourseEnrollmentRequest.employeeId());
    }
}
