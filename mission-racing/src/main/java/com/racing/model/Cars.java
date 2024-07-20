package com.racing.model;

import com.racing.exception.CarNotFoundException;
import com.racing.exception.NameLengthException;

import java.util.*;
import java.util.stream.Collectors;

public class Cars {

    private static final int NAME_MAX_LENGTH = 5;
    private List<Car> cars = new ArrayList<>();

    public Cars(String inputNames) {
        this.cars = generateCarList(inputNames);
    }

    public List<Car> generateCarList(String inputName) {
        String[] splitName = inputName.split(",");
        for (String name : splitName) {
            validateNameLength(name);
            Car car = new Car(name);
            cars.add(car);
        }
        return cars;
    }

    private void validateNameLength(String name) {
        if (name.length() > NAME_MAX_LENGTH) {
            throw new NameLengthException();
        }
    }

    public void moveCars() {
        for (Car car : cars) {
            RandomNumber randomNumber = new CarRandomNumber();
            car.moveCar(randomNumber);
        }
    }

    public List<String> rankCars() {
        return cars.stream()
                .max(Comparator.comparingInt(Car::getPosition))
                .stream()
                .map(Car::getName)
                .collect(Collectors.toList());
    }

    public Map<String, Integer> getCarState() {
        Map<String, Integer> carState = new HashMap<>();
        for (Car car : cars) {
            carState.put(car.getName(), car.getPosition());
        }
        return carState;
    }

    public Car findCarByName(String name) {
        return cars.stream()
                .filter(car -> car.getName().equals(name))
                .findFirst()
                .orElseThrow(() -> new CarNotFoundException());
    }

    public List<Car> getCarList() {
        return cars;
    }
}
