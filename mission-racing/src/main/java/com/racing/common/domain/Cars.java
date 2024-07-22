package com.racing.common.domain;

import com.racing.common.domain.vo.Name;

import java.util.List;
import java.util.ArrayList;
import java.util.stream.Collectors;

public class Cars {

    private static final int INITIAL_NUMBER = 0;

    private final List<Car> cars;

    public Cars(List<Name> carNames) {
        this.cars = makeCars(carNames);
    }

    public Cars(List<Car> carBundle, boolean dummy){
        this.cars = carBundle;
    }

    public List<Car> getCars() {
        return cars;
    }

    public List<String> getWinner() {
        return cars.stream()
                .filter(this::isMaxCount)
                .map(Car::getCarName)
                .collect(Collectors.toList());
    }

    private boolean isMaxCount(Car car) {
        return car.getMoveCount() == getMaxCount();
    }

    private int getMaxCount() {
        return cars.stream()
                .mapToInt(Car::getMoveCount)
                .max()
                .orElse(INITIAL_NUMBER);
    }

    private List<Car> makeCars(List<Name> carNames) {
        List<Car> cars = new ArrayList<>();
        for (Name carName : carNames) {
            Car car = new Car(INITIAL_NUMBER, carName.getName());
            cars.add(car);
        }
        return cars;
    }
}
