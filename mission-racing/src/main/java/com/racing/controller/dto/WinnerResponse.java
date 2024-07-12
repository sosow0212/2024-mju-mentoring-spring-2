package com.racing.controller.dto;

import com.racing.domain.Cars;
import com.racing.domain.NumberGenerator;
import lombok.Getter;

import java.util.List;

public class WinnerResponse {

    private NumberGenerator numberGenerator;

    @Getter
    private final List<String> carStates;
    @Getter
    private final List<String> winners;

    public WinnerResponse(final List<String> carStates,
                          final List<String> winners) {
        this.carStates = carStates;
        this.winners = winners;
    }

    public WinnerResponse race(final Cars cars, final int chance) {
        MoveRacingCar(cars, chance);
        return new WinnerResponse(cars.getCarStates(), cars.findsWinner());
    }

    private void MoveRacingCar(final Cars cars, final int chance) {
        for (int i = 0; i < chance; i++) {
            cars.moveCars(1, numberGenerator);
        }
    }
}
