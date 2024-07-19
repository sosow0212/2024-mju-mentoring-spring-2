package com.lotto.domain.vo.lottoNumber;

import java.util.Random;

public class RandomNumberGenerator implements NumberGenerator {

    private final Random random = new Random();

    @Override
    public int randomNumber() {
        return random.nextInt(45) + 1;
    }
}
