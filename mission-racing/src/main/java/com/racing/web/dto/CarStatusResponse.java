package com.racing.web.dto;

import com.fasterxml.jackson.annotation.JsonAnyGetter;

import java.util.Map;

public class CarStatusResponse {

    private final Map<String, Integer> carStatus;

    public CarStatusResponse(Map<String, Integer> carStatus) {
        this.carStatus = carStatus;
    }

    public static CarStatusResponse from(Map<String, Integer> carState) {
        return new CarStatusResponse(carState);
    }

    @JsonAnyGetter
    public Map<String, Integer> getCarStatusResponse() {
        return carStatus;
    }
}
