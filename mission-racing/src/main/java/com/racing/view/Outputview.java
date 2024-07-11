package com.racing.view;

import com.racing.view.dto.WinnerResponse;

public class Outputview {

    public void printRacingStep(WinnerResponse winnerResponse) {
        winnerResponse.printResultDto();
    }

    public void printRacingWinner(WinnerResponse winnerResponse) {
        winnerResponse.printFinalWinner();
        System.out.println();
    }
}

