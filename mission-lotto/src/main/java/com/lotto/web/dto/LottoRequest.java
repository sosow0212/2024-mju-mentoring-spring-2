package com.lotto.web.dto;

import com.lotto.web.entity.LottoEntity;
import com.lotto.web.entity.User;

public record LottoRequest(int count, Long userId) {

    public LottoEntity toLottoEntity(User user, String lottoNumber, boolean win) {
        return new LottoEntity(null, user, lottoNumber, win);
    }
}
