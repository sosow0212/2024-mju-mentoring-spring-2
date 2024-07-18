package com.racing.web.service;

import com.racing.common.domain.Car;
import com.racing.common.domain.Cars;
import com.racing.common.domain.NumberGenerator;

import com.racing.web.controller.dto.CarResponse;
import com.racing.web.service.dto.CarState;
import com.racing.web.service.dto.StartRaceRequest;

import com.racing.web.service.exception.NotFoundCar;
import com.racing.web.service.exception.CarNullException;

import org.springframework.stereotype.Service;


@Service
public class RacingService {

    private final NumberGenerator numberGenerator;
    private Cars cars;

    public RacingService(NumberGenerator numberGenerator) {
        this.numberGenerator = numberGenerator;
    }

    public void registerCars(StartRaceRequest request) {
        this.cars = Cars.from(request.carNames());
    }

    public Cars startRace(StartRaceRequest request) {
        validateCarState();
        cars.moveCars(request.tryCount(), numberGenerator);
        return cars;
    }

    public Cars getRaceResult() {
        validateCarState();
        return cars;
    }

    public Car getCarStateByName(String name) {
        validateCarState();
        return getCar(name);
    }

    private Car getCar(final String name) {
        return cars.getCars().stream()
                .filter(c -> c.getName().equals(name))
                .findFirst()
                .orElseThrow(NotFoundCar::new);
    }

    private void validateCarState() {
        if (this.cars == null) {
            throw new CarNullException();
        }
    }
}
