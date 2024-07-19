package com.lotto.domain.vo.exception;

public class BoundaryLottoSizeException extends RuntimeException {
    public BoundaryLottoSizeException() {
        super("로또숫자들은 45 이하다");
    }
}
