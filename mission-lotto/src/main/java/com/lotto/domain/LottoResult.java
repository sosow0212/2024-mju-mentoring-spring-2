package com.lotto.domain;

import java.util.List;

public class LottoResult {

    private final List<Integer> lottoNumbers;
    private final List<Integer> winNumbers;
    private final LottoRank rank;

    public LottoResult(List<Integer> lottoNumbers, List<Integer> winNumbers) {
        this.lottoNumbers = lottoNumbers;
        this.winNumbers = winNumbers;
        this.rank = calculateRank();
    }

    private LottoRank calculateRank() {
        int matchCount = 0;
        for (Integer number : lottoNumbers) {
            matchCount = getMatchCount(matchCount, number);
        }
        return LottoRank.getRank(matchCount);
    }

    private int getMatchCount(int matchCount, Integer number) {
        if (winNumbers.contains(number)) {
            matchCount++;
        }
        return matchCount;
    }

    public LottoRank getLottoRank() {
        return rank;
    }

}
