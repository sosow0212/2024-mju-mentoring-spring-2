package com.racing.console.view;

import com.racing.console.view.dto.ResultResponse;

public class OutputView {

    private ResultResponse resultResponse;

    public void printRacingStep(ResultResponse resultResponse) {
        resultResponse.printResultDto();
    }

    public void printRacingWinner(ResultResponse resultResponse) {
        resultResponse.printFinalWinner();
        System.out.println();
    }
}

