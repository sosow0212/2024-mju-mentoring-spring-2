package com.racing.domain.moveNumber;

import com.racing.domain.moveNumber.RandomGenerator;

public class RandomNumber implements RandomGenerator {
    @Override
    public int generateRandom() {
        return (int) (Math.random() * 10);
    }
}
