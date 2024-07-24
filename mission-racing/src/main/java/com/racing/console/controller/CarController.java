package com.racing.console.controller;

import com.racing.common.domain.*;
import com.racing.common.domain.vo.Name;
import com.racing.console.view.InputView;
import com.racing.console.view.OutputView;
import com.racing.web.random.CreateRandomNumber;

import java.util.List;

public class CarController {

    private static final int INITIAL_NUMBER = 0;

    private final InputView inputVIew;
    private final OutputView outputView;
    private final CreateRandomNumber createRandomNumber;

    public CarController(InputView inputVIew, OutputView outputView, CreateRandomNumber createRandomNumber) {
        this.inputVIew = inputVIew;
        this.outputView = outputView;
        this.createRandomNumber = createRandomNumber;
    }

    public void run() {
        Cars cars = new Cars(getCarNames());
        List<Car> carBundle = cars.getCars();
        int moveCarChance = getChance();
        outputView.runGuide();
        moveCars(carBundle, moveCarChance);
        outputView.showWinner(cars.getWinner());
    }

    private List<Name> getCarNames() {
        outputView.inputCarNamesGuide();
        CarNameParser carNameParser = new CarNameParser(inputVIew.inputCarNames());
        return carNameParser.getCarNames();
    }

    private int getChance() {
        outputView.getChanceGuide();
        return inputVIew.inputChance();
    }

    private void moveCar(List<Car> carBundle) {
        for (Car car : carBundle) {
            car.moveCar(createRandomNumber);
            outputView.showCar(car.getCarName(), car.getMoveCount());
        }
        outputView.separateLine();
    }

    private void moveCars(List<Car> carBundle, int moveCarChance) {
        for (int i = INITIAL_NUMBER; i < moveCarChance; i++) {
            moveCar(carBundle);
        }
    }
}
