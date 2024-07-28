package com.racing.model;

import com.racing.exception.CarNotFoundException;
import com.racing.exception.NameLengthException;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class Cars {

    private static final int NAME_MAX_LENGTH = 5;

    private List<Car> cars;
    private RandomNumber randomNumber;

    public Cars(List<Car> cars, RandomNumber randomNumber) {
        this.cars = cars;
        this.randomNumber = randomNumber;
    }

    public static Cars from(String inputNames, RandomNumber randomNumber) {
        List<Car> cars = generateCarList(inputNames);
        return new Cars(cars, randomNumber);
    }

    public static List<Car> generateCarList(String inputName) {
        String[] splitName = inputName.split(",");
        List<Car> cars = new ArrayList<>();
        for (String name : splitName) {
            validateNameLength(name);
            Car car = new Car(name);
            cars.add(car);
        }
        return cars;
    }

    private static void validateNameLength(String name) {
        if (name.length() > NAME_MAX_LENGTH) {
            throw new NameLengthException();
        }
    }

    public void moveCars() {
        for (Car car : cars) {
            car.moveCar(randomNumber);
        }
    }

    public List<String> getRanks() {
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
                .filter(car -> checkCarName(name, car))
                .findFirst()
                .orElseThrow(() -> new CarNotFoundException());
    }

    private boolean checkCarName(String name, Car car) {
        return car.getName().equals(name);
    }

    public List<Car> getCarList() {
        return cars;
    }
}
