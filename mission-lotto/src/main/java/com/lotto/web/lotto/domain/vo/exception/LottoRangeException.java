package com.lotto.web.lotto.domain.vo.exception;

import com.lotto.web.global.exception.exceptions.CustomErrorCode;
import com.lotto.web.global.exception.exceptions.CustomException;

public class LottoRangeException extends CustomException {
    public LottoRangeException() {
        super(CustomErrorCode.EXCEPTION_RANGE);
    }
}
