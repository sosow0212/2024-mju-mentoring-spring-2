package com.example.racingspring.domain.dto;

import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

public class WinnerResponse {

    private final List<String> carStates;
    private final List<String> winners;

    public WinnerResponse(final List<String> carStates, final List<String> winners) {
        this.carStates = carStates;
        this.winners = winners;
    }
    @GetMapping("api/cars/result")
    public void printResultDto() {
        for (String carState : carStates) {
            System.out.println(carState);
        }
    }

    public List<String> getWinners() {
        return winners;
    }
}
