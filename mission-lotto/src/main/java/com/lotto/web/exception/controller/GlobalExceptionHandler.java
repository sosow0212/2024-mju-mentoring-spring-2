package com.lotto.web.exception.controller;

import com.lotto.web.exception.domain.CustomErrorCode;
import com.lotto.web.exception.domain.CustomException;
import com.lotto.web.exception.dto.ErrorResponse;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(CustomException.class)
    public ResponseEntity<ErrorResponse> handleException(CustomException e){
        CustomErrorCode customErrorCode = e.getCustomErrorCode();
        ErrorResponse errorResponse = new ErrorResponse(customErrorCode.getMessage());
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(errorResponse);
    }
}
