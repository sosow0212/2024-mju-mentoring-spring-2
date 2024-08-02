package com.lotto.entity.exception;

public class InvalidUser extends IllegalArgumentException{

    public InvalidUser() {
        super("잘못된사용자입니다.");
    }

}