package com.racing.console;

import com.racing.console.controller.CarController;
import com.racing.console.view.InputVIew;
import com.racing.console.view.OutputView;
import com.racing.web.random.CarRandomNumber;
import com.racing.web.random.CreateRandomNumber;

public class ConsoleApplication {

    public static void main(String[] args) {
        OutputView outputView = new OutputView();
        InputVIew inputVIew = new InputVIew();
        CreateRandomNumber createRandomNumber = new CarRandomNumber();
        CarController carController = new CarController(inputVIew, outputView, createRandomNumber);
        carController.run();
    }
}
