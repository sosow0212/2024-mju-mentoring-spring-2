package com.racing.common.domain.exception;

public class CustomException extends RuntimeException{

    public CustomException(CustomErrorCode customErrorCode) {
        super(customErrorCode.getMessage());
    }
}
