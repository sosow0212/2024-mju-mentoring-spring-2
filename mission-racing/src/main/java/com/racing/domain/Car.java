package com.racing.domain;

import com.racing.vo.Name;
import com.racing.vo.MoveCount;

public class Car {

    private final Name name;
    private final MoveCount moveCount;

    public Car(final String name) {
        this.name = Name.from(name);
        this.moveCount = new MoveCount();
    }

    public boolean isSameCount(final int count) {
        return this.moveCount.isSame(count);
    }

    public void move(final int randomNumber) {
        this.moveCount.move(randomNumber);
    }

    public int getMoveCount() {제
        return moveCount.getMoveCount();
    }

    public String getName() {
        return name.getName();
    }
}
