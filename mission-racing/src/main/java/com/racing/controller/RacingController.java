package com.racing.controller;

import com.racing.controller.dto.WinnerResponse;
import com.racing.domain.Cars;
import com.racing.domain.NumberGenerator;
import com.racing.view.Inputview;
import com.racing.view.Outputview;
import com.racing.view.dto.ResultResponse;

public class RacingController {

    private final Inputview inputview;
    private final Outputview outputview;
    private final NumberGenerator numberGenerator;

    public RacingController(final Inputview inputview,
                            final Outputview outputview,
                            final NumberGenerator numberGenerator) {
        this.inputview = inputview;
        this.outputview = outputview;
        this.numberGenerator = numberGenerator;
    }

    public void run() {
        String moveCarName = inputview.getMoveCarName();
        int chance = inputview.getChance();
        Cars cars = Cars.from(moveCarName);
        raceCars(chance, cars);
        displayWinner(cars);
    }

    public WinnerResponse raceCars(int chance, Cars cars) {
        for (int i = 0; i < chance; i++) {
            cars.moveCars(1, numberGenerator);
            ResultResponse resultResponse = new ResultResponse(cars.getCarStates(), cars.findsWinner());
            outputview.printRacingStep(resultResponse);
        }
        return new WinnerResponse(cars.getCarStates(), cars.findsWinner());
    }

    private void displayWinner(Cars cars) {
        ResultResponse resultResponse = new ResultResponse(cars.getCarStates(), cars.findsWinner());
        outputview.printRacingWinner(resultResponse);
    }
}
