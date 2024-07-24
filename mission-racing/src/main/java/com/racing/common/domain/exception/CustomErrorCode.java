package com.racing.common.domain.exception;

public enum CustomErrorCode {

    EXCEPTION_RANGE("차 이름 너무 긺"),
    EXCEPTION_CAR("차 없음");

    private final String message;

    CustomErrorCode(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }
}
