package com.lotto.domain.vo;

import java.util.Random;

public class RandomNumberGenerator implements NumberGenerator {

    private Random random;

    @Override
    public int randomNumber() {
        return random.nextInt(45);
    }
}
