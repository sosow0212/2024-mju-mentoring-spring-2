package com.racing.console.view;

import java.util.List;

public class OutputView {

    public void inputCarNamesGuide() {
        System.out.println("경주할 자동차 이름을 입력하세요(이름은 쉼표(,)를 기준으로 구분).");
    }

    public void getChanceGuide() {
        System.out.println("시도할 회수는 몇회인가요?");
    }

    public void runGuide() {
        separateLine();
        System.out.println("실행결과");
    }

    public void showCar(String carName, int moveCount) {
        System.out.println(carName + " : " + "-".repeat(moveCount));
    }

    public void separateLine() {
        System.out.println();
    }

    public void showWinner(List<String> carWinners) {
        System.out.println(String.join(",", carWinners) + "가 최종 우승했습니다.");
    }
}
