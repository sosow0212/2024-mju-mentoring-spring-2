package com.racing.web.service.exception;

public class CarNullException extends IllegalStateException{
    public CarNullException(){
        super("자동차가 Null 값입니다.");
    }
}
