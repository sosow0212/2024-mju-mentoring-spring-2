package com.racing;

import com.racing.controller.CarController;
import com.racing.model.Car;

import com.racing.view.InputView;
import com.racing.view.OutputView;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class main {
    public static void main(String[] args) {
        Scanner scanner= new Scanner(System.in);
        InputView inputView = new InputView(scanner);
        OutputView outputView = new OutputView();

        CarController carController = new CarController(inputView, outputView);
        carController.Run();
    }
}
