package com.racing.common.domain.FakeRandomNumber;

import com.racing.web.random.CreateRandomNumber;

public class FakeRandomNumber implements CreateRandomNumber {
    @Override
    public int generateRandomNumber() {
        return 4;
    }
}
