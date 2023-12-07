package com.java.course.isdb.dto.response;

import com.java.course.isdb.entity.ProductivityStatistics;

import java.util.List;

public record ListProductivityStatisticsResponse(List<ProductivityStatisticsResponse> productivityStatisticsResponses){
    public static ListProductivityStatisticsResponse fromEntity(List<ProductivityStatistics> productivityStatisticsList){
        return new ListProductivityStatisticsResponse(
                productivityStatisticsList.stream().map(ProductivityStatisticsResponse::fromEntity).toList()
        );
    }
}
