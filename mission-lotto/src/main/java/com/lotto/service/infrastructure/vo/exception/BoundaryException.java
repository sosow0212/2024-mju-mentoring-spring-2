package com.lotto.service.infrastructure.vo.exception;

public class BoundaryException extends RuntimeException {
    public BoundaryException() {
        super("로또 크기는 6이하");
    }
}
