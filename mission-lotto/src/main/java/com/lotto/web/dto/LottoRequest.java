package com.lotto.web.dto;

import com.lotto.web.entity.LottoEntity;
import com.lotto.web.entity.User;

public class LottoRequest {

    private final int count;
    private final Long userId;

    public LottoRequest(int count, Long userId) {
        this.count = count;
        this.userId = userId;
    }

    public LottoEntity toLottoEntity(User user, String lottoNumber) {
        return new LottoEntity(null, user, lottoNumber);
    }

    public Long getUserId(){
        return userId;
    }

    public int getCount() {
        return count;
    }
}
