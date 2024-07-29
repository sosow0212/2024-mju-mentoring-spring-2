package com.lotto.web.domain.exception;

public class CustomException extends RuntimeException{
    public CustomException(CustomErrorCode customErrorCode) {
        super(customErrorCode.getMessage());
    }
}
