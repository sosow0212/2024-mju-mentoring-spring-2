package com.lotto.domain.vo.lottoNumber;

import com.lotto.domain.vo.exception.BoundaryLottoSizeException;

import java.util.HashSet;
import java.util.Set;

public class LottoNumber {

    private static final int MIN_NUMBER = 1;
    private static final int MAX_NUMBER = 45;
    private static final int LOTTO_SIZE = 6;

    public static Set<Integer> generateNumbers(RandomNumberGenerator randomNumberGenerator) {
        Set<Integer> lottoNumbers = new HashSet<>();
        Lotto(randomNumberGenerator, lottoNumbers);
        return lottoNumbers;
    }

    private static void Lotto(final RandomNumberGenerator randomNumberGenerator, final Set<Integer> lottoNumbers) {
        while (lottoNumbers.size() < LOTTO_SIZE) {
            int number = randomNumberGenerator.randomNumber();
            validateLottoNumber(number);
            lottoNumbers.add(number);
        }
    }

    private static void validateLottoNumber(int number) {
        if (number < MIN_NUMBER || number > MAX_NUMBER) {
            throw new BoundaryLottoSizeException();
        }
    }
}
