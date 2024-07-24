package com.racing.common.domain.vo;


import com.racing.common.domain.exception.CustomErrorCode;
import com.racing.common.domain.exception.CustomException;

public class Name {

    private static final int CAR_NAME_BOUNDARY = 5;

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
            throw new CustomException(CustomErrorCode.EXCEPTION_RANGE);
        }
    }
}
