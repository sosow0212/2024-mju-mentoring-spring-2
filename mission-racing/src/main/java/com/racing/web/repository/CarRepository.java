package com.racing.web.repository;

import com.racing.common.domain.Car;
import com.racing.common.domain.vo.Name;
import org.springframework.stereotype.Repository;

import java.util.*;

@Repository
public class CarRepository {

    private final Map<String, Car> database = new HashMap<>();
    private final List<Name> carNames = new ArrayList<>();
    private int tryCount;

    public void saveAllCars(List<Car> cars) {
        int i = 0;
        for (Name name : carNames) {
            database.put(name.getName(), cars.get(i));
            i++;
        }
    }

    public void saveAllCarNames(List<Name> carName) {
        carNames.addAll(carName);
    }

    public void saveTryCount(int tryCount) {
        this.tryCount = tryCount;
    }

    public List<Car> findAllCars() {
        List<Car> cars = new ArrayList<>();
        for (Name carName : findAllCarNames()) {
            cars.add(database.get(carName.getName()));
        }
        return cars;
    }

    public int findTryCount() {
        return tryCount;
    }

    public Optional<Car> findCarByName(String name) {
        return Optional.ofNullable(database.get(name));
    }

    private List<Name> findAllCarNames() {
        return carNames;
    }
}
