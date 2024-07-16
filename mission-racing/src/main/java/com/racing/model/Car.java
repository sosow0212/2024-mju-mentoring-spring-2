package com.racing.model;


public class Car {

    private static final int LEAST_NUMBER = 4;
    private final String name;
    private int position = 0;

    public Car(String name) {
        this.name = name;
    }

    public boolean checkRandomNumber(int randomNumber) {
        return (randomNumber >= LEAST_NUMBER);
    }

    public int generateRandomNumber() {
        CarRandomNumber carRandomNumber = new CarRandomNumber();
        return carRandomNumber.getRandomNumber();
    }

    public void carMovePosition(int randomNumber) {
        if (checkRandomNumber(randomNumber)) {
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
