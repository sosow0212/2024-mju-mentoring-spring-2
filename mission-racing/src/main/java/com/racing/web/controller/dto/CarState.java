package com.racing.web.controller.dto;

import com.racing.common.domain.Car;

public record CarState(String name, int moveCount) {
    public static CarState from(Car car) {
        return new CarState(car.getName(), car.getMoveCount());
    }
}
