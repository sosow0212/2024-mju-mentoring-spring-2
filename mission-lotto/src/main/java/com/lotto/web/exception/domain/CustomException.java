package com.lotto.web.exception.domain;

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
