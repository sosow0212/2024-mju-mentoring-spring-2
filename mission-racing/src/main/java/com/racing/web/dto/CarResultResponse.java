package com.racing.web.dto;

import java.util.List;

public record CarResultResponse(String winner, List<CarStatusResponse> status) {

    public static CarResultResponse from(String winner, List<CarStatusResponse> status) {
        return new CarResultResponse(winner, status);
    }
}
