package com.racing.domain;

import java.util.ArrayList;
import java.util.List;

public class RacingWinner {

    public List<Cars> determineWinners(List<Cars> cars) {
        List<Cars> winners = new ArrayList<>();
        int maxCount = 0;

        for (Cars car : cars) {
            int carMoveCount =
            if (carMoveCount == maxCount) {
                maxCount = carMoveCount;
                winners.add(car);
            }
        }

        return winners;
    }
}
