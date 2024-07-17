package com.racing.web.service.exception;

public class NotFoundCar extends IllegalArgumentException{
    public NotFoundCar() {
        super("입력하신 자동차를 찾을 수없다. ");
    }

}
