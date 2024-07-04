package com.racing.domain.car;

import com.racing.domain.moveNumber.RandomGenerator;

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
        List<String> carList = new ArrayList<>(Arrays.asList(carNames.split(COMMA)));
        return carList;
    }

    private int moveCars() {
        int count = 0;
        if (randomGenerator.generateRandom() >= 4) {
            count++;
        }
        return count;
    }
}
