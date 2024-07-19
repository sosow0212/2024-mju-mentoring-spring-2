package com.lotto.view;


import com.lotto.view.dto.LottoDto;

import java.util.List;

public class OutputView {

    public void displayLottoTickets(List<LottoDto> tickets) {
        for (LottoDto ticket : tickets) {
            System.out.println(ticket);
        }
    }

}
