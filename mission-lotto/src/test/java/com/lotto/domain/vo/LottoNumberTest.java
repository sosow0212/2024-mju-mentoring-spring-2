package com.lotto.domain.vo;

import com.lotto.domain.Lotto;
import com.lotto.domain.vo.lottoNumber.LottoNumber;
import com.lotto.domain.vo.lottoNumber.RandomNumberGenerator;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

class LottoNumberTest {

    @Test
    void 로또_생성_테스트() {

        //given
        RandomNumberGenerator rng = new RandomNumberGenerator();
        Lotto lotto = LottoNumber.from(rng);

        //when
        List<Integer> numbers = lotto.getLotto();

        //then
        assertEquals(6, numbers.size());
        assertTrue(numbers.stream().allMatch(n -> n >= 1 && n <= 45));

    }

}
