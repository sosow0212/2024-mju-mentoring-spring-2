package com.lotto.web.lotto.mapper;

import com.lotto.web.lotto.dto.LottoResponse;
import com.lotto.web.lotto.dto.LottoResponses;
import com.lotto.web.lotto.entity.LottoEntity;
import com.lotto.web.member.entity.Member;

import java.util.List;

public class LottoMapper {

    public static LottoEntity toLottoEntity(Member member, String lottoNumber, boolean win) {
        return new LottoEntity(member, lottoNumber, win);
    }

    public static LottoResponse toLottoResponse(LottoEntity lottoEntity) {
        return new LottoResponse(lottoEntity.getLottoNumber(), lottoEntity.getWin());
    }

    public static LottoResponses toLottoResponses(List<LottoResponse> lottoResponses) {
        return LottoResponses.form(lottoResponses);
    }
}
