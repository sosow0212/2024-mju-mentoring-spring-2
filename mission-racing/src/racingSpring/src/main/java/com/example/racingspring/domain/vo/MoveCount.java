package com.example.racingspring.domain.vo;

import org.springframework.stereotype.Component;

public class MoveCount {

    public static final int NUMBER_TO_MOVE = 4;
    private static final int DEFAULT_MOVE_COUNT = 0;

    private int moveCount;

    public MoveCount() {
        this.moveCount = DEFAULT_MOVE_COUNT;
    }

    public void move(int randomNumber) {
        if (randomNumber >= NUMBER_TO_MOVE) {
            this.moveCount++;
        }
    }

    public int getMoveCount(){
        return moveCount;
    }

    public boolean isSame(final int count) {
        return this.moveCount==count;
    }
}
