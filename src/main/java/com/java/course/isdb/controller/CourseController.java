package com.java.course.isdb.controller;

import com.java.course.isdb.dto.request.AddCourseRequest;
import com.java.course.isdb.dto.request.AddCourseToTeamRequest;
import com.java.course.isdb.dto.request.HireEmployeeRequest;
import com.java.course.isdb.dto.response.CourseResponse;
import com.java.course.isdb.service.CourseService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping("course")
public class CourseController {

    private final CourseService courseService;

    //need test
    @PostMapping("/add")
    public CourseResponse addCourse(@RequestBody AddCourseRequest addCourseRequest){
        return CourseResponse.fromEntity(
                courseService.add(addCourseRequest.name(), addCourseRequest.description(), addCourseRequest.category())
        );
    }

    @PostMapping("/toTeam")
    public ResponseEntity<?> addToTeam(@RequestBody AddCourseToTeamRequest addCourseToTeamRequest){
        courseService.assignCourseToTeam(addCourseToTeamRequest.employeeDivision(), addCourseToTeamRequest.courseId());
        return ResponseEntity.ok(addCourseToTeamRequest.courseId());
    }
}
