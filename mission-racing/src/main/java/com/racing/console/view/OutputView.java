package com.racing.console.view;

import com.racing.console.dto.ResultResponse;

import java.util.List;

public class OutputView {

    public void printRacingStep(ResultResponse resultResponse, List<String> carNames) {
        List<Integer> carStates = resultResponse.getCarStates();

        for (int i = 0; i < carNames.size(); i++) {
            String name = carNames.get(i);
            int state = carStates.get(i);
            System.out.println(name + ": " + convertToDashes(state));
        }
        System.out.println();
    }

    public void printRacingWinner(ResultResponse winnerResponse) {
        List<String> winners = winnerResponse.getWinners();
        printFinalWinner(winners);
        System.out.println();
    }

    private void printFinalWinner(List<String> winners) {
        System.out.print("최종 우승자: ");
        for (int i = 0; i < winners.size(); i++) {
            if (i > 0) {
                System.out.print(", ");
            }
            System.out.print(winners.get(i));
        }
        System.out.println();
    }

    private String convertToDashes(int count) {
        return "-".repeat(Math.max(0, count));
    }
}
