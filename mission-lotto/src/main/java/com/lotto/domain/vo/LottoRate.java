package com.lotto.domain.vo;

import java.util.List;

public class LottoRate {

    private int sum = 0;

    public List<LottoPrice> matchesMoney() {
        return List.of(LottoPrice.values());
    }

    private double doublecalculateLottoRate(int money) {
        for (LottoPrice price : matchesMoney()) {
            sum += price.getPriceMoney();
        }
        return (double) sum / money;
    }
}
