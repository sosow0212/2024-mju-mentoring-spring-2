package com.racing.exception;

public class NullInputException extends RuntimeException {

    public NullInputException() {
        super("자동차 이름을 꼭 입력하세요");
    }
}
