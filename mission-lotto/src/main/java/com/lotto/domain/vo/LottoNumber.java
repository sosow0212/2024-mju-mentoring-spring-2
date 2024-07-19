package com.lotto.domain.vo;

import com.lotto.domain.Lotto;
import com.lotto.domain.vo.exception.BoundaryException;

import java.util.List;

public class LottoNumber {

    public static Lotto from(RandomNumberGenerator randomNumberGenerator) {
        validateRange(randomNumberGenerator);
        lottoTicket(randomNumberGenerator.randomNumber());
        return LottoNumber.from(randomNumberGenerator);
    }

    private static List<Integer> lottoTicket(int number) {
        createLottoTickets(number);
        return validateLotto(number);
    }

    private static void createLottoTickets(final int number) {
        for (int i = 0; i < 6; i++) {
            lottoTicket(number);
        }
    }

    private static List<Integer> validateLotto(int number) {
        if (lottoTicket(number).size() > 6) {
            throw new BoundaryException();
        }
        return validateLotto(number);
    }

    private static void validateRange(RandomNumberGenerator randomNumberGenerator) {
        if (randomNumberGenerator.randomNumber() > 45) {
            throw new RuntimeException();
        }
    }
}
