package com.racing.view;

import com.racing.view.dto.WinnerResponse;

import java.util.List;

public class Outputview {

    public void printRacingStep(WinnerResponse winnerResponse) {
        winnerResponse.printResultDto();
        System.out.println();
    }

    public void printFinalWinner(List<String> winners) {
        System.out.print("최종 우승자: ");
        for (int i = 0; i < winners.size(); i++) {
            if (i > 0) {
                System.out.print(", ");
            }
            System.out.print(winners.get(i));
        }
        System.out.println();
    }
}

