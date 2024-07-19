package com.lotto.domain;

import com.lotto.domain.vo.LottoNumber;
import com.lotto.domain.vo.RandomNumberGenerator;

import java.util.ArrayList;
import java.util.List;

public class Lottos {

    private final RandomNumberGenerator randomNumberGenerator;

    public Lottos(RandomNumberGenerator randomNumberGenerator) {
        this.randomNumberGenerator = randomNumberGenerator;
    }

    public List<Lotto> generateLottos(int ticektCount) {
        List<Lotto> lottos = new ArrayList<>();
        return getLottos(ticektCount, lottos);
    }

    private List<Lotto> getLottos(int ticektCount, List<Lotto> lottos) {
        for (int i = 0; i < ticektCount; i++) {
            lottos.add(LottoNumber.from(randomNumberGenerator));
        }
        return lottos;
    }

    private int winningLotto(List<Integer> lottoNumbers, List<Integer> winNumbers) {
        int count = 0;
        for (int number : lottoNumbers) {
            if (winNumbers.contains(number)) {
                count++;
            }
        }
        return count;
    }
}
