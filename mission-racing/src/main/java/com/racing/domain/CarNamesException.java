package com.racing.domain;

public class CarNamesException extends RuntimeException {

    public CarNamesException() {
        super("자동차 이름은 5글자 이하로 해주세요");
    }
}

