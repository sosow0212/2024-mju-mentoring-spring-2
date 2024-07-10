package com.example.racingspring.domain;

import org.springframework.stereotype.Component;

@Component
public class RandomNumberGenerate implements NumberGenerator {
    @Override
    public int generateRandom() {
        return (int) (Math.random() * 10);
    }
}
