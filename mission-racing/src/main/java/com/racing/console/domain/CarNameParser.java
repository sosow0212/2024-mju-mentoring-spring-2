package com.racing.console.domain;

import java.util.List;

public class CarNameParser {

    private static final int CAR_NAME_BOUNDARY = 5;
    private static final String EXCEPTION_CAR_NAME_RANGE = "차 이름 너무 긺";
    private static final String SPLIT_STRING_DELIMITER = ",";

    public final List<String> carNames;

    public CarNameParser(String carNames) {
        this.carNames = parseCarName(carNames);
    }

    public List<String> getCarNames() {
        return carNames;
    }

    private List<String> parseCarName(String carNames) {
        String[] parsedCarNames = carNames.split(SPLIT_STRING_DELIMITER);
        for (String carName : parsedCarNames) {
            validateCarNameRange(carName);
        }
        return List.of(parsedCarNames);
    }

    private void validateCarNameRange(String carName) {
        if (carName.length() > CAR_NAME_BOUNDARY) {
            throw new RuntimeException(EXCEPTION_CAR_NAME_RANGE);
        }
    }
}
