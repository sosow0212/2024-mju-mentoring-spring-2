package com.racing.console;

import com.racing.console.controller.RacingController;
import com.racing.common.domain.RandomNumberGenerator;
import com.racing.console.view.InputView;
import com.racing.console.view.OutputView;

public class ConsoleApplication {

    public static void main(String[] args) {
        InputView inputview = new InputView();
        OutputView outputview = new OutputView();
        RandomNumberGenerator randomNumberGenerator = new RandomNumberGenerator();

        RacingController racingController = new RacingController(inputview, outputview, randomNumberGenerator);
        racingController.run();
    }
}
