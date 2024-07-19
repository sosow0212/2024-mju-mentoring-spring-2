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

    public List<Car> getCars() {
        return cars;
    }

    public static List<String> getWinner(List<Car> carBundle) {
        return carBundle.stream()
                .filter(car -> isMaxCount(carBundle, car))
                .map(Car::getCarName)
                .collect(Collectors.toList());
    }

    private static boolean isMaxCount(List<Car> carBundle, Car car) {
        return car.getMoveCount() == getMaxCount(carBundle);
    }

    private static int getMaxCount(List<Car> carBundle) {
        return carBundle.stream()
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
