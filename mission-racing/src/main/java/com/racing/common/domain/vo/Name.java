package com.racing.common.domain.vo;

import com.racing.console.view.exception.NullInputException;

public class Name {

    public static final int MoveCount = 5;
    private final String name;

    public static Name from(final String name) {
        validateIsBlank(name);
        validateMove(name);
        return new Name(name);
    }

    private Name(final String carName) {
        this.name = carName;
    }

    private static void validateIsBlank(final String name) {
        if (name.isBlank()) {
            throw new NullInputException();
        }
    }

    private static void validateMove(String name) {
        if (name.length() > MoveCount) {
            throw new RuntimeException();
        }
    }

    public String getName() {
        return name;
    }
}
