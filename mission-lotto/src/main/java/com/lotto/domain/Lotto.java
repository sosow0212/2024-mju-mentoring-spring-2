package com.lotto.domain;

import java.util.List;

public class Lotto {

    private List<Integer> lottoNumbers;

    public Lotto(List<Integer> lottoNumbers) {
        this.lottoNumbers = lottoNumbers;
    }

    public static Lotto createLotto(RandomNumber randomNumber) {
        return new Lotto(randomNumber.createRandomNumber());
    }

    public List<Integer> getLottoNumbers() {
        return lottoNumbers;
    }
}
