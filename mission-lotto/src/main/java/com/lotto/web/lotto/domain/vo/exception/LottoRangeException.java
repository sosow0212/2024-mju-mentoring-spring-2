package com.lotto.web.lotto.domain.vo.exception;

import com.lotto.web.exception.domain.CustomErrorCode;
import com.lotto.web.exception.domain.CustomException;

public class LottoRangeException extends CustomException {
    public LottoRangeException() {
        super(CustomErrorCode.EXCEPTION_RANGE);
    }
}
