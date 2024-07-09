package com.example.racingspring.domain;

public class FakeNumberGenerator implements NumberGenerator {
    @Override
    public int generateRandom() {
        return 5;
    }
}
