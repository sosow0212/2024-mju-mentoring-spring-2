package com.racing.console.view.dto;

import lombok.Getter;

import java.util.List;

public class ResultResponse {

    @Getter
    private final List<String> carStates;

    @Getter
    private final List<String> winners;

    public ResultResponse(final List<String> carStates, final List<String> winners) {
        this.carStates = carStates;
        this.winners = winners;
    }

    public void printResultDto() {
        for (String carState : carStates) {
            System.out.println(carState);
        }
    }

    public void printFinalWinner() {
        System.out.print("최종 우승자: ");
        printWinner();
        System.out.println();
    }

    private void printWinner() {
        for (int i = 0; i < winners.size(); i++) {
            if (i > 0) {
                System.out.print(", ");
            }
            System.out.print(winners.get(i));
        }
    }
}
