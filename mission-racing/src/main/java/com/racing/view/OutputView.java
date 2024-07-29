package com.racing.view;

import java.util.List;
import java.util.Map;

public class OutputView {

    public void printRunResult(Map<String, Integer> carState) {
        System.out.println("실행 결과");
        carState.entrySet().stream()
                .forEach(stringIntegerEntry ->
                        System.out.println(stringIntegerEntry.getKey() + ":" + "-".repeat(stringIntegerEntry.getValue())));
    }

    public void printWinners(List<String> winnerList) {
        for (String winner : winnerList) {
            System.out.print(winner + " ");
        }
        System.out.println("가 최종 우승했습니다.");
    }
}
