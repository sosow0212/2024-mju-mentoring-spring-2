package com.racing.common.domain.exception;

import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class CustomExceptionHandler {

    @ExceptionHandler(value = CustomException.class)
    public CustomErrorResponse handlerException(CustomException e){
        return new CustomErrorResponse(e.getCustomErrorCode().getMessage());
    }
}
