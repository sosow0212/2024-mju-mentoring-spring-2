package com.example.racingspring;


import com.example.racingspring.controller.RacingController;
import com.example.racingspring.domain.RandomNumbeGenerate;
import com.example.racingspring.view.Inputview;
import com.example.racingspring.view.Outputview;

public class ConsoleApplication {

    public static void main(String[] args) {
        Inputview inputview = new Inputview();
        Outputview outputview = new Outputview();
        RandomNumbeGenerate numberGenerator = new RandomNumbeGenerate();
        RacingController racingController = new RacingController(
                inputview,
                outputview,
                numberGenerator);
        racingController.run();
    }
}
