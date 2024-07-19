package com.lotto.view.dto;

import com.lotto.view.dto.exception.MinusMoneyException;

public class ProcessingRequestMoney {

    private static final int TICKET_PRICE = 1000;

    public static int calculateRemainingMoney(int amount, int count) {
        if (amount <= 0) {
            throw new MinusMoneyException();
        }
        return amount - (TICKET_PRICE * count);
    }

    public static int countTickets(int amount) {
        if (amount < 0) {
            throw new MinusMoneyException();
        }
        return amount / TICKET_PRICE;
    }
}
