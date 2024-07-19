package com.racing.common.domain;

import com.racing.common.domain.vo.Name;
import com.racing.web.random.CreateRandomNumber;

import java.util.Map;

public class Car {

    private static final int CAR_MOVE_BOUNDARY = 4;

    public int moveCount;
    private final Name carName;

    public Car(int moveCount, String carName) {
        this.moveCount = moveCount;
        this.carName = Name.from(carName);
    }

    public void moveCar(CreateRandomNumber createRandomNumber) {
        if (createRandomNumber.generateRandomNumber() >= CAR_MOVE_BOUNDARY) {
            moveCount++;
        }
    }

    public Map<String, Integer> getStatus() {
        return Map.of(carName.getName(), moveCount);
    }

    public int getMoveCount() {
        return moveCount;
    }

    public String getCarName() {
        return carName.getName();
    }
}
