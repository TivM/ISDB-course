package com.java.course.isdb.controller;

import com.java.course.isdb.dto.request.AddCourseRequest;
import com.java.course.isdb.dto.request.AddCourseToTeamRequest;
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
@RequestMapping("course")
public class CourseController {

    private final CourseService courseService;

    @PostMapping("/add")
    public CourseResponse addCourse(@RequestBody AddCourseRequest addCourseRequest){
        return CourseResponse.fromEntity(
                courseService.add(addCourseRequest.name(), addCourseRequest.description(), addCourseRequest.category())
        );
    }

    @PostMapping("/toTeam")
    public CourseToTeamResponse addToTeam(@RequestBody AddCourseToTeamRequest addCourseToTeamRequest){
        return CourseToTeamResponse.fromEntity(
                courseService.assignCourseToTeam(addCourseToTeamRequest.employeeDivision(), addCourseToTeamRequest.courseId())
        );
    }

    @GetMapping("/allCourses")
    public ListCourseResponse getAllCourses(){
        return ListCourseResponse.fromEntity(courseService.getAllCourses());
    }

    @GetMapping("/allCourseEnroll")
    public ListCourseEnrollmentResponse getAllCourseEnrollments(){
        return ListCourseEnrollmentResponse.fromEntity(courseService.getAllCourseEnrollments());
    }

}
