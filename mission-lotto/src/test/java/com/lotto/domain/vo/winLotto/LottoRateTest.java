package com.lotto.domain.vo.winLotto;

import com.lotto.domain.Lotto;

import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;


class LottoRateTest {

    @Test
    void 수익률_계산_테스트() {

        // given
        List<Integer> winNumbers = Arrays.asList(1, 2, 3, 4, 5, 6);
        int bonusNumber = 7;
        WinningLotto winningLotto = new WinningLotto(winNumbers, bonusNumber);

        List<Lotto> tickets = Arrays.asList(
                new Lotto(Arrays.asList(1, 2, 3, 4, 5, 6)),
                new Lotto(Arrays.asList(1, 2, 3, 4, 5, 7))
        );
        LottoRate lottoRate = new LottoRate(tickets, winningLotto);

        // when
        double rateOfReturn = lottoRate.calculateRateOfReturn(2000);

        // then
        assertEquals(1015000.0, rateOfReturn);

    }
}
