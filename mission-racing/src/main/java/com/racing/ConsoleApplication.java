package com.racing;


import com.racing.controller.RacingController;
import com.racing.domain.RandomNumberGenerate;
import com.racing.view.Inputview;
import com.racing.view.Outputview;

public class ConsoleApplication {

    public static void main(String[] args) {
        Inputview inputview = new Inputview();
        Outputview outputview = new Outputview();
        RandomNumberGenerate numberGenerator = new RandomNumberGenerate();
        RacingController racingController = new RacingController(
                inputview,
                outputview,
                numberGenerator);
        racingController.run();
    }
}
