package com.lotto.service.infrastructure.vo;


import org.springframework.stereotype.Component;

import java.util.Random;

@Component
public class RandomNumberGenerator implements NumberGenerator {

    private final Random random = new Random();

    @Override
    public int randomNumber() {
        return random.nextInt(45) + 1;
    }

}