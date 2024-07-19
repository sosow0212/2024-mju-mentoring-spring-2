package com.lotto.view.dto;

import java.util.List;

public class LottoDto {

    private final List<Integer> lotto;

    public LottoDto(List<Integer> lotto) {
        this.lotto = lotto;
    }

    public List<Integer> getLotto() {
        return lotto;
    }
}
