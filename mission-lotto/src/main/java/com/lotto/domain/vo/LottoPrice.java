package com.lotto.domain.vo;

public enum LottoPrice{

    THREE_MATCHES(5000),
    FOUR_MATCHES(50000),
    FIVE_MATCHES(150000),
    SIX_MATCHES(20000000);

    private final int priceMoney;

    LottoPrice(final int priceMoney) {
        this.priceMoney = priceMoney;
    }

    public int getPriceMoney() {
        return priceMoney;
    }
}