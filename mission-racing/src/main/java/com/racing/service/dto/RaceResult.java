package com.racing.service.dto;

import com.racing.model.Cars;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public record RaceResult(
        List<Map<String, Integer>> status,
        List<String> winners
) {
    public static RaceResult resultResponse(Cars cars) {
        List<String> winners = cars.rankCars();
        List<Map<String, Integer>> status = getCarStatus(cars);
        return new RaceResult(status, winners);
    }

    public static List<Map<String, Integer>> getCarStatus(Cars cars) {
        return cars.getCarState().entrySet().stream()
                .map(entry -> Map.of(entry.getKey(), entry.getValue()))
                .collect(Collectors.toList());
    }
}
