package com.lotto.view;

import com.lotto.domain.vo.winLotto.Ranking;

import com.lotto.view.dto.LottoDto;

import java.util.List;

public class OutputView {

    private static final String LINE = "-----------";

    public void displayLottoTickets(List<LottoDto> tickets) {
        for (LottoDto ticket : tickets) {
            System.out.println(ticket.getLotto());
        }
    }

    public void displayWinning(Ranking ranking) {
        if (ranking != Ranking.ERROR) {
            System.out.printf("%s (%,d원)\n", ranking.getMessage(), ranking.getPrice());
        } else {
            System.out.println("당첨 결과가 없습니다.");
        }
    }

    public void displayRateOfReturn(double rateOfReturn) {
        System.out.println(LINE);
        System.out.printf("총 수익률은 %.2f입니다.\n", rateOfReturn);
    }
}
