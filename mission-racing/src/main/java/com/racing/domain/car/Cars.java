package com.racing.domain.car;

import com.racing.domain.number.RandomGenerator;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Cars {

    private static final String COMMA = ",";

    private final List<Car> cars;
    private final RandomGenerator randomGenerator;

    public Cars(final RandomGenerator randomGenerator) {
        this.randomGenerator = randomGenerator;
        this.cars = new ArrayList<>();
    }

    private List<String> createCars(String carNames) {
        return new ArrayList<>(Arrays.asList(carNames.split(COMMA)));
    }

    private void move(int moveNumber) {
        for (int i = 0; i < moveNumber; i++) {
            moveCar();
        }
    }

    private int moveCar() {
        int count = 0;
        return moveCount(count);
    }

    private int moveCount(int count) {
        if (randomGenerator.generateRandom() >= 4) {
            count++;
        }
        return count;
    }
}
