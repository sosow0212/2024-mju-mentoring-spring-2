package com.racing.domain;

import com.racing.domain.vo.MoveCount;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Car {

    private static final String COMMA = ",";
    public static final int DEFAULT_MOVE_COUNT = 0;
    public static final int BOUNDARY_SIZE_OF_MOVE = 4;

    private final String carNames;
    private MoveCount moveCount;

    public Car(final String carNames, final MoveCount moveCount) {
        this.carNames = carNames;
        this.moveCount = new MoveCount();
    }


    public void move(final int randomNumber) {
        this.moveCount.move();
    }

    private List<Cars> createCar(String carNames) {
        String[] split = carNames.split(COMMA);
        List<String> carsList = new ArrayList<>(Arrays.asList(split));
        return createCar(carNames);
    }


    public String getCarNames() {
        return carNames;
    }

    public int getMoveCount() {
        return moveCount;
    }

    public boolean isSameMoveCount(final int maxMoveCount) {
        return this.moveCount == maxMoveCount;
    }
}
