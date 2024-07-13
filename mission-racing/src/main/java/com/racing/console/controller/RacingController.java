package com.racing.console.controller;

import com.racing.common.controller.dto.WinnerResponse;
import com.racing.common.domain.Cars;
import com.racing.common.domain.NumberGenerator;
import com.racing.console.view.InputView;
import com.racing.console.view.OutputView;
import com.racing.console.view.dto.ResultResponse;

public class RacingController {

    private final InputView inputview;
    private final OutputView outputview;
    private final NumberGenerator numberGenerator;

    public RacingController(
            final InputView inputview,
            final OutputView outputview,
            final NumberGenerator numberGenerator
    ) {
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
