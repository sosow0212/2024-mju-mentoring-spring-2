package com.racing.service.dto;

import com.racing.model.Cars;

import java.util.List;
import java.util.stream.Collectors;

public record RaceResult(
        List<CarStatus> status,
        List<String> winners
) {
    public static RaceResult resultResponse(Cars cars) {
        List<String> winners = cars.getRanks();
        List<CarStatus> status = getCarStatus(cars);
        return new RaceResult(status, winners);
    }

    public static List<CarStatus> getCarStatus(Cars cars) {
        return cars.getCarState().entrySet().stream()
                .map(entry ->new CarStatus(entry.getKey(), entry.getValue()))
                .collect(Collectors.toList());
    }
}
