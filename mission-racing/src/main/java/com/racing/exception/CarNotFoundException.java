package com.racing.exception;

public class CarNotFoundException extends RuntimeException {

    public CarNotFoundException(){
        super("차가 존재하지 않습니다.");
    }
}
