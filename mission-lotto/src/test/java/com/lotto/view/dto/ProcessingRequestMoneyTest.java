package com.lotto.view.dto;

import com.lotto.view.dto.exception.MinusMoneyException;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ProcessingRequestMoneyTest {

    @Test
    void 티켓_개수_계산_테스트() {
        // given
        int amount = 5000;

        // when
        int ticketCount = ProcessingRequestMoney.countTickets(amount);

        // then
        assertEquals(5, ticketCount);

    }

    @Test
    void 티켓_개수_계산_예외_테스트() {
        // given
        int amount = -1000;

        // when& then
        assertThrows(MinusMoneyException.class, () -> ProcessingRequestMoney.countTickets(amount));

    }
}
