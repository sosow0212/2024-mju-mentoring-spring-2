package com.lotto.web.domain;

public class LottoRank {

    private final int count;

    public LottoRank(int count) {
        this.count = count;
    }

    public int getCount(){
        return count;
    }

    private int countLottoNumber(){
        return 1;
    }
}
