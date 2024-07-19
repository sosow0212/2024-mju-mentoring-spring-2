package com.lotto.view.dto.exception;

public class MinusMoneyException extends RuntimeException{

    public MinusMoneyException() {
        super("로또를 구매할 돈은 음수가 될 수 없다.");
    }

}
