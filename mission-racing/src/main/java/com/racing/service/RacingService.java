package com.racing.service;

import com.racing.controller.dto.WinnerResponse;
import com.racing.domain.Cars;
import com.racing.domain.NumberGenerator;
import com.racing.service.dto.StartRaceRequest;
import org.springframework.stereotype.Service;

@Service
public class RacingService {

    private final NumberGenerator numberGenerator;

    public RacingService(NumberGenerator numberGenerator) {
        this.numberGenerator = numberGenerator;
    }

    public Cars createCars(String carNames) {
        return Cars.from(carNames);
    }

    public WinnerResponse startRace(StartRaceRequest request) {
        Cars cars = createCars(request.carNames());
        return raceCars(request.tryCount(), cars);
    }

    private WinnerResponse raceCars(int chance, Cars cars) {
        for (int i = 0; i < chance; i++) {
            cars.moveCars(1, numberGenerator);
        }
        return new WinnerResponse(cars.getCarStates(), cars.findsWinner());
    }
}
