package com.example.racingspring.service;

import com.example.racingspring.domain.Cars;
import com.example.racingspring.domain.NumberGenerator;
import com.example.racingspring.domain.dto.WinnerResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RacingService {

    private final NumberGenerator numberGenerator;
    private Cars cars;

    @Autowired
    public RacingService(final NumberGenerator numberGenerator, final Cars cars) {
        this.numberGenerator = numberGenerator;
        this.cars = cars;
    }

    public WinnerResponse runRace(String moveCarName, int chance) {
        cars = Cars.from(moveCarName);
        move(chance);
        return new WinnerResponse(cars.getCarStates(), cars.findsWinner());
    }

    private void move(final int chance) {
        for (int i = 0; i < chance; i++) {
            cars.moveCars(1, numberGenerator);
        }
    }

    public List<String> getWinners() {
        return cars.findsWinner();
    }
}
