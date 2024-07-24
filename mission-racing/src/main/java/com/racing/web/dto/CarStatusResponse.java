package com.racing.web.dto;

import com.fasterxml.jackson.annotation.JsonAnyGetter;

import java.util.Map;

public class CarStatusResponse {

    private final Map<CarNameResponse, MoveCountResponse> carStatus;

    public CarStatusResponse(CarNameResponse carNameResponse, MoveCountResponse moveCountResponse) {
        this.carStatus = Map.of(carNameResponse, moveCountResponse);
    }

    public static CarStatusResponse from(CarNameResponse carNameResponse, MoveCountResponse moveCountResponse) {
        return new CarStatusResponse(carNameResponse, moveCountResponse);
    }

    @JsonAnyGetter
    public Map<CarNameResponse, MoveCountResponse> getCarStatusResponse() {
        return carStatus;
    }
}
