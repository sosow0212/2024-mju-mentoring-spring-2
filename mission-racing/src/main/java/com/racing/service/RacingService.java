package com.racing.service;

import com.racing.model.Car;
import com.racing.model.Cars;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


@Service
public class RacingService {

    private Cars cars = new Cars(new ArrayList<>());
    private int tryCount;

    public void registerCars(String names, int tryCount) {
        this.tryCount = tryCount;
        cars.generateCarList(names);
    }

    public void race() {
        for (int i = 0; i < tryCount; i++) {
            cars.carsMove();
        }
    }

    public List<Car> getCars() {
        return cars.getCarList();
    }

    public Map<String, Object> getRaceResults() {
        List<String> winners = cars.carRank();
        Map<String, Integer> carState = cars.getCarState();

        Map<String, Object> raceResults = new HashMap<>();
        raceResults.put("winner", winners);
        raceResults.put("status", carState);
        return raceResults;
    }

    public Map<String, Integer> getCarStatus(String name) {
        Car car = cars.getCarByName(name);
        Map<String, Integer> carStatus = new HashMap<>();
        if (car != null) {
            carStatus.put(car.getName(), car.getPosition());
        }
        return carStatus;
    }
}
