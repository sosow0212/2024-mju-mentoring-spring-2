package com.racing.web.repository;

import com.racing.common.domain.Car;
import com.racing.common.domain.Cars;
import org.springframework.stereotype.Repository;

import java.util.*;

@Repository
public class CarRepository {

    private final Map<String, Car> database = new LinkedHashMap<>();
    private int tryCount;

    public void saveCars(Cars cars, int tryCount) {
        for (Car car : cars.getCars()) {
            database.put(car.getCarName(), car);
        }
        this.tryCount = tryCount;
    }

    public List<Car> findAllCars() {
        return new ArrayList<>(database.values());
    }

    public int findTryCount() {
        return tryCount;
    }

    public Optional<Car> findCarByName(String name) {
        return Optional.ofNullable(database.get(name));
    }
}
