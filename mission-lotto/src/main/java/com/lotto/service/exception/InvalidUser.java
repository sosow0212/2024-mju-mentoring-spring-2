package com.lotto.service.exception;

public class InvalidUser extends IllegalArgumentException{
    public InvalidUser() {
        super("잘못된사용자입니다.");
    }
}
