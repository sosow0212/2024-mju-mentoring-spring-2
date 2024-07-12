package com.racing.domain;

import org.springframework.stereotype.Component;

@Component
public class RandomNumberGenerator implements NumberGenerator {
    @Override
    public int generateRandom() {
        return (int) (Math.random() * 10);
    }
}
