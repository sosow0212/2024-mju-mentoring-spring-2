package com.racing.controller;

import com.racing.model.Car;
import com.racing.model.Cars;
import com.racing.view.InputView;
import com.racing.view.OutputView;

import java.util.List;

public class CarController {

    InputView inputView;
    OutputView outputView;
    private List<Car> carList;

    public CarController(InputView inputView, OutputView outputView, List<Car> carList){
        this.inputView=inputView;
        this.outputView=outputView;
        this.carList=carList;
    }

    public void Run(){
        String inputNames= inputView.inputName();
        int inputCounts= inputView.inputCount();

        Cars cars=new Cars(carList);
        cars.generateCarList(inputNames);

        for (int count=0; count<inputCounts;count++){
            cars.carsMove();
            outputView.printRunResult(cars.getCarState(carList));
        }

        List<String> winners= cars.carRank(carList);
        outputView.printWinners(winners);
    }

}
