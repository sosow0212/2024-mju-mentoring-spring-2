package com.racing.web.repository;

import com.racing.common.domain.Car;
import org.springframework.stereotype.Repository;

import java.util.*;

@Repository
public class CarRepository {

    private final Map<String, Car> database = new HashMap<>();
    private int tryCount;

    public void save(String carName, Car car) {
        database.put(carName, car);
    }

    public void saveTryCount(int tryCount) {
        this.tryCount = tryCount;
    }

    public List<Car> getAllCars() {
        List<Car> cars = new ArrayList<>(database.values());
        reverseOrder(cars);
        return cars;
    }

    public int getTryCount() {
        return tryCount;
    }

    private void reverseOrder(List<Car> cars) {
        Collections.reverse(cars);
    }
}
