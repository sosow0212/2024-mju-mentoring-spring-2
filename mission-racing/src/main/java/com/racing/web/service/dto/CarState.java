package com.racing.web.service.dto;

public class CarState {

    private final String name;

    private final int moveCount;

    public CarState(String name, int moveCount) {
        this.name = name;
        this.moveCount = moveCount;
    }

    public String getName() {
        return name;
    }

    public int getMoveCount() {
        return moveCount;
    }

}
