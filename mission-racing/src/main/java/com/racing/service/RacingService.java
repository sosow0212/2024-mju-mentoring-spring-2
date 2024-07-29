package com.racing.service;

import com.racing.exception.CarNotFoundException;
import com.racing.model.Car;
import com.racing.model.Cars;
import com.racing.model.RandomNumber;
import com.racing.repository.CarRepository;
import com.racing.service.dto.CarRegisterRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class RacingService {

    private final CarRepository carRepository;
    private final RandomNumber randomNumber;

    @Autowired
    public RacingService(CarRepository carRepository, RandomNumber randomNumber) {
        this.carRepository = carRepository;
        this.randomNumber = randomNumber;
    }

    public void registerCars(CarRegisterRequest request) {
        Cars cars = Cars.from(String.join(",", request.name()), randomNumber);
        carRepository.save(cars, request.tryCount());
    }

    public void race() {
        for (int count = 0; count < carRepository.getTryCount(); count++) {
            moveCars();
        }
    }

    private void moveCars() {
        for (Car car : carRepository.getAllCars()) {
            car.moveCar(randomNumber);
        }
    }

    public Cars getCarResult() {
        return new Cars(carRepository.getAllCars(), randomNumber);
    }

    public Car findCarByName(String name) {
        return carRepository.findByName(name)
                .orElseThrow(CarNotFoundException::new);
    }
}
