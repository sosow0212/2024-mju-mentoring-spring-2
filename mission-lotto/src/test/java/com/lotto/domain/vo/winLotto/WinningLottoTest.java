package com.lotto.domain.vo.winLotto;

import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;


class WinningLottoTest {

    @Test
    void 당첨번호_개수_테스트() {

        // given
        List<Integer> winNumbers = Arrays.asList(1, 2, 3, 4, 5, 6);
        int bonusNumber = 7;
        WinningLotto winningLotto = new WinningLotto(winNumbers, bonusNumber);
        List<Integer> ticketNumbers = Arrays.asList(1, 2, 3, 4, 5, 7);

        // when
        int count = winningLotto.getCount(ticketNumbers);

        // then
        assertEquals(5, count);
    }

    @Test
    void 보너스번호_개수_테스트() {

        // given
        List<Integer> winNumbers = Arrays.asList(1, 2, 3, 4, 5, 6);
        int bonusNumber = 7;
        WinningLotto winningLotto = new WinningLotto(winNumbers, bonusNumber);
        List<Integer> ticketNumbers = Arrays.asList(1, 2, 3, 4, 5, 7);

        // when
        int count = winningLotto.getBonusCount(ticketNumbers);

        // then
        assertEquals(1, count);
    }
}
