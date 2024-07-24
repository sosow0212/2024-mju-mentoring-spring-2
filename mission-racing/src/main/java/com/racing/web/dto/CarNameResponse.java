package com.racing.web.dto;

import com.fasterxml.jackson.annotation.JsonValue;

public class CarNameResponse {

    private final String carName;

    public CarNameResponse(String carName) {
        this.carName = carName;
    }

    public static CarNameResponse form(String carName) {
        return new CarNameResponse(carName);
    }

    @JsonValue
    public String getCarName() {
        return carName;
    }
}
