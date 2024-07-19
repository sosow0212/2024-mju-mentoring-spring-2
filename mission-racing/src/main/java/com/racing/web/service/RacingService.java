package com.racing.web.service;

import com.racing.common.domain.*;
import com.racing.web.dto.CarResultResponse;
import com.racing.web.random.CreateRandomNumber;
import com.racing.web.dto.CreateRequest;
import com.racing.web.repository.CarRepository;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Optional;

@Service
public class RacingService {

    private final CarRepository carRepository;

    public RacingService(CarRepository carRepository) {
        this.carRepository = carRepository;
    }

    public void createCars(CreateRequest createRequest) {
        Cars cars = new Cars(new CarNameParser(createRequest.name()).getCarNames());
        for (Car car : cars.getCars()) {
            carRepository.save(car.getCarName(), car);
        }
        carRepository.saveTryCount(createRequest.tryCount());
    }

    public void startRace(CreateRandomNumber createRandomNumber) {
        for (int i = 0; i < carRepository.getTryCount(); i++) {
            moveCars(createRandomNumber);
        }
    }

    public CarResultResponse getResult() {
        List<Car> cars = carRepository.getAllCars();
        List<String> winner = Cars.getWinner(cars);
        return new CarResultResponse(String.join(",", winner), getCarStatus(cars));
    }

    public Optional<Map<String, Integer>> findResultByName(String name) {
        List<Car> cars = carRepository.getAllCars();
        return getCarStatus(cars).stream()
                .filter(carState -> isName(carState, name))
                .findFirst();
    }

    private boolean isName(Map<String, Integer> carState, String name) {
        return carState.containsKey(name);
    }

    private List<Map<String, Integer>> getCarStatus(List<Car> cars) {
        List<Map<String, Integer>> carStatuses = new ArrayList<>();
        for (Car car : cars) {
            carStatuses.add(Map.of(car.getCarName(), car.getMoveCount()));
        }
        return carStatuses;
    }

    private void moveCars(CreateRandomNumber createRandomNumber) {
        for (Car car : carRepository.getAllCars()) {
            car.moveCar(createRandomNumber);
        }
    }
}
