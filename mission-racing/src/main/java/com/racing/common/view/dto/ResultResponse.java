package com.racing.common.view.dto;

import java.util.List;

public class ResultResponse {

    private final List<Integer> carStates;
    private final List<String> winners;

    public ResultResponse(final List<Integer> carStates, final List<String> winners) {
        this.carStates = carStates;
        this.winners = winners;
    }

    public List<Integer> getCarStates() {
        return carStates;
    }

    public List<String> getWinners() {
        return winners;
    }
}
