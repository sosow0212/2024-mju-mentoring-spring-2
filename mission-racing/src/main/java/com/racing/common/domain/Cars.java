package com.racing.common.domain;

import com.racing.common.domain.vo.Name;

import java.util.List;
import java.util.ArrayList;
import java.util.Map;
import java.util.stream.Collectors;

public class Cars {

    private static final int INITIAL_NUMBER = 0;

    private final List<Car> cars;

    public Cars(List<Name> carNames) {
        this.cars = makeCars(carNames);
    }

    public List<Car> getCars() {
        return cars;
    }

    public List<String> getWinner() {
        int maxCount = cars.stream()
                .mapToInt(Car::getMoveCount)
                .max()
                .orElse(INITIAL_NUMBER);

        return cars.stream()
                .filter(car -> car.getMoveCount() == maxCount)
                .map(Car::getCarName)
                .collect(Collectors.toList());
    }

    public List<Object> getStatus() {
        List<Object> status = new ArrayList<>();
        for (Car car : cars) {
            status.add(Map.of(car.getCarName(), car.moveCount));
        }
        return status;
    }


    private List<Car> makeCars(List<Name> carNames) {
        List<Car> cars = new ArrayList<>();
        for (Name carName : carNames) {
            Car car = new Car(carName.getName());
            cars.add(car);
        }
        return cars;
    }
}
