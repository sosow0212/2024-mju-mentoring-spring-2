package com.lotto.entity.exception;

public class NotEnoughMoneyException extends IllegalArgumentException{

    public NotEnoughMoneyException() {
        super("금액이 부족합니다.");
    }

}