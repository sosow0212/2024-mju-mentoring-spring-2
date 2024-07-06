package com.racing.controller;

import com.racing.domain.Car;
import com.racing.domain.Cars;
import com.racing.domain.NumberGenerator;
import com.racing.domain.view.Outputview;

import java.util.ArrayList;
import java.util.List;

public class RacingController {

    private final NumberGenerator numberGenerator;
    private final Outputview outputview;

    public RacingController(final NumberGenerator numberGenerator, final Outputview outputview) {
        this.numberGenerator = numberGenerator;
        this.outputview = outputview;
    }

    public void run() {
        String name = intputView.getNames();
        int moveCount = inputView.getMoveCount();

        List<Car> cars = new Cars();
        for (String s : name.split(",")) {
            cars.add(new Car(s));
        }

        for (int i = 0; i < moveCount; i++) {
            for (Car car : cars) {
                car.move(numberGenerator.generateRandom());
            }
        }

        int maxMoveCount = 0;
        for (Car car : cars) {
            maxMoveCount = Math.max(maxMoveCount, car.getMoveCount());
        }

        List<String> winners = new ArrayList<>();
        for (Car car : cars) {
            if (car.getMoveCount() == maxMoveCount) {
                winners.add(car.getCarNames());
            }
        }

//        Cars cars = Cars.from(name);
//        cars.moveCars(moveCount, numberGenerator);
//        List<String> winnerNames = cars.findWinnerNames();
//        outputview.printResult(winnerNames);
    }
}

