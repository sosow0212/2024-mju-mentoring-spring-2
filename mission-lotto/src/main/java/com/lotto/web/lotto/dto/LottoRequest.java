package com.lotto.web.lotto.dto;

import com.lotto.web.lotto.entity.LottoEntity;
import com.lotto.web.member.entity.Member;

public record LottoRequest(int count, Long userId) {

    public LottoEntity toLottoEntity(Member member, String lottoNumber, boolean win) {
        return new LottoEntity(member, lottoNumber, win);
    }
}
