package com.racing.common.domain.exception;

public class CustomException extends RuntimeException{

    private final CustomErrorCode customErrorCode;

    public CustomException(CustomErrorCode customErrorCode) {
        this.customErrorCode = customErrorCode;
    }

    public CustomErrorCode getCustomErrorCode(){
        return customErrorCode;
    }
}
