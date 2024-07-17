package com.racing.web.service.dto;

import java.util.List;
import java.util.Map;

public class CarResponse {

    private final List<Map<String, Integer>> carStates;
    private final List<String> winners;

    public CarResponse(List<Map<String, Integer>> carStates, List<String> winners) {
        this.carStates = carStates;
        this.winners = winners;
    }

    public List<Map<String, Integer>> getCarStates() {
        return carStates;
    }

    public List<String> getWinners() {
        return winners;
    }

}
