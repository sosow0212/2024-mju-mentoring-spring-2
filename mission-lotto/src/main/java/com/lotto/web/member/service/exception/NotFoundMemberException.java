package com.lotto.web.member.service.exception;

import com.lotto.web.exception.domain.CustomErrorCode;
import com.lotto.web.exception.domain.CustomException;

public class NotFoundMemberException extends CustomException {
    public NotFoundMemberException() {
        super(CustomErrorCode.EXCEPTION_USER);
    }
}
