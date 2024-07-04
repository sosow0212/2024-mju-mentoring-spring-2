package com.racing.domain.carName;

public class carNames implements carNamesException {

    @Override
    public String carNames(final String carName) {
        if (carName.length() > 5) throw new ArithmeticException("자동차 이름은 5자 이하로 해주세요");
        return null;
    }
}
