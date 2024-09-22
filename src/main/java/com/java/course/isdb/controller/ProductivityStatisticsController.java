package com.java.course.isdb.controller;

import com.java.course.isdb.dto.request.AddProductivityStatisticsRequest;
import com.java.course.isdb.dto.response.ListProductivityStatisticsResponse;
import com.java.course.isdb.dto.response.ProductivityStatisticsResponse;
import com.java.course.isdb.service.ProductivityStatisticsService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@CrossOrigin
@RequestMapping("stats")
public class ProductivityStatisticsController {

    private final ProductivityStatisticsService productivityStatisticsService;

    @PostMapping()
    public ProductivityStatisticsResponse add(@RequestBody AddProductivityStatisticsRequest addProductivityStatisticsRequest){
        return ProductivityStatisticsResponse.fromEntity(
                productivityStatisticsService.add(
                        addProductivityStatisticsRequest.date(),
                        addProductivityStatisticsRequest.managerReview(),
                        addProductivityStatisticsRequest.employeeId(),
                        addProductivityStatisticsRequest.adminId())
        );
    }

    @GetMapping("")
    public ListProductivityStatisticsResponse getAll(){
        return ListProductivityStatisticsResponse.fromEntity(productivityStatisticsService.getAll());
    }

    @GetMapping("/{id}")
    public ProductivityStatisticsResponse getById(@PathVariable int id){
        return ProductivityStatisticsResponse.fromEntity(productivityStatisticsService.getById(id));
    }

    @DeleteMapping("/{id}")
    public void deleteById(@PathVariable int id){
        productivityStatisticsService.deleteById(id);
    }

    @PutMapping("/{id}")
    public ProductivityStatisticsResponse updateById(@PathVariable int id, @RequestBody AddProductivityStatisticsRequest addProductivityStatisticsRequest){
        return ProductivityStatisticsResponse.fromEntity(productivityStatisticsService.updateById(id,
                addProductivityStatisticsRequest.date(),
                addProductivityStatisticsRequest.managerReview(),
                addProductivityStatisticsRequest.employeeId(),
                addProductivityStatisticsRequest.adminId()));
    }

}
