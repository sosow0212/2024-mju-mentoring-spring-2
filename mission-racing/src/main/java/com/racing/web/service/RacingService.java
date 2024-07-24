package com.racing.web.service;

import com.racing.common.domain.*;
import com.racing.common.domain.exception.CustomErrorCode;
import com.racing.common.domain.exception.CustomException;
import com.racing.web.dto.*;
import com.racing.web.random.CreateRandomNumber;
import com.racing.web.repository.CarRepository;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class RacingService {

    private final CarRepository carRepository;
    private final CreateRandomNumber createRandomNumber;

    public RacingService(CarRepository carRepository, CreateRandomNumber createRandomNumber) {
        this.carRepository = carRepository;
        this.createRandomNumber = createRandomNumber;
    }

    public void createCars(CreateRequest createRequest) {
        CarNameParser carNameParser = new CarNameParser(createRequest.name());
        Cars cars = new Cars(carNameParser.getCarNames());
        carRepository.saveAllCarNames(carNameParser.getCarNames());
        carRepository.saveAllCars(cars.getCars());
        carRepository.saveTryCount(createRequest.tryCount());
    }

    public void startRace() {
        for (int i = 0; i < carRepository.findTryCount(); i++) {
            moveCars();
        }
    }

    public CarResultResponse getResult() {
        List<Car> carBundle = carRepository.findAllCars();
        Cars cars = new Cars(carBundle, true);
        List<String> winner = cars.getWinner();
        return CarResultResponse.from(String.join(",", winner), getCarStatuses(carBundle));
    }

    public CarStatusResponse getResultByName(String name) {
        Car car = carRepository.findCarByName(name)
                .orElseThrow(() -> new CustomException(CustomErrorCode.EXCEPTION_CAR));
        return CarStatusResponse.from(CarNameResponse.form(car.getCarName()), MoveCountResponse.from(car.getMoveCount()));
    }

    private List<CarStatusResponse> getCarStatuses(List<Car> cars) {
        List<CarStatusResponse> carStatuses = new ArrayList<>();
        for (Car car : cars) {
            carStatuses.add(CarStatusResponse.from(CarNameResponse.form(car.getCarName()), MoveCountResponse.from(car.getMoveCount())));
        }
        return carStatuses;
    }

    private void moveCars() {
        for (Car car : carRepository.findAllCars()) {
            car.moveCar(createRandomNumber);
        }
    }
}
