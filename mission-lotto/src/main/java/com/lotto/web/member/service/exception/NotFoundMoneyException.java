package com.lotto.web.member.service.exception;

import com.lotto.web.exception.domain.CustomErrorCode;
import com.lotto.web.exception.domain.CustomException;

public class NotFoundMoneyException extends CustomException {
    public NotFoundMoneyException() {
        super(CustomErrorCode.EXCEPTION_MONEY);
    }
}
