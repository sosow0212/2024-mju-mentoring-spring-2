package com.lotto.web.lotto.dto;

import com.lotto.web.lotto.dto.exception.NotFoundLottoException;

import java.util.List;

public record LottoResponses(List<LottoResponse> lottoResponses) {

    public static LottoResponses form(List<LottoResponse> lottoResponses) {
        validateLottoExist(lottoResponses);
        return new LottoResponses(lottoResponses);
    }

    public static LottoResponses of(LottoResponses lottoResponses, int order) {
        validateLottoOrder(lottoResponses, order);
        return new LottoResponses(lottoResponses.lottoResponses());
    }

    private static void validateLottoExist(List<LottoResponse> lottoResponses) {
        if (lottoResponses.isEmpty()) {
            throw new NotFoundLottoException();
        }
    }

    private static void validateLottoOrder(LottoResponses lottoResponses, int order) {
        if (order < 1 || order > lottoResponses.lottoResponses().size()) {
            throw new NotFoundLottoException();
        }
    }
}
