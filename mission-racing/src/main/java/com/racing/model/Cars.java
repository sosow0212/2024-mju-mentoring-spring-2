package com.racing.model;

import com.racing.Exception.NameLengthException;

import java.util.*;
import java.util.stream.Collectors;

public class Cars {

    private static final int NAME_MAX_LENGTH = 5;
    private List<Car> cars;

    public Cars(List<Car> cars) {
        this.cars = cars;
    }

    public Map<String, Integer> getCarState() {
        Map<String, Integer> carState = new HashMap<>();
        for (Car car : cars) {
            carState.put(car.getName(), car.getPosition());
        }
        return carState;
    }

    public void generateCarList(String inputName) {
        String[] splitName = inputName.split(",");
        for (String name : splitName) {
            validateNameLength(name);
            Car car = new Car(name);
            cars.add(car);
        }
    }

    private void validateNameLength(String name) {
        if (name.length() > NAME_MAX_LENGTH) {
            throw new NameLengthException();
        }
    }

    public void carsMove() {
        for (Car car : cars) {
            int randomNumber = car.generateRandomNumber();
            car.carMovePosition(randomNumber);
        }
    }

    public List<String> carRank() {
        return cars.stream()
                .max(Comparator.comparingInt(Car::getPosition))
                .stream()
                .map(Car::getName)
                .collect(Collectors.toList());
    }

    public Car getCarByName(String name) {
        return cars.stream()
                .filter(car -> car.getName().equals(name))
                .findFirst()
                .orElse(null);
    }

    public List<Car> getCarList() {
        return cars;
    }
}
