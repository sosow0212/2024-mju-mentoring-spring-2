package com.racing.model;

import java.util.*;
import java.util.stream.Collectors;

public class Cars {

    private List<Car> carlist;

    public Cars(List<Car> carList) {
        this.carlist = carList;
    }

    public Map<String, Integer> getCarState(List<Car> carlist) {
        Map<String, Integer> carState = new HashMap<>();
        for (Car car : carlist) {
            carState.put(car.getName(), car.getPosition());
        }
        return carState;
    }

    public void generateCarList(String inputName) {
        String[] splitName = inputName.split(",");
        for (String name : splitName) {
            validateNameLength(name);
            Car car = new Car(name);
            carlist.add(car);
        }
    }

    private void validateNameLength(String name) {
        if (name.length() > 5) {
            throw new IllegalArgumentException("잘못된 입력입니다.");
        }
    }

    public void carsMove() {
        for (Car car : carlist) {
            car.carMovePosition();
        }
    }

    public List<String> carRank(List<Car> carlist) {
        return carlist.stream()
                .max(Comparator.comparingInt(Car::getPosition))
                .stream()
                .map(Car::getName)
                .collect(Collectors.toList());
    }
}
