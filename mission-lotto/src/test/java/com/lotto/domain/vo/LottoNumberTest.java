package com.lotto.domain.vo;

import com.lotto.domain.vo.exception.BoundaryLottoSizeException;

import com.lotto.domain.vo.lottoNumber.LottoNumber;
import com.lotto.domain.vo.lottoNumber.RandomNumberGenerator;

import org.junit.jupiter.api.Test;

import java.util.Set;

import static org.junit.jupiter.api.Assertions.assertAll;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;


class LottoNumberTest {

    @Test
    void 로또_생성_테스트() {
        // given
        RandomNumberGenerator rng = new RandomNumberGenerator();

        // when
        Set<Integer> numbers = LottoNumber.generateNumbers(rng);

        // then
        assertAll(
                () -> assertEquals(6, numbers.size(), "로또 번호는 6개여야 합니다."),
                () -> assertTrue(numbers
                        .stream()
                        .allMatch(n -> n >= 1 && n <= 45), "로또 번호는 1에서 45 사이여야 합니다.")
        );
    }

    @Test
    void 로또번호_검증_예외_테스트() {
        // given
        int invalidNumber = 46;

        // then
        assertThrows(BoundaryLottoSizeException.class,
                () -> LottoNumber.validateLottoNumber(invalidNumber));
    }
}
