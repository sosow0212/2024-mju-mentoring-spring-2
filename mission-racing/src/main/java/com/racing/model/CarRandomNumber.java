package com.racing.model;

import org.springframework.stereotype.Component;

import java.util.Random;

@Component
public class CarRandomNumber implements RandomNumber {

    private static final Random random = new Random();
    private static final int BOUND_NUMBER = 9;

    @Override
    public int getRandomNumber() {
        return random.nextInt(BOUND_NUMBER);
    }
}
