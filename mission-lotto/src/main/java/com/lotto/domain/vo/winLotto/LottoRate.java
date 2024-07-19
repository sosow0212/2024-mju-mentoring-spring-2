package com.lotto.domain.vo.winLotto;

import com.lotto.domain.Lotto;

import java.util.List;

public class LottoRate {

    private final List<Lotto> tickets;
    private final WinningLotto winningLotto;

    public LottoRate(final List<Lotto> tickets, final WinningLotto winningLotto) {
        this.tickets = tickets;
        this.winningLotto = winningLotto;
    }

    public double calculateRateOfReturn(int payMoney) {
        int totalWinnings = tickets.stream()
                .mapToInt(ticket -> {
                    int matchedNumbers = winningLotto.getCount(ticket.getLotto());
                    int matchedBonusNumbers = winningLotto.getBonusCount(ticket.getLotto());
                    return Ranking.valueOfCount(matchedNumbers, matchedBonusNumbers).getPrice();
                }).sum();
        return (double) totalWinnings / payMoney;
    }
}
