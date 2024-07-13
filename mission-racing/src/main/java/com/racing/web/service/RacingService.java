package com.racing.web.service;

import com.racing.common.controller.dto.WinnerResponse;
import com.racing.common.domain.Cars;
import com.racing.common.domain.NumberGenerator;
import com.racing.web.service.dto.StartRaceRequest;
import org.springframework.stereotype.Service;

@Service
public class RacingService {

    private final NumberGenerator numberGenerator;

    public RacingService(NumberGenerator numberGenerator) {
        this.numberGenerator = numberGenerator;
    }

    public WinnerResponse startRace(StartRaceRequest request) {
        Cars cars = Cars.from(request.carNames());
        return raceCars(request.tryCount(), cars);
    }

    private WinnerResponse raceCars(int chance, Cars cars) {
        for (int i = 0; i < chance; i++) {
            cars.moveCars(1, numberGenerator);
        }
        return new WinnerResponse(cars.getCarStates(), cars.findsWinner());
    }
}
