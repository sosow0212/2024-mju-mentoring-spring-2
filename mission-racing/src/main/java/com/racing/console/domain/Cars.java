package com.racing.console.domain;

import java.util.List;
import java.util.ArrayList;

public class Cars {

    private final List<Car> cars;

    public Cars(List<String> carNames) {
        this.cars = makeCars(carNames);
    }

    public List<Car> getCars() {
        return cars;
    }

    private List<Car> makeCars(List<String> carNames) {
        List<Car> cars = new ArrayList<>();
        for (String carName : carNames) {
            Car car = new Car(carName);
            cars.add(car);
        }
        return cars;
    }
}
