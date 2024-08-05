package com.lotto.web.lotto.domain.exception;

public enum CustomErrorCode {

    EXCEPTION_RANGE("로또 범위 아님."),
    EXCEPTION_USER("유저 없음."),
    EXCEPTION_MONEY("돈 없음."),
    EXCEPTION_LOTTO("로또 없음.");

    private final String message;

    CustomErrorCode(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }
}
