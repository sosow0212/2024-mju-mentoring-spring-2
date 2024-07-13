package com.racing.console.controller;

import com.racing.common.domain.Cars;
import com.racing.common.domain.NumberGenerator;
import com.racing.common.view.dto.ResultResponse;
import com.racing.console.view.InputView;
import com.racing.console.view.OutputView;

import java.util.Arrays;
import java.util.List;

public class RacingController {

    private final InputView inputView;
    private final OutputView outputView;
    private final NumberGenerator numberGenerator;

    public RacingController(
            final InputView inputView,
            final OutputView outputView,
            final NumberGenerator numberGenerator
    ) {
        this.inputView = inputView;
        this.outputView = outputView;
        this.numberGenerator = numberGenerator;
    }

    public void run() {
        String moveCarName = inputView.getMoveCarName();
        int chance = inputView.getChance();
        List<String> carNames = Arrays.asList(moveCarName.split(","));
        Cars cars = Cars.from(moveCarName);
        raceCars(chance, cars, carNames);
    }

    public void raceCars(int chance, Cars cars, List<String> carNames) {
        for (int i = 0; i < chance; i++) {
            cars.moveCars(1, numberGenerator);
            ResultResponse resultResponse = new ResultResponse(cars.getCarStates(), cars.findsWinner());
            displayRacingStep(resultResponse, carNames);
        }
        displayWinner(new ResultResponse(cars.getCarStates(), cars.findsWinner()));
    }

    private void displayRacingStep(ResultResponse resultResponse, List<String> carNames) {
        outputView.printRacingStep(resultResponse, carNames);
    }

    private void displayWinner(ResultResponse winnerResponse) {
        outputView.printRacingWinner(winnerResponse);
    }
}
