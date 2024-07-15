package com.racing.common.domain.vo;

public class Name {

    private static final int CAR_NAME_BOUNDARY = 5;
    private static final String EXCEPTION_CAR_NAME_RANGE = "차 이름 너무 긺";

    private final String name;

    public Name(String name) {
        this.name = name;
    }

    public static Name from(final String name) {
        validateNameRange(name);
        return new Name(name);
    }

    public String getName() {
        return name;
    }

    private static void validateNameRange(String name) {
        if (name.length() > CAR_NAME_BOUNDARY) {
            throw new RuntimeException(EXCEPTION_CAR_NAME_RANGE);
        }
    }
}
