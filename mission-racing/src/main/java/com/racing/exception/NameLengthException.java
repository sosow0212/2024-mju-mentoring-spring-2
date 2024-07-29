package com.racing.exception;

public class NameLengthException extends RuntimeException {

    public NameLengthException() {
        super("이름은 5자 이내로 입력 가능합니다.");
    }
}
