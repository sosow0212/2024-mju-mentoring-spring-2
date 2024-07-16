package com.racing.controller;

import com.racing.model.Car;
import com.racing.model.Cars;
import com.racing.view.InputView;
import com.racing.view.OutputView;

import java.util.ArrayList;
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
        List<Car> carList = new ArrayList<>();
        Cars cars = new Cars(carList);
        cars.generateCarList(inputNames);
        int inputCounts = inputView.inputCount();

        for (int count = 0; count < inputCounts; count++) {
            cars.carsMove();
            outputView.printRunResult(cars.getCarState());
        }

        List<String> winners = cars.carRank();
        outputView.printWinners(winners);
    }
}
