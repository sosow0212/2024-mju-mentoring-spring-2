package com.racing;

import com.racing.controller.RacingController;
import com.racing.domain.RandomNumbeGenerate;
import com.racing.domain.view.Outputview;

public class ConsoleApplication {

    public static void main(String[] args) {
        RacingController racingController = new RacingController(
                new RandomNumbeGenerate(),
                new Outputview()
        );

        racingController.run();
    }
}
