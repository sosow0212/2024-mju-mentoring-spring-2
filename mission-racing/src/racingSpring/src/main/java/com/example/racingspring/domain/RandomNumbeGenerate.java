package com.example.racingspring.domain;

public class RandomNumbeGenerate implements NumberGenerator {
    @Override
    public int generateRandom() {
        return (int) (Math.random() * 10);
    }
}
