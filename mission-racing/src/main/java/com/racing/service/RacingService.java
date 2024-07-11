package com.racing.service;

import com.racing.domain.Cars;
import com.racing.domain.NumberGenerator;
import com.racing.domain.dto.WinnerResponse;
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

    public WinnerResponse race(Cars cars, int chance) {
        for (int i = 0; i < chance; i++) {
            cars.moveCars(1, numberGenerator);
        }
        return new WinnerResponse(cars.getCarStates(), cars.findsWinner());
    }
}
