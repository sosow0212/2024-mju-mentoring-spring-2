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

    public List<String> carRank(List<Car> carlist) {
        return carlist.stream()
                .max(Comparator.comparingInt(Car::getPosition))
                .stream()
                .map(Car::getName)
                .collect(Collectors.toList());
    }
}
