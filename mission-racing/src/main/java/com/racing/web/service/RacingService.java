package com.racing.web.service;

import com.racing.common.domain.Car;
import com.racing.common.domain.Cars;
import com.racing.common.domain.NumberGenerator;
import com.racing.web.service.dto.CarResponse;
import com.racing.web.service.dto.CarState;
import com.racing.web.service.dto.StartRaceRequest;
import com.racing.web.service.exception.NotFoundCar;
import com.racing.web.service.exception.CarNullException;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@Service
public class RacingService {

    private final NumberGenerator numberGenerator;
    private Cars cars;

    public RacingService(NumberGenerator numberGenerator) {
        this.numberGenerator = numberGenerator;
    }

    public void registerCars(StartRaceRequest request) {
        this.cars = Cars.from(request.getCarNames());
    }

    public CarResponse startRace(StartRaceRequest request) {
        validateCarState();
        cars.moveCars(request.getTryCount(), numberGenerator);
        return createCarResponse();
    }

    public CarResponse getRaceResult() {
        validateCarState();
        return createCarResponse();
    }

    public CarState getRaceResultByName(String name) {
        validateCarState();
        Car car = cars.getCars().stream()
                .filter(c -> c.getName().equals(name))
                .findFirst()
                .orElseThrow(NotFoundCar::new);

        return new CarState(car.getName(), car.getMoveCount());
    }

    private CarResponse createCarResponse() {
        List<String> winners = cars.findsWinner();
        List<Map<String, Integer>> carStates = cars.getCars().stream()
                .map(car -> Map.of(car.getName(), car.getMoveCount()))
                .collect(Collectors.toList());
        return new CarResponse(carStates, winners);
    }

    private void validateCarState() {
        if (this.cars == null) {
            throw new CarNullException();
        }
    }

}
