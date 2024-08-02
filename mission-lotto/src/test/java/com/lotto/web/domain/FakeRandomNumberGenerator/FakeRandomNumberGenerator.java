package com.lotto.web.domain.FakeRandomNumberGenerator;

import com.lotto.web.domain.CreateRandomNumber;

public class FakeRandomNumberGenerator implements CreateRandomNumber {
    @Override
    public int generateRandomNumber() {
        return 4;
    }
}
