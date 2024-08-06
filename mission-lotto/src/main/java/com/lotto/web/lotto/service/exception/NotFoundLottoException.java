package com.lotto.web.lotto.service.exception;

import com.lotto.web.global.exception.exceptions.CustomErrorCode;
import com.lotto.web.global.exception.exceptions.CustomException;

public class NotFoundLottoException extends CustomException {
    public NotFoundLottoException() {
        super(CustomErrorCode.EXCEPTION_LOTTO);
    }
}
