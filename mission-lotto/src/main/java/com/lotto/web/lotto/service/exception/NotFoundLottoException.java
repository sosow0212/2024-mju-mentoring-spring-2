package com.lotto.web.lotto.service.exception;

import com.lotto.web.exception.domain.CustomErrorCode;
import com.lotto.web.exception.domain.CustomException;

public class NotFoundLottoException extends CustomException {
    public NotFoundLottoException() {
        super(CustomErrorCode.EXCEPTION_LOTTO);
    }
}
