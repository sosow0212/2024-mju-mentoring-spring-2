package com.racing.controller;

import com.racing.domain.Cars;
import com.racing.domain.NumberGenerator;
import com.racing.view.Inputview;
import com.racing.view.Outputview;
import com.racing.domain.dto.WinnerResponse;

import java.util.List;

public class RacingController {

    private final Inputview inputview;
    private final Outputview outputview;
    private final NumberGenerator numberGenerator;

    public RacingController(final Inputview inputview, final Outputview outputview, final NumberGenerator numberGenerator) {
        this.inputview = inputview;
        this.outputview = outputview;
        this.numberGenerator = numberGenerator;
    }

    public void run() {
        String moveCarName = inputview.getMoveCarName();
        int chance = inputview.getChance();
        Cars cars = Cars.from(moveCarName);

        for (int i = 0; i < chance; i++) {
            cars.moveCars(1, numberGenerator);
            WinnerResponse winnerResponse = new WinnerResponse(cars.getCarStates(), cars.findsWinner());
            outputview.printRacingStep(winnerResponse);
        }

        List<String> winners = cars.findsWinner();
        outputview.printFinalWinner(winners);
    }
}
