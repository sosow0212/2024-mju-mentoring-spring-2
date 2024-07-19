package com.lotto.domain.vo.exception;

public class BoundaryException extends RuntimeException {
    public BoundaryException(){
        super("로또 티켓 크기는 6이 넘으면 안된다.");
    }
}
