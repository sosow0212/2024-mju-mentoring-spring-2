package com.lotto.view.dto;


import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class ProcessingRequestMoneyTest {

    @Test
    void 티켓_갯수_생성_테스트() {

        // given
        ProcessingRequestMoney processingRequestMoney = new ProcessingRequestMoney();

        // when
        int result =processingRequestMoney.count(5000);
        int expect =5;

        // then
        Assertions.assertEquals(result,expect);
    }
}