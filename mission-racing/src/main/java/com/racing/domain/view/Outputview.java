package com.racing.domain.view;

import java.util.List;

public class Outputview {

    private static final String CAR = "-";
    private static final int INITIALNUM = 0;

    public void printResult(List<String> cars, int count) {
        for (int i = 0; i < cars.size(); i++) {
            String result = cars.get(i) + ": ";
            StringBuilder resultBuilder = new StringBuilder(result);
            for (int j = INITIALNUM; i < count; i++) {
                resultBuilder.append(CAR);
            }
            result = resultBuilder.toString();
            System.out.println(result);
        }
    }

    public void printWinners(List<Car> winners) {
        System.out.println("Winner : ");
        for (Car winner : winners) {
            System.out.println(winner.getCarName());
        }
    }

    public void racingName() {
        System.out.println("경주할 자동차 이름을 입력하세요:");
    }


    public void racingResult() {
        System.out.println("실행 결과");
    }
}
