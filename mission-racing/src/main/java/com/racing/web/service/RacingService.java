package com.racing.web.service;

import com.racing.common.domain.*;
import com.racing.common.domain.exception.CustomErrorCode;
import com.racing.common.domain.exception.CustomException;
import com.racing.common.domain.vo.Name;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class RacingService {

    public Cars createCars(List<Name> carNames) {
        for (Name name : carNames) {
            CAR_NAME_LENGTH_CHECK(name.getName());
        }
        return new Cars(carNames);
    }

    public void startRace(Cars cars, CreateRandomNumber createRandomNumber, int tryCount) {
        for (int i = 0; i < tryCount; i++) {
            moveCars(cars, createRandomNumber);
        }
    }

    public Map<String, Object> getResult(List<Map<String, Integer>> status, List<String> winner) {
        Map<String, Object> raceResult = new HashMap<>();
        raceResult.put("winner", String.join(",", winner));
        raceResult.put("status", status);
        return raceResult;
    }

    public Map<String, Integer> getResultByName(List<Map<String, Integer>> carStates, String name) {
        return carStates.stream()
                .filter(carState -> carState.containsKey(name))
                .findFirst()
                .orElse(null);
    }

    private void CAR_NAME_LENGTH_CHECK(String carName) {
        if (carName.length() > 5) {
            throw new CustomException(CustomErrorCode.EXCEPTION_RANGE);
        }
    }

    private void moveCars(Cars cars, CreateRandomNumber createRandomNumber) {
        for (Car car : cars.getCars()) {
            car.moveCar(createRandomNumber);
        }
    }
}
