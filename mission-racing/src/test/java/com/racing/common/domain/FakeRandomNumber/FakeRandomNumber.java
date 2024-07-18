package com.racing.common.domain.FakeRandomNumber;

import com.racing.common.domain.CreateRandomNumber;

public class FakeRandomNumber implements CreateRandomNumber {
    @Override
    public int generateRandomNumber() {
        return 4;
    }
}
