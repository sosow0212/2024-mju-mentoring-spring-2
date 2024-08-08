package com.lotto.web.global.exception.exceptions;

public class CustomException extends RuntimeException{

    private final CustomErrorCode customErrorCode;

    public CustomException(CustomErrorCode customErrorCode) {
        super(customErrorCode.getMessage());
        this.customErrorCode = customErrorCode;
    }

    public CustomErrorCode getCustomErrorCode(){
        return customErrorCode;
    }
}
