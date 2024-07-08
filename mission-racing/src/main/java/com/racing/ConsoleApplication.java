package com.racing;

import com.racing.controller.RacingController;
import com.racing.domain.RandomNumbeGenerate;
import com.racing.view.Inputview;
import com.racing.view.Outputview;

public class ConsoleApplication {

    public static void main(String[] args) {
        Inputview inputview = new Inputview();
        Outputview outputview = new Outputview();
        RandomNumbeGenerate numberGenerator = new RandomNumbeGenerate();

        RacingController racingController = new RacingController(inputview, outputview, numberGenerator);
        racingController.run();
    }
}
