package com.lotto.web.lotto.domain.exception;

public class CustomException extends RuntimeException{
    public CustomException(CustomErrorCode customErrorCode) {
        super(customErrorCode.getMessage());
    }
}
