package com.racing.domain.vo;

import com.racing.view.exception.NullInputException;

public class Name {

    private final String name;

    public static Name from(final String name) {
        validateIsBlank(name);
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

    public String getName() {
        return name;
    }
}
