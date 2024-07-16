package com.racing.web.service;

import com.racing.common.domain.Cars;
import com.racing.common.domain.NumberGenerator;

import com.racing.common.dto.ResultResponse;

import com.racing.web.service.dto.CarResponse;
import com.racing.web.service.dto.StartRaceRequest;

import org.springframework.stereotype.Service;

@Service
public class RacingService {

    private final NumberGenerator numberGenerator;
    private CarResponse carResponse;
    private Cars cars;

    public RacingService(NumberGenerator numberGenerator) {
        this.numberGenerator = numberGenerator;
    }

    public void registerCars(StartRaceRequest request) {
        cars = Cars.from(request.carNames());
    }

    public ResultResponse startRace(StartRaceRequest request) {
        return raceCars(request.tryCount(), cars);
    }

    public ResultResponse getRaceResult(StartRaceRequest request) {
        return new ResultResponse(cars.getCarStates(), cars.findsWinner());
    }

    private ResultResponse raceCars(int chance, Cars cars) {
        for (int i = 0; i < chance; i++) {
            cars.moveCars(1, numberGenerator);
        }
        return new ResultResponse(cars.getCarStates(), cars.findsWinner());
    }

    public CarResponse getRaceResultByName(String name) {
        return cars.getCars().stream()
                .filter(car -> car.getName().equals(name))
                .findFirst()
                .map(car -> new CarResponse(car.getName(), carResponse.getMoveCount()))
                .orElse(new CarResponse(name, 0));
    }
}
