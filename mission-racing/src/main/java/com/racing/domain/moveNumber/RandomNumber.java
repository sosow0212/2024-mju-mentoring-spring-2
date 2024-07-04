package com.racing.domain.moveNumber;

public class RandomNumber implements RandomGenerator {
    @Override
    public int generateRandom() {
        return (int) (Math.random() * 10);
    }
}
