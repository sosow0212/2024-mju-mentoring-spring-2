package com.racing.view;

import com.racing.view.dto.ResultResponse;

public class Outputview {

    private ResultResponse resultResponse;

    public void printRacingStep(ResultResponse resultResponse) {
        resultResponse.printResultDto();
    }

    public void printRacingWinner(ResultResponse resultResponse) {
        resultResponse.printFinalWinner();
        System.out.println();
    }
}

