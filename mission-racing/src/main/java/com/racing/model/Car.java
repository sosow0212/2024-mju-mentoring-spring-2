package com.racing.model;

import java.util.Random;

public class Car {

    private final String name;
    private int position;
    private static final int BOUND_NUMBER = 9;

    public Car(String name) {
        this.name = name;
    }

    public int getRandomNumber() {
        Random random = new Random();
        return random.nextInt(BOUND_NUMBER);
    }

    public boolean checkRandomNumber() {
        return (getRandomNumber() >= 4);
    }

    public void carMovePosition() {
        if (checkRandomNumber()) {
            position++;
        }
    }

    public int getPosition() {
        return position;
    }

    public String getName() {
        return name;
    }
}
