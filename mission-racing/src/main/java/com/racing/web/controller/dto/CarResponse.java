package com.racing.web.controller.dto;

import com.racing.common.domain.Cars;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public record CarResponse(List<Map<String, Integer>> carStates, List<String> winners) {

    public static CarResponse from(Cars cars) {
        List<String> winners = cars.findsWinner();
        return getCarResponse(cars, winners);
    }

    private static CarResponse getCarResponse(final Cars cars, final List<String> winners) {
        List<Map<String, Integer>> carStates = cars.getCars().stream()
                .map(car -> Map.of(car.getName(), car.getMoveCount()))
                .collect(Collectors.toList());
        return new CarResponse(carStates, winners);
    }
}
