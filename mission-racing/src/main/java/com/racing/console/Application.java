package com.racing.console;

import com.racing.console.controller.CarController;
import com.racing.console.domain.CarRandomNumber;
import com.racing.console.domain.CreateRandomNumber;
import com.racing.console.view.InputVIew;
import com.racing.console.view.OutputView;

public class Application {

    public static void main(String[] args) {
        OutputView outputView = new OutputView();
        InputVIew inputVIew = new InputVIew();
        CreateRandomNumber createRandomNumber = new CarRandomNumber();
        CarController carController = new CarController(inputVIew, outputView, createRandomNumber);
        carController.run();
    }
}
