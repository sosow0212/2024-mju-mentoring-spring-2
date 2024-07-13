package com.racing.common.domain;

public class RandomNumberGenerator implements NumberGenerator {
    @Override
    public int generateRandom() {
        return (int) (Math.random() * 10);
    }
}
