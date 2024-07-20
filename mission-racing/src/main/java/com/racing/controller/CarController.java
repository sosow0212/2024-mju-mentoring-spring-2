package com.racing.controller;

import com.racing.model.Cars;
import com.racing.view.InputView;
import com.racing.view.OutputView;

import java.util.List;

public class CarController {

    private final InputView inputView;
    private final OutputView outputView;

    public CarController(InputView inputView, OutputView outputView) {
        this.inputView = inputView;
        this.outputView = outputView;
    }

    public void Run() {
        String inputNames = inputView.inputName();
        Cars cars = new Cars(inputNames);
        int inputCounts = inputView.inputCount();

        for (int count = 0; count < inputCounts; count++) {
            cars.moveCars();
            outputView.printRunResult(cars.getCarState());
        }

        List<String> winners = cars.rankCars();
        outputView.printWinners(winners);
    }
}
