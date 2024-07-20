package com.racing.service;

import com.racing.exception.CarNotFoundException;
import com.racing.model.Car;
import com.racing.model.Cars;
import com.racing.service.dto.CarRegister;
import com.racing.service.dto.CarStatus;
import com.racing.service.dto.RaceResult;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;


@Service
public class RacingService {

    private Cars cars;
    private int tryCount;

    public void registerCars(CarRegister request) {
        this.cars = new Cars(String.join(",", request.name()));
        this.tryCount = request.tryCount();
    }

    public void race() {
        for (int i = 0; i < tryCount; i++) {
            cars.moveCars();
        }
    }

    public List<Car> getCars() {
        return cars.getCarList();
    }

    public RaceResult getRaceResults() {
        return RaceResult.resultResponse(cars);
    }

    public CarStatus getCarStatus(String name) {
        Car car = cars.findCarByName(name);
        if (car == null) {
            throw new CarNotFoundException();
        }
        return new CarStatus(car.getName(), car.getPosition());
    }
}
