package com.racing.web.service;

import com.racing.common.domain.*;
import com.racing.common.domain.vo.Name;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class RacingService {

    public Cars createCars(List<Name> carNames) {
        return new Cars(carNames);
    }

    public void startRace(Cars cars, CreateRandomNumber createRandomNumber, int tryCount) {
        for (int i = 0; i < tryCount; i++) {
            moveCars(cars, createRandomNumber);
        }
    }

    private void moveCars(Cars cars, CreateRandomNumber createRandomNumber) {
        for (Car car : cars.getCars()) {
            car.moveCar(createRandomNumber);
        }
    }

    public Map<String, Object> getResult(List<Object> status, List<String> winner) {
        Map<String, Object> raceResult = new HashMap<>();
        raceResult.put("winner", String.join(",", winner));
        raceResult.put("status", status);
        return raceResult;
    }

    public Object getResultByName(List<Object> status, String name) {
        return status.stream()
                .filter(carInformation -> carInformation instanceof Map)
                .map(carInformation -> (Map<String, Integer>) carInformation)
                .filter(map -> map.containsKey(name))
                .findFirst();
    }
}
