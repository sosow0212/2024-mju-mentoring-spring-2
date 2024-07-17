package com.racing.web.service.dto;

public class StartRaceRequest {

    private final String carNames;
    private final int tryCount;

    public StartRaceRequest(final String carNames, final int tryCount) {
        this.carNames = carNames;
        this.tryCount = tryCount;
    }

    public String getCarNames() {
        return carNames;
    }

    public int getTryCount() {
        return tryCount;
    }

}
