package com.example.racingspring.domain;

import org.springframework.stereotype.Component;

@Component
public interface NumberGenerator {
    int generateRandom();
}
