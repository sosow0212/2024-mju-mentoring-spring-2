package com.lotto.domain.vo.winLotto;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertAll;
import static org.junit.jupiter.api.Assertions.assertEquals;


class RankingTest {

    @Test
    void 랭킹_계산_테스트() {

        // given&when
        Ranking first = Ranking.valueOfCount(6, 0);
        Ranking second = Ranking.valueOfCount(5, 1);
        Ranking third = Ranking.valueOfCount(5, 0);
        Ranking fourth = Ranking.valueOfCount(4, 0);
        Ranking fifth = Ranking.valueOfCount(3, 0);
        Ranking error = Ranking.valueOfCount(0, 0);

        // then
        assertAll(
                () -> assertEquals(Ranking.FIRST, first),
                () -> assertEquals(Ranking.SECOND, second),
                () -> assertEquals(Ranking.THIRD, third),
                () -> assertEquals(Ranking.FOURTH, fourth),
                () -> assertEquals(Ranking.FIFTH, fifth),
                () -> assertEquals(Ranking.ERROR, error)
        );
    }
}
