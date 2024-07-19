package com.lotto.view.dto;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.List;


class WinningNumberResponseTest {

    @Test
    void 지난주_당첨금_테스트 () {

        // given
        WinningNumberResponse winningNumberResponse = new WinningNumberResponse();

        // when
        List<Integer> expect =winningNumberResponse.response("1,2,3,4,5,6");
        List<Integer> result = List.of(1,2,3,4,5,6);

        // then
        Assertions.assertEquals(result,expect);
    }
}