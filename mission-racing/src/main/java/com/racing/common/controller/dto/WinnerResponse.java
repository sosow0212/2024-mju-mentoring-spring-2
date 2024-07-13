package com.racing.common.controller.dto;

import java.util.List;

public class WinnerResponse {

    private final List<String> carStates;
    private final List<String> winners;

    public WinnerResponse(
            final List<String> carStates,
            final List<String> winners
    ) {
        this.carStates = carStates;
        this.winners = winners;
    }

    public List<String> getCarStates() {
        return carStates;
    }

    public List<String> getWinners() {
        return winners;
    }
}
