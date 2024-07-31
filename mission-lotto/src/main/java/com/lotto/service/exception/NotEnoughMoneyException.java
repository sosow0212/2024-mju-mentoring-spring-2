package com.lotto.service.exception;

public class NotEnoughMoneyException extends RuntimeException{
    public NotEnoughMoneyException() {
        super("금액이 부족합니다.");
    }
}
