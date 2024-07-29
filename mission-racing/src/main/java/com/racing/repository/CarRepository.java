package com.racing.repository;

import com.racing.model.Car;
import com.racing.model.Cars;
import org.springframework.stereotype.Repository;

import java.util.*;

@Repository
public class CarRepository {

    private Map<String, Car> carData = new HashMap<>();
    private int tryCount;

    public void save(Cars cars, int tryCount) {
        for (Car car : cars.getCarList()) {
            carData.put(car.getName(), car);
        }
        this.tryCount = tryCount;
    }

    public Optional<Car> findByName(String carName) {
        return Optional.ofNullable(carData.get(carName));
    }

    public int getTryCount() {
        return tryCount;
    }

    public List<Car> getAllCars() {
        return new ArrayList<>(carData.values());
    }
}
