package com.racing.web.service;

import com.racing.common.domain.Car;
import com.racing.common.domain.Cars;
import com.racing.common.domain.NumberGenerator;

import com.racing.web.service.dto.CarResponse;
import com.racing.web.service.dto.StartRaceRequest;

import org.springframework.stereotype.Service;

import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@Service
public class RacingService {

    private final NumberGenerator numberGenerator;
    private Cars cars;

    public RacingService(NumberGenerator numberGenerator) {
        this.numberGenerator = numberGenerator;
    }

    public void registerCars(StartRaceRequest request) {
        cars = Cars.from(request.carNames());
    }

    public CarResponse startRace(StartRaceRequest request) {
        cars.moveCars(request.tryCount(), numberGenerator);
        return getRaceResult();
    }

    public CarResponse getRaceResult() {
        List<String> winners = cars.findsWinner();
        List<Map<String, Integer>> carStates = cars.getCars().stream()
                .map(RacingService::MapMoveCount)
                .collect(Collectors.toList());
        return new CarResponse(carStates, winners);
    }

    public Map<String, Integer> getRaceResultByName(String name) {
        Car car = carName(name);
        return MapMoveCount(car);
    }

    private static Map<String, Integer> MapMoveCount(final Car car) {
        Map<String, Integer> result = new LinkedHashMap<>();
        result.put(car.getName(), car.getMoveCount());
        return result;
    }

    private Car carName(final String name) {
        return cars.getCars().stream()
                .filter(c -> c.getName().equals(name))
                .findFirst()
                .orElseThrow(() -> new RuntimeException(name));
    }
}
