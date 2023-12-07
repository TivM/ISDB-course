package com.java.course.isdb.controller;

import com.java.course.isdb.dto.request.AddProductivityStatisticsRequest;
import com.java.course.isdb.dto.response.ListProductivityStatisticsResponse;
import com.java.course.isdb.dto.response.ProductivityStatisticsResponse;
import com.java.course.isdb.service.ProductivityStatisticsService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping("stat")
public class ProductivityStatisticsController {

    private final ProductivityStatisticsService productivityStatisticsService;

    @PostMapping("/add")
    public ProductivityStatisticsResponse add(@RequestBody AddProductivityStatisticsRequest addProductivityStatisticsRequest){
        return ProductivityStatisticsResponse.fromEntity(
                productivityStatisticsService.add(
                        addProductivityStatisticsRequest.date(),
                        addProductivityStatisticsRequest.managerReview(),
                        addProductivityStatisticsRequest.employeeId(),
                        addProductivityStatisticsRequest.adminId())
        );
    }

    @GetMapping("/all")
    public ListProductivityStatisticsResponse getAll(){
        return ListProductivityStatisticsResponse.fromEntity(productivityStatisticsService.getAll());
    }


}
