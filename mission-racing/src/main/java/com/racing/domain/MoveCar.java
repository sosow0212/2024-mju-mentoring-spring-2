package com.racing.domain;

import java.util.List;

public class MoveCar {

    private final NumberGenerator numberGenerator;
    private int count = 0;

    public MoveCar(final NumberGenerator numberGenerator) {
        this.numberGenerator = numberGenerator;
    }

    public void moveCars(List<Cars> cars, int moveNumber) {
        for (int i = 0; i < moveNumber; i++) {
            for (Cars car : cars) {
                moveCar(car);
            }
        }
    }

    private void moveCar(Cars car) {
        if (numberGenerator.generateRandom() >= 4) {
            count++;
        }
    }
}
