package com.racing.domain;

import java.util.List;
import java.util.stream.Collectors;

public class Cars {

    private final List<Car> cars;

    private Cars(final List<Car> cars) {
        this.cars = cars;
    }

    public static Cars from(final String names) {

        List<Car> cars = List.of(names.split(",")).stream()
                .map(Car::new)
                .toList();

        return new Cars(cars);
    }

    public void moveCars(int inputCount, final NumberGenerator numberGenerator) {
        for (int i = 0; i < inputCount; i++) {
            for (int j = 0; j < cars.size(); j++) {
                cars.get(j).move(numberGenerator.generateRandom());
            }
        }
    }

    public List<String> findWinnerNames() {
        int maxMoveCount = cars.stream()
                .mapToInt(Car::getMoveCount)
                .max()
                .orElse(0);

        return cars.stream()
                .filter(car -> car.isSameMoveCount(maxMoveCount))
                .map(Car::getCarNames)
                .collect(Collectors.toList());
    }
}
