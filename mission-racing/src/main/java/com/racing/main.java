package com.racing;

import com.racing.controller.CarController;

import com.racing.model.CarRandomNumber;
import com.racing.model.RandomNumber;
import com.racing.view.InputView;
import com.racing.view.OutputView;

import java.util.Scanner;

public class main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        InputView inputView = new InputView(scanner);
        OutputView outputView = new OutputView();
        RandomNumber randomNumber= new CarRandomNumber();

        CarController carController = new CarController(inputView, outputView,randomNumber);
        carController.run();
    }
}
