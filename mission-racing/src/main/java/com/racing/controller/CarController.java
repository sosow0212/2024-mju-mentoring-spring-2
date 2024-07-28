package com.racing.controller;

import com.racing.model.Cars;
import com.racing.model.RandomNumber;
import com.racing.view.InputView;
import com.racing.view.OutputView;

import java.util.List;

public class CarController {

    private final InputView inputView;
    private final OutputView outputView;
    private final RandomNumber randomNumber;

    public CarController(InputView inputView, OutputView outputView, RandomNumber randomNumber) {
        this.inputView = inputView;
        this.outputView = outputView;
        this.randomNumber = randomNumber;
    }

    public void run() {
        String inputNames = inputView.inputName();
        Cars cars = Cars.from(inputNames, randomNumber);
        int inputCounts = inputView.inputCount();

        for (int count = 0; count < inputCounts; count++) {
            cars.moveCars();
            outputView.printRunResult(cars.getCarState());
        }

        List<String> winners = cars.getRanks();
        outputView.printWinners(winners);
    }
}
