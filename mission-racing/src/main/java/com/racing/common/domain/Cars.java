package com.racing.common.domain;

import com.racing.common.domain.vo.Name;

import java.util.List;
import java.util.ArrayList;

public class Cars {

    private final List<Car> cars;

    public Cars(List<Name> carNames) {
        this.cars = makeCars(carNames);
    }

    public List<Car> getCars() {
        return cars;
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
