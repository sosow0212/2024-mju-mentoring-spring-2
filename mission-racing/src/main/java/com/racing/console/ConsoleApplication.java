package com.racing.console;

import com.racing.console.controller.CarController;
import com.racing.console.view.InputView;
import com.racing.console.view.OutputView;
import com.racing.web.random.CarRandomNumber;
import com.racing.web.random.CreateRandomNumber;

import java.util.Scanner;

public class ConsoleApplication {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        OutputView outputView = new OutputView();
        InputView inputVIew = new InputView(scanner);
        CreateRandomNumber createRandomNumber = new CarRandomNumber();
        CarController carController = new CarController(inputVIew, outputView, createRandomNumber);
        carController.run();
    }
}
