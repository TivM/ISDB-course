package com.java.course.isdb.dto.response;

public record CompensationSumResponse(Integer compensationSum) {
    public static CompensationSumResponse fromEntity(Integer sum){
        return new CompensationSumResponse(sum);
    }
}
