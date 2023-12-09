package com.java.course.isdb.service.Impl;

import com.java.course.isdb.entity.Course;
import com.java.course.isdb.entity.CourseEnrollment;
import com.java.course.isdb.entity.Employee;
import com.java.course.isdb.entity.compositekey.CourseEnrollmentId;
import com.java.course.isdb.exception.ResourceNotFoundException;
import com.java.course.isdb.repository.CourseEnrollmentRepository;
import com.java.course.isdb.repository.CourseRepository;
import com.java.course.isdb.repository.EmployeeRepository;
import com.java.course.isdb.service.CourseService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;


@Service
@RequiredArgsConstructor
public class CourseServiceImpl implements CourseService {

    private final CourseRepository courseRepository;
    private final CourseEnrollmentRepository courseEnrollmentRepository;
    private final EmployeeRepository employeeRepository;

    @Override
    @Transactional
    public Course add(String name, String description, String category) {
        Course course = new Course()
                .setName(name)
                .setDescription(description)
                .setCategory(category);

        courseRepository.save(course);

        return course;
    }

    @Override
    @Transactional
    public Course assignCourseToTeam(String employeeDivision, int courseId) {
        List<Employee> employees = employeeRepository.findByDivision(employeeDivision);
        if (employees.isEmpty()){
            throw new RuntimeException("0 employees in division");
        }

        Course course = courseRepository.findById(courseId).orElseThrow(
                () -> new ResourceNotFoundException("course doesn't exist")
        );

        for (Employee employee : employees){
            CourseEnrollmentId courseEnrollmentId = new CourseEnrollmentId()
                    .setCourseId(courseId)
                    .setEmployeeId(employee.getId());

            CourseEnrollment courseEnrollment = new CourseEnrollment()
                    .setCourseEnrollmentId(courseEnrollmentId);

            employee.addCourseEnrollment(courseEnrollment);
            course.addCourseEnrollment(courseEnrollment);
        }

        courseEnrollmentRepository.assignCourseToTeam(employeeDivision, courseId);

        return course;
    }

    @Override
    public List<Course> getAllCourses() {
        return courseRepository.findAll();
    }

    @Override
    public List<CourseEnrollment> getAllCourseEnrollments() {
        return courseEnrollmentRepository.findAll();
    }
}
