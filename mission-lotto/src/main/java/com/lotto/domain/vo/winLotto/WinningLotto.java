package com.lotto.domain.vo.winLotto;

import java.util.List;

public class WinningLotto {

    private static final int INITIAL_NUMBER = 0;

    private final List<Integer> winNumbers;
    private final int bonusNumber;

    public WinningLotto(List<Integer> winNumbers, int bonusNumber) {
        this.winNumbers = winNumbers;
        this.bonusNumber = bonusNumber;
    }

    public int getCount(List<Integer> ticketNumbers) {
        int count = INITIAL_NUMBER;
        for (int number : ticketNumbers) {
            count = resultContainWinNumber(number, count);
        }
        return count;
    }

    private int resultContainWinNumber(final int number, int count) {
        if (winNumbers.contains(number)) {
            count++;
        }
        return count;
    }

    public int getBonusCount(List<Integer> ticketNumbers) {
        return ticketNumbers.contains(bonusNumber) ? 1 : 0;
    }
}
