package com.racing.console.domain;

import java.util.Random;

public class CarRandomNumber implements CreateRandomNumber {

    private static final Random randomNumberGenerator = new Random();
    private static final int LAST_NUMBER = 10;

    @Override
    public int generateRandomNumber() {
        return randomNumberGenerator.nextInt(LAST_NUMBER);
    }
}
